package org.moneyfactory.config;

import lombok.extern.log4j.Log4j2;
import org.moneyfactory.service.CronService;
import org.moneyfactory.service.NseRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Log4j2
@Configuration
@EnableScheduling
public class Config {
//    @Bean
//    public DataSource dataSource(){
//        try {
//            SimpleDriverDataSource ds = new SimpleDriverDataSource();
//            ds.setDriver(new com.mysql.jdbc.Driver());
//            ds.setUrl("jdbc:mysql://localhost:3306/toptal");
//            ds.setUsername("root");
//            ds.setPassword("");
//            return ds;
//        }catch (Exception e){
//            log.error("error in creating ds ",e.getMessage());
//        }
//        return null;
//    }
//    public JdbcTemplate jdbcTemplate()  {
//        return new JdbcTemplate(dataSource());
//    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @Autowired
    CronService cronService;

    @Scheduled(fixedRate = 1000)
    public void checkQuotes(){
        log.info("method invoked"+ LocalDateTime.now());
        cronService.updateQuotes();
    }
}
