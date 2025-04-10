package org.keyin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @ResponseBody
    public ResponseEntity<String> processNumbers(@RequestParam String numbers) {
        try {
            String jsonTree = bstService.buildAndStoreTree(numbers);
            return ResponseEntity.ok(jsonTree);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid input");
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
    public String getAllTrees() {
        return "previous-trees";
    }


}
