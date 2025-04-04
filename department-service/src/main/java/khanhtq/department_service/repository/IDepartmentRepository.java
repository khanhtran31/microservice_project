package khanhtq.department_service.repository;

import khanhtq.department_service.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {
}
