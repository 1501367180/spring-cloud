package zh.zh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
@RequestMapping("/hello")
public class OrderController {

    @RequestMapping("/hello")
    @ResponseBody
    public Object find(){
        return "hello-word";
    }

    @RequestMapping("/three")
    public Object three(){
        return "three";
    }



}
