package org.user.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import org.user.app.model.Doctor;
import org.user.app.service.DoctorService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;

@Controller
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Get all doctors and display in Thymeleaf template
    @GetMapping("/doctors")
    public String getAllDoctors(Model model) {
        try {
            model.addAttribute("doctors", doctorService.getUsers());
            return "doc"; // Thymeleaf HTML template name
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error retrieving doctors");
        }
    }

    // Show the add doctor form
    @GetMapping("/user")
    public String showAddDoctorForm(Model model) {
        model.addAttribute("user", new Doctor());
        return "add-user"; // Thymeleaf HTML template for adding a doctor
    }

    // Process the add doctor form submission
    @PostMapping("/process")
    public String addDoctor(@Valid @ModelAttribute("user") Doctor doctor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user"; // Return to the form if validation errors occur
        }
        try {
            doctorService.addDoctor(doctor);
            return "redirect:/doctors"; // Redirect to the list of doctors after adding
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error adding doctor");
        }
    }

    // View a specific doctor by ID
    @GetMapping("/view/{id}")
    public String viewDoctorById(@PathVariable("id") String id, Model model) {
        try {
            Optional<Doctor> doctor = doctorService.getDoctorById(id);
            if (doctor.isPresent()) {
                model.addAttribute("user", doctor.get());
                return "doctor-view"; // Thymeleaf HTML template for viewing a doctor
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor with ID " + id + " not found");
            }
        } catch (ResponseStatusException e) {
            throw e; // Re-throw ResponseStatusException so it's handled correctly
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error retrieving doctor");
        }
    }
}
