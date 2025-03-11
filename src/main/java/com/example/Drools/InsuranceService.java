package com.example.Drools;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceService {

    @Autowired
    private KieContainer kieContainer;

    public InsurancePlanResponse getInsurancePlan(InsuranceRequest request) {
        InsurancePlanResponse response = new InsurancePlanResponse();


        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("insurancePlanResponse", response);
        kieSession.insert(request);
        kieSession.fireAllRules();

        return response;
    }
}