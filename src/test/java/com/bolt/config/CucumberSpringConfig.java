package com.bolt.config;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = FrameworkConfig.class)
@SpringBootTest
public class CucumberSpringConfig {
}
