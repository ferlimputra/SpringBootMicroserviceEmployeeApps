package com.microservice.springboot.training.EmployeeDashboardService.controller;

import java.util.Collection;

import com.microservice.springboot.training.EmployeeDashboardService.domain.EmployeeInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EmployeeDashboardController
 */
@RefreshScope
@RestController
public class EmployeeDashboardController {
    @Autowired
    private EmployeeServiceProxy proxyService;

    @RequestMapping("/dashboard/feign/{myself}")
    public EmployeeInfo findme(@PathVariable Long myself) {
        return proxyService.findById(myself);
    }

    @RequestMapping("/dashboard/feign/peers")
    public Collection<EmployeeInfo> findPeers() {
        return proxyService.findAll();
    }
}