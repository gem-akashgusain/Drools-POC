package com.example.Drools;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    @PostMapping("/get-insurance-plan")
    public ResponseEntity<?> getInsurancePlan(@RequestBody InsuranceRequest request) {
        try {
        log.info("Received request for user with Age: {}, Income: {}, Qualification: {}, sumAssuredLimit: {}," +
                "and  premiumToSumRatio: {}", request.getAge(), request.getIncome(), request.getEducation()
        ,request.getSumAssuredLimit(), request.getPremiumToSumRatio());
            InsurancePlanResponse response = insuranceService.getInsurancePlan(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing insurance plan: " + e);
        }
    }
}
