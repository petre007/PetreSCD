package com.example.scd_proiect.department;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
public class DepartementController {

    private final DepartmentService departmentService;

    @GetMapping("/departments")
    public List<DepartmentEntity> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PostMapping("/department")
    public DepartmentEntity getDepartmentById(@RequestBody Integer id){
        return departmentService.getDepartmentById(id);
    }

    @PostMapping("/create_department")
    public void createDepartment(@RequestBody DepartmentEntity departmentEntity) {
        departmentService.createDepartment(departmentEntity);
    }

    @PutMapping("/update_department")
    public void updateDepartment(@RequestBody UpdateDepartmentRequest updateDepartmentRequest) {
        departmentService.updateDepartmentDescription(updateDepartmentRequest.getEntity(), updateDepartmentRequest.getDescription());
    }

    @DeleteMapping("/delete_department/{id}")
    public void deleteDepartment(@PathVariable Integer id) {
        departmentService.deleteDepartment(id);
    }
}
