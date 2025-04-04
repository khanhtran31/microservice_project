package khanhtq.admin_service.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ComponentConfiguration {

    @Bean
    public RestClient restClient(){return RestClient.create();}
}
