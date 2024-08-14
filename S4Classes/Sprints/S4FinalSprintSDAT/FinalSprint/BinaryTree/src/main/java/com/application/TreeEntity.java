package com.application;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class TreeEntity {
    private String inputNum;

    @Column(columnDefinition = "TEXT")
    private String treeStructure;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public TreeEntity(String inputNum, String treeStructure) {
        this.inputNum = inputNum;
        this.treeStructure = treeStructure;
    }

    public TreeEntity() {}

    public String getInputNum() {
        return inputNum;
    }

    public void setInputNum(String inputNum) {
        this.inputNum = inputNum;
    }

    public String getTreeStructure() {
        return treeStructure;
    }

    public void setTreeStructure(String treeStructure) {
        this.treeStructure = treeStructure;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}