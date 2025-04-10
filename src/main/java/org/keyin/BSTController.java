package org.keyin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bst")
public class BSTController {
    @Autowired
    private BSTService bstService;

    @Autowired
    private BSTRepository bstRepository;

    public BSTController(BSTService bstService) {
        this.bstService = bstService;
    }

    @PostMapping("/process-numbers")
    public String processNumbers(@RequestParam String numbers, Model model) {
        try {
            String jsonTree = bstService.buildAndStoreTree(numbers);
            model.addAttribute("jsonTree", jsonTree);
            model.addAttribute("input", numbers);
            return "process-numbers";
        } catch (Exception e) {
            model.addAttribute("error", "Invalid input");
            return "enter-numbers";
        }
    }

    @GetMapping("/")
    public String displayHomePage() {
        return "index";
    }

    @GetMapping("/enter-numbers")
    public String showInputForm() {
        return "enter-numbers";
    }

    @GetMapping("/previous-trees")
    public String getAllTrees(Model model) {
        List<BSTEntity> previousTrees = bstRepository.findAll();
        model.addAttribute("trees", previousTrees);
        return "previous-trees";
    }
}
