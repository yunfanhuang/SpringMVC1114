package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company")
public class CompanyController {
    
    @GetMapping("/")
    public String index(){
        return "company/index";
    }
    
    @GetMapping("/dept/")
    public String dept(){
        return "company/dept_page";
    }
    
    @GetMapping("/emp/")
    public String emp(){
        return "company/emp_page";
    }
    
    @GetMapping("/club/")
    public String club(){
        return "company/club_page";
    }
    
}
