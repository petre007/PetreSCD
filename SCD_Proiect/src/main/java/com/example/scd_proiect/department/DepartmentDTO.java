package com.example.scd_proiect.department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDTO extends JpaRepository<DepartmentEntity, Integer> {



}
