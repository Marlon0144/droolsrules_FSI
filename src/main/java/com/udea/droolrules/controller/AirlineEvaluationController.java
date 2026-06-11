package com.udea.droolrules.controller;

import com.udea.droolrules.model.AirlineRequest;
import com.udea.droolrules.model.AirlineResponse;
import com.udea.droolrules.service.AirlineEvaluationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airline")
public class AirlineEvaluationController {

    @Autowired
    private AirlineEvaluationService evaluationService;

    // Endpoint REST principal: evalúa las reglas de negocio para un pasajero y vuelo
    @PostMapping("/api/evaluate")
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
    // Endpoints de vistas Thymeleaf — comentados temporalmente.
    // Se habilitarán en la siguiente fase de desarrollo (UI web).
    // ---------------------------------------------------------------

    // @GetMapping("/form")
    // public String showAirlineForm(Model model) {
    //     model.addAttribute("airlineRequest", new AirlineRequest());
    //     return "airline_form";
    // }

    // @PostMapping("/evaluate")
    // public String evaluateAirlineWeb(@Valid AirlineRequest request, BindingResult result, Model model) {
    //     if (result.hasErrors()) {
    //         return "airline_form";
    //     }
    //     AirlineResponse response = evaluationService.evaluateAirlineRules(request);
    //     model.addAttribute("airlineResponse", response);
    //     return "airline_result";
    // }
}
