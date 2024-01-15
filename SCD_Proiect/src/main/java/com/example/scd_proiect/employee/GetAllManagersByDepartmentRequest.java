package com.example.scd_proiect.employee;

import com.example.scd_proiect.department.DepartmentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllManagersByDepartmentRequest {

    private EmployeeEntity manager;
    private DepartmentEntity departmentEntity;

}
