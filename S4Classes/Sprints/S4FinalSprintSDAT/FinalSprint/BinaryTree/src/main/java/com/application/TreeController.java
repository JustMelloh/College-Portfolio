package com.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TreeController {

    @Autowired
    private TreeService treeService;

    @GetMapping("/entry")
    public String entry() {
        return "entry";
    }

    /**
     * Handles the POST request for the "/process" URL.
     *
     * @param numbers the input numbers to be processed
     * @param model the model to which the processed tree JSON will be added
     * @return the name of the view to be rendered, in this case "result"
     */

    @PostMapping("/process")
    public String process(@RequestParam String numbers, Model model) {
        String treeJson = treeService.processedNumbers(numbers);
        model.addAttribute("treeJson", treeJson);
        return "result";
    }

    /**
     * Handles the GET request for the "/result" URL.
     *
     * @param model the model to which the list of tree entities will be added
     * @return the name of the view to be rendered, in this case "result"
     */

    @GetMapping("/result")
    public String result(Model model) {
        model.addAttribute("treeEntities", treeService.getTreeEntities());
        return "result";
    }


    /**
     * Handles the GET request for the "/previous" URL.
     *
     * @param model the model to which the list of tree entities will be added
     * @return the name of the view to be rendered, in this case "previous"
     */
    @GetMapping("/previous")
    public String getPreviousTrees(Model model) {
        List<TreeEntity> trees = treeService.getTreeEntities();
        model.addAttribute("trees", trees);
        return "previous";
    }
}