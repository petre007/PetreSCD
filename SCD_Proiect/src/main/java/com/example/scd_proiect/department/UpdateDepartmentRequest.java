package com.example.scd_proiect.department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateDepartmentRequest {

    private DepartmentEntity entity;
    private String description;

}
