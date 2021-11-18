package com.utilivisor.challenge.datacollection.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.utilivisor.challenge.datacollection.csvPojo;

@Controller
public class DataCollectionController {

    @RequestMapping(value="/data-collection", method = RequestMethod.GET)
    public String form(){
        return "form";
    }

    @RequestMapping(value="/data-collection", method = RequestMethod.POST)
    @ResponseBody
    public List<csvPojo> results(@RequestParam MultipartFile file, ModelMap modelMap) { 
//    public String results(@RequestParam MultipartFile file, ModelMap modelMap)
    	
    	PointHistory pointHistory = new PointHistory();
    	modelMap.addAttribute("files", file);
    	
		return pointHistory.pojoList;
		
    }

}
