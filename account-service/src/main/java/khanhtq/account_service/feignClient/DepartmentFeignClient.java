package khanhtq.account_service.feignClient;

import khanhtq.account_service.dto.DepartmentDTO;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "department-service",path = "/api/v1/departments")
@RibbonClient(name = "department-service")
public interface DepartmentFeignClient {
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable("id") int id);

}
