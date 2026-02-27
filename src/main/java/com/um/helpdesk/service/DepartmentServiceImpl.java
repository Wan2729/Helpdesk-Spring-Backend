package com.um.helpdesk.service;

import com.um.helpdesk.entity.Department;
import com.um.helpdesk.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DepartmentServiceImpl implements DepartmentService {

    private static final Logger log = LoggerFactory.getLogger(DepartmentServiceImpl.class);
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    // @Cacheable tells Spring: "If you already ran this method, don't run it again.
    // Just return the saved result from memory."
    @Override
    @Cacheable("allDepartments")
    public List<Department> getAllDepartments() {
        log.info("Fetching ALL departments from the Database (Not from Cache!)");
        return departmentRepository.findAll();
    }

    @Override
    @Cacheable(value = "departmentById", key = "#id")
    public Department getDepartmentById(Long id) {
        log.info("Fetching department ID {} from the Database", id);
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + id));
    }

    @Override
    public Department getDepartmentByCode(String code) {
        // You can use streams on the cached list to prevent another DB hit!
        return getAllDepartments().stream()
                .filter(dept -> dept.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }
}