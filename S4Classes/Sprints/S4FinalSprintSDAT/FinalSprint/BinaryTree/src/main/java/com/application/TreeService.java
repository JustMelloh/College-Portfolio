package com.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeService {

    @Autowired
    private TreeRepository treeRepository;


    /**
     * Processes a comma-separated string of numbers, inserts them into a binary search tree,
     * converts the tree to a JSON string, saves the tree entity to the repository, and returns the JSON string.
     *
     * @param numbers the comma-separated string of numbers to be processed
     * @return the JSON string representation of the binary search tree
     */

    public String processedNumbers(String numbers) {
        BinarySearchTree bst = new BinarySearchTree();

        for (String num : numbers.split(",")) {
            bst.insert(Integer.parseInt(num.trim()));
        }
        String treeJson = convertTreeToJson(bst);
        TreeEntity treeEntity = new TreeEntity();
        treeEntity.setInputNum(numbers);
        treeEntity.setTreeStructure(treeJson);
        treeRepository.save(treeEntity);
        return treeJson;
    }

    public List<TreeEntity> getTreeEntities() {
        return treeRepository.findAll();
    }

    /**
     * Converts a binary search tree to a JSON string.
     *
     * @param bst the binary search tree to be converted
     * @return the JSON string representation of the binary search tree
     */

    private String convertTreeToJson(BinarySearchTree bst) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bst);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{}";
        }
        }
    }

