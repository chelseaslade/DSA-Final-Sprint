package org.keyin;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BSTService {
    private final BSTRepository bstRepository;

    public BSTService(BSTRepository bstRepository) {
        this.bstRepository = bstRepository;
    }

    public void deleteTree(BSTEntity bst) {
        bstRepository.delete(bst);
    }

    public List<BSTEntity> getAllTrees() {
        return bstRepository.findAll();
    }

    public String buildAndStoreTree(String numberInput) {
        String[] parts = numberInput.split(",");
        BST bst = new BST();

        for (String part : parts) {
            int number = Integer.parseInt(part.trim());
            bst.insert(number);
        }

        String jsonTree = bst.toJson();

        BSTEntity entity = new BSTEntity(numberInput, jsonTree);
        bstRepository.save(entity);

        return jsonTree;
    }
}
