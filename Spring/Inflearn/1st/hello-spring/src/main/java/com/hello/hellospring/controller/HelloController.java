package com.hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello");

        return "hello";
    }

    @GetMapping("hello2")
    public String hello2(@RequestParam(value = "name", required = false)String name, Model model){
        model.addAttribute("name", name);
        return "hello2";
    }

    @GetMapping("hello3")
    @ResponseBody
    public String hello3(@RequestParam("name") String name) {
        return "김"+name;
    }

    @GetMapping("hello4")
    @ResponseBody
    public nameClass hello4(@RequestParam("name")String name) {
        nameClass nameClass = new nameClass();
        nameClass.setName(name);
        return nameClass;
    }

    static class nameClass {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
