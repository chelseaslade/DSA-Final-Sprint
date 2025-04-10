package org.keyin;

import javax.persistence.*;

@Entity
public class BSTEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String inputNumbers;

    @Column(name = "tree_structure", columnDefinition = "TEXT")
    private String treeStructure;

    public BSTEntity() {}

    public BSTEntity(String inputNumbers, String treeStructure) {
        this.inputNumbers = inputNumbers;
        this.treeStructure = treeStructure;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInputNumbers() {
        return inputNumbers;
    }

    public void setInputNumbers(String inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    public String getTreeStructure() {
        return treeStructure;
    }

    public void setTreeStructure(String treeStructure) {
        this.treeStructure = treeStructure;
    }
}
