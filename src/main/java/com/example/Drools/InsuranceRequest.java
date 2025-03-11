package com.example.Drools;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsuranceRequest {
    private Integer age;
    private String education;  // Graduate / Postgraduate / Diploma / 11th / 12th
    private Double income;
    private long sumAssuredLimit;
    private Integer premiumToSumRatio;
}
