package com.spring.mvc.controller;

import com.spring.mvc.service.BmiService;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/page")
public class PageController {

    @Autowired
    private BmiService bmiService;

//    @RequestMapping("/bmi")
//    public ModelAndView getBmi(@RequestParam Optional<Double> h,
//            @RequestParam Optional<Double> w) {
//        Double bmi = bmiService.calcBmi(h.get(), w.get());
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("bmi", bmi); // 將要給 jsp 的資料放入 Model
//        mv.setViewName("bmi_page"); // 設定 jsp 檔名
//        return mv;
//    }
//    @RequestMapping("/bmi2")
//    public ModelAndView getBmi2(@RequestParam Optional<Double> h,
//            @RequestParam Optional<Double> w, Model model) {
//        Double bmi = bmiService.calcBmi(h.get(), w.get());
//        model.addAttributes("bmi",bmi);
//        return "bmi_page";
//    }
    @RequestMapping("/bmi")
    public ModelAndView getBmi(@RequestParam Optional<Double> h,
            @RequestParam Optional<Double> w) {
        Double bmi = bmiService.calcBmi(h.get(), w.get());
        ModelAndView mv = new ModelAndView();
        mv.addObject("bmi", bmi); // 將要給 jsp 的資料放入 Model
        mv.addObject("h", h.get()); // 將要給 jsp 的資料放入 Model
        mv.addObject("w", w.get()); // 將要給 jsp 的資料放入 Model
        mv.setViewName("bmi_page"); // 設定 jsp 檔名
        return mv;
    }

    @RequestMapping("/bmi2")
    // 這裡的 String 指的是回傳 View 的名稱
    public String getBmi2(@RequestParam Optional<Double> h,
            @RequestParam Optional<Double> w, Model model) {
        Double bmi = bmiService.calcBmi(h.get(), w.get());
        model.addAttribute("bmi", bmi); // 將要給 jsp 的資料放入 Model 
        model.addAttribute("h", h.get()); // 將要給 jsp 的資料放入 Model 
        model.addAttribute("w", w.get()); // 將要給 jsp 的資料放入 Model 
        return "bmi_page"; // 設定 jsp 檔名
    }
    
    @RequestMapping("/bmi/list")
    public String getBmiList(@RequestParam(name = "h", required = true) Optional<List<String>> hList, 
                             @RequestParam(name = "w", required = true) Optional<List<String>> wList,
                             Model model) {
        List<Map<String, Double>> list = bmiService.calcBmi(hList.get(), wList.get());
        model.addAttribute("list", list);
        return "bmi_list_page"; // 設定 jsp 檔名
    }
}
