package khanhtq.department_service.service;

import khanhtq.department_service.entity.DepartmentEntity;
import khanhtq.department_service.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {
    @Autowired
    private IDepartmentRepository repository;

    @Override
    public List<DepartmentEntity> getAllDepartments() {
        return repository.findAll();
    }

}
