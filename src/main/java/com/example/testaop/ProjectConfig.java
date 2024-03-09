package com.example.testaop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.example.testaop.controller", "com.example.testaop.aspect", "com.example.testaop"})
@EnableAspectJAutoProxy
public class ProjectConfig {
}
