package khanhtq.account_service.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import khanhtq.account_service.dto.AccountDTO;
import khanhtq.account_service.dto.DepartmentDTO;
import khanhtq.account_service.entity.AccountEntity;
import khanhtq.account_service.feignClient.DepartmentFeignClient;
import khanhtq.account_service.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/accounts")
public class AccountController {
    @Value("${greeting.text}")
    private String greetingText;

    @Value("${department-service.uri")
    private String departmentUri;

    private final IAccountService acService;
    private final ModelMapper modelMapper;
    private final RestClient restClient;
    private final DepartmentFeignClient feignClient;

    @GetMapping
    public List<AccountDTO> getListAccounts() {
        List<AccountEntity> accountEntities = acService.getListAccounts();
        return modelMapper.map(
                accountEntities,
                new TypeToken<List<AccountDTO>>() {
                }.getType());
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable("accountId") int accountId){
        AccountEntity entity = acService.findAccountById(accountId);
        AccountDTO dto = modelMapper.map(entity,
                new TypeToken<AccountDTO>(){
                }.getType());
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/departments")
    @CircuitBreaker(name ="department-service")
    public List<DepartmentDTO> getAllDepartment(){
        return restClient.get()
                .uri(departmentUri)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    @GetMapping("/greeting")
    public String greet() {
        return greetingText;
    }
}
