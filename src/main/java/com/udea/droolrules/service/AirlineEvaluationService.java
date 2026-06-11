package com.udea.droolrules.service;

import com.udea.droolrules.model.AirlineRequest;
import com.udea.droolrules.model.AirlineResponse;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirlineEvaluationService {

    @Autowired
    private KieContainer kieContainer;

    public AirlineResponse evaluateAirlineRules(AirlineRequest request) {
        // Crear una respuesta inicial con los valores por defecto definidos en AirlineResponse
        AirlineResponse response = new AirlineResponse();

        // Crear una sesión en Drools
        KieSession kieSession = kieContainer.newKieSession();
        try {
            // Insertar los hechos (request y response) en la sesión
            kieSession.insert(request.getPassenger());
            kieSession.insert(request.getFlight());
            kieSession.insert(request);
            kieSession.insert(response);
            // Ejecutar todas las reglas
            kieSession.fireAllRules();
        } finally {
            // Liberar la sesión siempre, incluso si ocurre una excepción
            kieSession.dispose();
        }
        return response;
    }
}
