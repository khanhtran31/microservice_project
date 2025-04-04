package khanhtq.admin_service.controller;

import khanhtq.admin_service.dto.AccountDTO;
import khanhtq.admin_service.dto.DepartmentDTO;
import khanhtq.admin_service.feignClient.DepartmentFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/admin")
public class AdminController {

    @Value("${account-service.uri")
    private String accountUri;

    private final RestClient restClient;
    private final DepartmentFeignClient departmentFeignClient;

    @GetMapping("/accounts")
    public List<AccountDTO> getAllAccounts() {
        return restClient.get()
                .uri(accountUri)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    @GetMapping("/departments")
    public List<DepartmentDTO> getAllDepartments() {
        return departmentFeignClient.getDepartments();
    }
}
