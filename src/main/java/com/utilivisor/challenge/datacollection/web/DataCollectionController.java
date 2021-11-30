package com.utilivisor.challenge.datacollection.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.utilivisor.challenge.datacollection.PointHistory;

@Controller
public class DataCollectionController {

    private List<PointHistory> pointHistoryList;

	@RequestMapping(value="/data-collection", method = RequestMethod.GET)
    public String form(){
        return "form";
    }

    @RequestMapping(value="/data-collection", method = RequestMethod.POST)
    @ResponseBody
    public List<PointHistory> results(@RequestParam MultipartFile file, ModelMap modelMap) {
    	StringBuilder sb = new StringBuilder();
    	if (file != null) {
			try {
				if (!Files.exists(Paths.get("/data-collection"))) {
					try {
						Files.createDirectories(Paths.get("/data-collection"));
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
				}

				Files.copy(file.getInputStream(), Paths.get("/data-collection", file.getOriginalFilename()));
				sb.append("You successfully uploaded " + file.getOriginalFilename() + "!\n");

//				modelMap.addAttribute("msg", sb);
				modelMap.addAllAttributes(pointHistoryList);
			} catch (IOException | RuntimeException e) {
				sb.append("Failued to upload " + (file != null ? file.getOriginalFilename() : "") + " => "
						+ e.getMessage() + String.valueOf(e) + "\n");

				modelMap.addAttribute("msg", sb);
			}
		} else {
			sb.append("Failed to upload file\n");
			modelMap.addAttribute("msg", sb);
		}

		return pointHistoryList;
	}

}
