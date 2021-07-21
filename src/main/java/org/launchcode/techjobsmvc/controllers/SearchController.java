package org.launchcode.techjobsmvc.controllers;

import org.launchcode.techjobsmvc.data.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.launchcode.techjobsmvc.controllers.ListController.columnChoices;

@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    @PostMapping("/results")
    public String displaySearchResults(@RequestParam(defaultValue = "") String searchType,@RequestParam(defaultValue = "") String searchTerm, Model model){
        model.addAttribute("jobs", JobData.findByColumnAndValue(searchType, searchTerm));
        model.addAttribute("columns",columnChoices);
        return "search";
}
}

