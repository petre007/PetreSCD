package com.example.scd_proiect.employee;

import com.example.scd_proiect.department.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin("http://localhost:4200/")
public interface EmployeeDTO extends JpaRepository<EmployeeEntity, Integer> {

    List<EmployeeEntity> getEmployeeEntityByDepartment(DepartmentEntity departmentEntity);

    List<EmployeeEntity> getAllByManagerAndDepartment(EmployeeEntity manager, DepartmentEntity department);

}
