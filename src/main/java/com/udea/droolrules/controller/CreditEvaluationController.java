package com.udea.droolrules.controller;

import com.udea.droolrules.model.CreditRequest;
import com.udea.droolrules.model.CreditResponse;
import com.udea.droolrules.service.CreditEvaluationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/credit")
public class CreditEvaluationController {

@Autowired
    private CreditEvaluationService evaluationService;

//Endpoint REST
    @PostMapping("/api/evaluate")
    @ResponseBody
    public CreditResponse evaluateCreditApi(@Valid @RequestBody CreditRequest request, BindingResult result) {
        if(result.hasErrors()){
            String errorMessage = result.getAllErrors().stream()
                    .map(error-> error.getDefaultMessage())
                    .reduce((msg1,msg2)-> msg1 + "; " + msg2)
                    .orElse("Errores de validacion");
            return new CreditResponse(false,0.0,0.0,"Error de validacion: "+errorMessage);
        }
        return evaluationService.evaluateCredit(request);
    }


}
