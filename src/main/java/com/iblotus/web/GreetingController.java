package com.iblotus.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/3/11.
 */
@Controller
public class GreetingController {
    @RequestMapping("/greeting")
    public String greeting(String name, Model m){
        m.addAttribute("name",name);
        return "greeting";
    }
}