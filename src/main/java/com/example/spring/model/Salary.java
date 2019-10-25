package com.example.spring.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Getter
@Setter
public class Salary {
    private Integer id;
    private Integer bonus;
    private Integer lunchSalary;
    private Integer trafficSalary;
    private Integer basicSalary;
    private Integer allSalary;
    private Integer pensionBase;
    private Float pensionPer;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createDate;
    private Integer medicalBase;
    private Float medicalPer;
    private Integer accumulationFundBase;
    private Float accumulationFundPer;
    private String name;

}
