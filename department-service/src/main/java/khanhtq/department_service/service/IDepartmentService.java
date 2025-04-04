package khanhtq.department_service.service;

import khanhtq.department_service.entity.DepartmentEntity;

import java.util.List;

public interface IDepartmentService {
    List<DepartmentEntity> getAllDepartments();
}
