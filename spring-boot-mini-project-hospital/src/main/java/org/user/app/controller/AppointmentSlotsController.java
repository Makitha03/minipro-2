package org.user.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.user.app.model.AppointmentSlots;
import org.user.app.service.AppointmentSlotsService;

import jakarta.validation.Valid;
import java.util.Optional;

@Controller
public class AppointmentSlotsController {

    @Autowired
    private AppointmentSlotsService appointmentSlotsService;

    // Display all appointment slots
    @GetMapping("/appointments")
    public String userList(Model model) {
        model.addAttribute("appointments", this.appointmentSlotsService.getUsers());
        return "appoint";
    }

    // Show form to add new appointment slot
    @GetMapping("/user1")
    public String showAddUserForm(Model model) {
        model.addAttribute("user1", new AppointmentSlots());
        return "add-user1";
    }

    // Process form for adding a new appointment slot
    @PostMapping("/process1")
    public String addUserProcess1(@Valid @ModelAttribute("user1") AppointmentSlots appointmentSlots, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user1"; // Return to the form page if validation errors exist
        }

        try {
            this.appointmentSlotsService.addAppointmentSlots(appointmentSlots);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to save appointment slot", e);
        }

        return "redirect:/appointments";
    }

    // View details of a specific appointment slot by ID
    @GetMapping("/view1/{id}")
    public String viewAppointmentSlots1(@PathVariable("id") String id, Model model) {
        Optional<AppointmentSlots> appointmentOpt = this.appointmentSlotsService.getAppointmentSlotsById(id);

        if (appointmentOpt.isPresent()) {
            model.addAttribute("user1", appointmentOpt.get());
            return "appoint-view";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Appointment slot with ID " + id + " not found");
        }
    }

    // Exception handler for handling validation and other custom exceptions globally
    @ExceptionHandler({ ResponseStatusException.class })
    public String handleResponseStatusException(ResponseStatusException ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        model.addAttribute("status", ex.getStatusCode());
        return "appoint"; // Redirect to a custom error page (ensure you have an error.html page)
    }

}
