package com.spring.mvc.controller;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello") //請求路徑
public class HelloController {
    
    //方法名稱與路徑名稱不一定要相同
    @RequestMapping("/now")
    @ResponseBody
    public String today(){
        return new Date().toString();                
    }
    
    @RequestMapping("/greet")
    @ResponseBody
    public String greet(){
        return "Hello SpringMVC!";                
    }
    
    @RequestMapping("/add/{x}/{y}")
    @ResponseBody
    public String add(@PathVariable("x") int x,@PathVariable int y){
        //return x+y +" ";                
        return String.format("%d + %d = %d", x, y, (x+y));                
    }
    
    // 不同的資料型別,無法使用相同的方法名稱
    @RequestMapping("/add2/{x}/{y}")
    @ResponseBody
    public String add2(@PathVariable("x") double x,@PathVariable double y){
        //return x+y +" ";                
        return String.format("%f + %f = %f", x, y, (x+y));                
    }
                             
}
