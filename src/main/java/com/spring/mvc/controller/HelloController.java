package com.spring.mvc.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello") //請求路徑
public class HelloController {

    //方法名稱與路徑名稱不一定要相同
    @RequestMapping("/now")
    @ResponseBody
    public String today() {
        return new Date().toString();
    }

    @RequestMapping("/greet")
    @ResponseBody
    public String greet() {
        return "Hello SpringMVC!";
    }

    @RequestMapping("/add/{x}/{y}")
    @ResponseBody
    public String add(@PathVariable("x") int x, @PathVariable int y) {
        //return x+y +" ";                
        return String.format("%d + %d = %d", x, y, (x + y));
    }

    // 不同的資料型別,無法使用相同的方法名稱
    @RequestMapping("/add2/{x}/{y}")
    @ResponseBody
    public String add2(@PathVariable("x") double x, @PathVariable double y) {
        //return x+y +" ";                
        return String.format("%f + %f = %f", x, y, (x + y));
    }

    @RequestMapping("/area/{r}")
    @ResponseBody
    public String area(@PathVariable(name = "r", required = false) Integer r) {
        if (r == null) {
            return "r = ? ";
        } else {
            return Math.pow(r, 2) * Math.PI + "";
        }
    }

        @RequestMapping("/area2/{r}")
    @ResponseBody
    public String area2(@PathVariable Optional<Integer> r) {
        if(r.isPresent()) {
            return Math.pow(r.get(), 2) * Math.PI + "";
        } else {
            return "r = ?";
        }
    }
    
    @RequestMapping("/bmi")
    @ResponseBody
    public String bmi(@RequestParam Optional<Double> h, @RequestParam Optional<Double> w) {
        if (!h.isPresent()) {
            return "h = ?";
        }
        if (!w.isPresent()) {
            return "w = ?";
        }
        double bmi = w.get() / Math.pow(h.get()/100, 2);
        return String.format("%.2f", bmi);
    }
    
    // @PathVariable + @RequestParam
    // mvc/hello/ticket/man?price=100 -> man -> 100
    // mvc/hello/ticket/female?price=100 -> female -> 80
    @RequestMapping("/ticket/{sex}")
    @ResponseBody
    public String ticket(@PathVariable String sex, 
                         @RequestParam(required = true) Double price) {
        if(sex.equals("man")) price = price * 1;
        else if(sex.equals("female")) price = price * 0.8;
        else return "sex error";
        
        return sex + " -> " + price;
    }
    
    // 將參數放入集合
    // bmi2?h=170&w=55 的參數內容轉換成Map格式{h=170,w=55}
    @RequestMapping("/bmi2")
    @ResponseBody
    public String bmi2(@RequestParam Map<String, String> params) {
        double h = Double.parseDouble(params.get("h"));
        double w = Double.parseDouble(params.get("w"));
        double bmi2 = w / Math.pow(h/100, 2);
        return String.format("%.2f", bmi2);
    }
    
    // 連續參數
    // getId?id=1,3,5,7,9
    @RequestMapping("/getId")
    @ResponseBody
    public String getId(@RequestParam(name = "id", required = true) List<String> ids) {
        return ids.toString() + ", size=" + ids.size();
    }

    /*
        Ant語法
        * : 任意多字
        ? : 任意一字
        ** : 任意多組資料夾
     */
    @RequestMapping("/*/ant")
    @ResponseBody
    public String antPath1() {
        return "ant path 1";
    }

    @RequestMapping("/ant?")
    @ResponseBody
    public String antPath2() {
        return "ant path 2";
    }

    @RequestMapping("/**/ant")
    @ResponseBody
    public String antPath3() {
        return "ant path 3";
    }

    @RequestMapping(value = {"/tw", "/taiwan"})
    @ResponseBody
    public String welcome() {
        return "Taiwan welcome U!";
    }
}
