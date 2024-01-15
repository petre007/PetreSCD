package com.example.scd_proiect.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentDTO departmentDTO;

    @Autowired
    public DepartmentService(DepartmentDTO departmentDTO) {
        this.departmentDTO = departmentDTO;
    }

    @Transactional
    public List<DepartmentEntity> getAllDepartments() {
        return departmentDTO.findAll();
    }

    @Transactional
    public DepartmentEntity getDepartmentById(Integer id) {
        Optional<DepartmentEntity> departmentEntityOptional = departmentDTO.findById(id);

        return departmentEntityOptional.orElse(null);

    }

    @Transactional
    public void createDepartment(DepartmentEntity departmentEntity) {
        departmentDTO.save(departmentEntity);
    }

    @Transactional
    public void updateDepartmentDescription(DepartmentEntity departmentEntity, String description) {
        DepartmentEntity departmentEntityUpdate = new DepartmentEntity(departmentEntity.getId(),
                description,
                departmentEntity.getParent(),
                departmentEntity.getDepartmentChildren());

        departmentDTO.save(departmentEntityUpdate);
    }

    @Transactional
    public void deleteDepartment(Integer id) {
        departmentDTO.deleteById(id);
    }

}
