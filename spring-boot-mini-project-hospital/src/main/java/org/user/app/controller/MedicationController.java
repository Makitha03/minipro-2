package org.user.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import org.user.app.model.Medication;
import org.user.app.service.MedicationService;

import jakarta.validation.Valid;

@Controller
public class MedicationController {

    @Autowired
    private MedicationService medicationService;

    // View all medications
    @GetMapping("/medications")
    public String userList(Model model) {
        try {
            model.addAttribute("medications", medicationService.getUsers());
            return "medical";
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error fetching medications", e);
        }
    }

    // Show add medication form
    @GetMapping("/user2")
    public String showAddUserForm(Model model) {
        model.addAttribute("user2", new Medication());
        return "add-user2";
    }

    // Process the add medication form
    @PostMapping("/process2")
    public String addUserProcess1(@Valid @ModelAttribute("user2") Medication medication, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user2";
        }
        try {
            medicationService.addMedication(medication);
            return "redirect:/medications";
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error saving medication", e);
        }
    }

    // View a specific medication by ID
    @GetMapping("/view2/{id}")
    public String viewAppointmentSlots2(@PathVariable("id") String id, Model model) {
        try {
            Optional<Medication> medication = medicationService.getMedicationById(id);
            if (medication.isPresent()) {
                model.addAttribute("user2", medication.get());
                return "medic-view";
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Medication with ID " + id + " not found");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error fetching medication", e);
        }
    }

    // Show the update form for a specific medication
    @GetMapping("/update2/{id}")
    public ModelAndView showUpdateUserForm1(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Optional<Medication> medication = medicationService.getMedicationById(id);
            if (medication.isPresent()) {
                modelAndView.setViewName("medication-update");
                modelAndView.addObject("user2", medication.get());
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Medication with ID " + id + " not found");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error fetching medication for update", e);
        }
        return modelAndView;
    }

    // Delete a specific medication by ID
    @DeleteMapping("/delete2/{id}")
    public String deleteMedication(@PathVariable("id") String id) {
        try {
            Optional<Medication> medication = medicationService.getMedicationById(id);
            if (medication.isPresent()) {
                medicationService.deleteMedicationById(id);
                return "redirect:/medications";
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Medication with ID " + id + " not found");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error deleting medication", e);
        }
    }
}
