package com.spring.mvc.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class BmiService {

    public Double calcBmi(Double h, Double w) {
        return w / Math.pow(h / 100, 2);
    }

    public List<Map<String, Double>> calcBmi(List<String> hList, List<String> wList) {
        List<Map<String, Double>> list = new ArrayList<>();
        if (hList.size() == wList.size()) {
            for (int i = 0; i < hList.size(); i++) {
                Map<String, Double> map = new LinkedHashMap<>();
                Double h = Double.parseDouble(hList.get(i));
                Double w = Double.parseDouble(wList.get(i));
                map.put("h", h);
                map.put("w", w);
                map.put("bmi", calcBmi(h, w));
                list.add(map);
            }
        }
        return list;
    }
}
