package com.example.scd_proiect.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateEmployee {

    private EmployeeEntity entity;
    private String email;

}
