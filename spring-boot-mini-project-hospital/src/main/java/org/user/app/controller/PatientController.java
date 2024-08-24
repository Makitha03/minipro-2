package org.user.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Corrected import for Model
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.user.app.model.Patient;
import org.user.app.service.PatientService;

import jakarta.validation.Valid;

@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    // Display first form view
    @GetMapping("/hospital")
    public String showPatientList(Model model) {
        return "firstform"; // Return Thymeleaf template for the first form
    }
    @GetMapping("/Ind1")
    public String showfirstform(Model model) {
        return "index"; // Return Thymeleaf template for the first form
    }

    // Display patient list
    @GetMapping("/medici")
    public String userList3(Model model) {
        model.addAttribute("medici", this.patientService.getUsers());
        return "patientform"; // Return Thymeleaf template for listing patients
    }

    // Display patient registration form
    @GetMapping("/user3")
    public String showPatientList1(Model model) {
        model.addAttribute("user3", new Patient());
        return "register"; // Return Thymeleaf template for patient registration
    }

    // Process patient registration
    @PostMapping("/process3")
    public String addUserProcess1(@Valid Patient patient, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register"; // Return to registration form if validation fails
        }
        this.patientService.addPatient(patient);
        return "redirect:/medici"; // Redirect to patient list after successful registration
    }

    // View patient details by ID
    @GetMapping("/view3/{id}")
    public String viewAppointmentSlots1(@PathVariable("id") String id, Model model) {
        Optional<Patient> patient = this.patientService.getPatientById(id);
        if (patient.isPresent()) {
            model.addAttribute("user3", patient.get());
            return "regpatient"; // Return Thymeleaf template for viewing patient details
        } else {
            return "error"; // Return error page if patient not found
        }
    }

    // Update patient details by ID
    @GetMapping("/update3/{id}")
    public ModelAndView showUpdateUserForm1(@PathVariable("id") String id) {
        Optional<Patient> patient = this.patientService.getPatientById(id);
        ModelAndView modelAndView = new ModelAndView();

        if (patient.isPresent()) {
            modelAndView.setViewName("updatepatient");
            modelAndView.addObject("user3", patient.get());
            return modelAndView; // Return Thymeleaf template for updating patient details
        } else {
            modelAndView.setViewName("patientform"); // Return patient list if patient not found
            return modelAndView;
        }
    }

    // Delete patient by ID
    @RequestMapping("/delete3/{id}")
    public String deleteUser(@PathVariable("id") String id) throws Exception {
        Optional<Patient> patient = this.patientService.getPatientById(id);
        if (patient.isPresent()) {
            this.patientService.deletePatientById(id);
            return "redirect:/medici"; // Redirect to patient list after deletion
        } else {
            throw new Exception("Patient not found"); // Throw exception if patient not found
        }
    }
}
