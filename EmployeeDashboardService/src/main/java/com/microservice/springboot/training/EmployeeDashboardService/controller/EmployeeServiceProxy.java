package com.microservice.springboot.training.EmployeeDashboardService.controller;

import java.util.Collection;

import com.microservice.springboot.training.EmployeeDashboardService.domain.EmployeeInfo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * EmployeeServiceProxy
 */
@FeignClient("EmployeeSearch")
public interface EmployeeServiceProxy {
    @RequestMapping("/employee/find/{id}")
    public EmployeeInfo findById(@PathVariable(value = "id") Long id);

    @RequestMapping("/employee/findall")
    public Collection<EmployeeInfo> findAll();
}