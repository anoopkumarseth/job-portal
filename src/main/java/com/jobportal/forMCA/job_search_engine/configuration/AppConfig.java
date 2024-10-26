package com.jobportal.forMCA.job_search_engine.configuration;

import com.jobportal.forMCA.job_search_engine.DB;
import com.jobportal.forMCA.job_search_engine.DevDB;
import com.jobportal.forMCA.job_search_engine.ProdDB;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "production")
    public DB getProdDBBean(){
        return new ProdDB();
    }

    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "development")
    public DB getDevDBBean(){
        return new DevDB();
    }
}
