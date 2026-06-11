package com.udea.droolrules.controller;

import com.udea.droolrules.model.AirlineRequest;
import com.udea.droolrules.model.AirlineResponse;
import com.udea.droolrules.model.Flight;
import com.udea.droolrules.model.Passenger;
import com.udea.droolrules.service.AirlineEvaluationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/airline")
public class AirlineEvaluationController {

    @Autowired
    private AirlineEvaluationService evaluationService;

    // ---------------------------------------------------------------
    // Endpoint REST — devuelve JSON
    // ---------------------------------------------------------------

    @PostMapping("/api/evaluate")
    @ResponseBody
    public AirlineResponse evaluateAirlineApi(@Valid @RequestBody AirlineRequest request, BindingResult result) {
        if (result.hasErrors()) {
            String errorMessage = result.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .reduce((msg1, msg2) -> msg1 + "; " + msg2)
                    .orElse("Error de validación desconocido");
            AirlineResponse errorResponse = new AirlineResponse();
            errorResponse.getMessages().add("Error de validación: " + errorMessage);
            return errorResponse;
        }
        return evaluationService.evaluateAirlineRules(request);
    }

    // ---------------------------------------------------------------
    // Endpoints de vistas Thymeleaf
    // ---------------------------------------------------------------

    // Muestra el formulario web con objetos Passenger y Flight pre-inicializados
    // para evitar NullPointerException al hacer binding con th:field
    @GetMapping("/form")
    public String showAirlineForm(Model model) {
        AirlineRequest airlineRequest = new AirlineRequest();
        airlineRequest.setPassenger(new Passenger());
        airlineRequest.setFlight(new Flight());
        model.addAttribute("airlineRequest", airlineRequest);
        return "airline_form";
    }

    // Procesa el formulario web y muestra la página de resultados
    @PostMapping("/evaluate")
    public String evaluateAirlineWeb(@Valid @ModelAttribute AirlineRequest request,
                                     BindingResult result,
                                     Model model) {
        if (result.hasErrors()) {
            return "airline_form";
        }
        AirlineResponse airlineResponse = evaluationService.evaluateAirlineRules(request);
        model.addAttribute("airlineResponse", airlineResponse);
        return "airline_result";
    }
}
