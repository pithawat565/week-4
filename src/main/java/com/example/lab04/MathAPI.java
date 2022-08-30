package com.example.lab04;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MathAPI {

    @GetMapping (value = "/plus/{n1}/{n2}")
    public double myPlus(@PathVariable("n1") double num1, @PathVariable("n2") double num2){
        return num1 + num2;
    }

    @GetMapping (value = "/minus/{n1}/{n2}")
    public double myMinus(@PathVariable("n1") double num1, @PathVariable("n2") double num2){
        return num1 - num2;
    }

    @GetMapping (value = "/divide/{n1}/{n2}")
    public double myDivide(@PathVariable("n1") double num1, @PathVariable("n2") double num2){
        return num1 / num2;
    }


    @GetMapping (value = "/multi/{n1}/{n2}")
    public double myMulti(@PathVariable("n1") double num1, @PathVariable("n2") double num2){
        return num1 * num2;
    }

    @GetMapping (value = "/mod/{n1}/{n2}")
    public double myMod(@PathVariable("n1") double num1, @PathVariable("n2") double num2){
        return num1 % num2;
    }

    @PostMapping (value = "/max")
    public double max(@RequestBody MultiValueMap<String, String> n){
        Map<String, String> data = n.toSingleValueMap();
        double num1 = Double.parseDouble(data.get("n1"));
        double num2 = Double.parseDouble(data.get("n2"));

        double result = (num1 > num2) ? num1 : num2;
        return result;
    }
}
