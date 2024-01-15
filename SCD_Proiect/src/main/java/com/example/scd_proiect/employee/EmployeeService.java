package com.example.scd_proiect.employee;

import com.example.scd_proiect.department.DepartmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeDTO employeeDTO;

    @Autowired
    public EmployeeService(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    @Transactional
    public List<EmployeeEntity> getAllEmployee() {
        return this.employeeDTO.findAll();
    }

    @Transactional
    public EmployeeEntity getEmployeeById(Integer id) {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeDTO.findById(id);

        return optionalEmployeeEntity.orElse(null);
    }

    @Transactional
    public void createEmployee(EmployeeEntity entity) {
        employeeDTO.save(entity);
    }

    @Transactional
    public void updateEmployeeEmail(EmployeeEntity entity, String email) {
        employeeDTO.save(new EmployeeEntity(
                entity.getId(),
                entity.getManager(),
                entity.getDepartment(),
                email
        ));
    }

    @Transactional
    public void deleteEmployee(EmployeeEntity entity) {
        employeeDTO.delete(entity);
    }

    @Transactional
    public List<EmployeeEntity> getAllEmployeeByDepartment(DepartmentEntity departmentEntity) {
        return this.employeeDTO.getEmployeeEntityByDepartment(departmentEntity);
    }

    @Transactional
    public List<EmployeeEntity> getAllManagersPerDepartment(EmployeeEntity manager, DepartmentEntity departmentEntity) {
        return this.getAllManagersPerDepartment(manager, departmentEntity);
    }
}
