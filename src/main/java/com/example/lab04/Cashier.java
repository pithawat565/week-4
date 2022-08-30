package com.example.lab04;


import org.springframework.web.bind.annotation.*;

@RestController
public class Cashier {

    @RequestMapping (value = ("getChange/{balance}"), method = RequestMethod.GET)
    public Change getChange(@PathVariable("balance") double balance){
        return new Change(balance);
    }
}
