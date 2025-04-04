package khanhtq.admin_service.feignClient;

import khanhtq.admin_service.dto.DepartmentDTO;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "department-service",path = "/api/v1/departments")
@RibbonClient(name = "department-service")
public interface DepartmentFeignClient {
    @GetMapping
    public List<DepartmentDTO> getDepartments();
}
