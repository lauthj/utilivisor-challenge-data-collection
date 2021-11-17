package com.utilivisor.challenge.datacollection.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DataCollectionController {

    @RequestMapping(value="/data-collection", method = RequestMethod.GET)
    public String form(){
        return "form";
    }

//    @RequestMapping(value="/data-collection", method = RequestMethod.POST)
//    @ResponseBody
//    public List<PointHistory> results(@RequestParam MultipartFile file, ModelMap modelMap) {}

}
