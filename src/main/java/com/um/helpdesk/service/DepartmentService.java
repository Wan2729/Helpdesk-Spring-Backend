package com.um.helpdesk.service;

import com.um.helpdesk.entity.Department;
import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();
    Department getDepartmentById(Long id);
    Department getDepartmentByCode(String code);
}