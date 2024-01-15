package com.example.scd_proiect.employee;

import com.example.scd_proiect.department.DepartmentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public List<EmployeeEntity> getAllEmployees() {
        return employeeService.getAllEmployee();
    }

    @PostMapping("/employee/{id}")
    public EmployeeEntity getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/create-employee")
    public void createEmployee(@RequestBody EmployeeEntity entity) {
        employeeService.createEmployee(entity);
    }

    @PutMapping("/update-employee")
    public void updateEmployee(@RequestBody UpdateEmployee updateEmployee) {
        employeeService.updateEmployeeEmail(updateEmployee.getEntity(), updateEmployee.getEmail());
    }

    @DeleteMapping("/delete-employee")
    public void  deleteEmployee(@RequestBody EmployeeEntity entity) {
        employeeService.deleteEmployee(entity);
    }

    @PostMapping("/employee-by-departments")
    public List<EmployeeEntity> getAllEmployeeByDepartments(@RequestBody DepartmentEntity departmentEntity){
        return this.employeeService.getAllEmployeeByDepartment(departmentEntity);
    }

    @PostMapping("/manager-by-departments")
    public List<EmployeeEntity> getAllManagersByDepartments(@RequestBody GetAllManagersByDepartmentRequest allManagersByDepartmentRequest) {
        return this.employeeService.getAllManagersPerDepartment(allManagersByDepartmentRequest.getManager(), allManagersByDepartmentRequest.getDepartmentEntity());
    }
}
