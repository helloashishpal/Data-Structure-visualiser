package com.ashish.visualizeds.classes;

import java.io.Serializable;

//Algorithms like linear search and bubble sort
public class DataStructureAlgorithm implements Serializable {
    private final String name;
    private final Class visualizeClass;
    private final DataStructureAlgorithmContent dataStructureAlgorithmContent;
    private final Difficulty difficulty;
    private final Integer icon;

    public DataStructureAlgorithm(String name, Class visualizeClass, DataStructureAlgorithmContent dataStructureAlgorithmContent, Difficulty difficulty, Integer icon) {
        this.name = name;
        this.visualizeClass = visualizeClass;
        this.dataStructureAlgorithmContent = dataStructureAlgorithmContent;
        this.difficulty = difficulty;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public Class getVisualizeClass() {
        return visualizeClass;
    }

    public DataStructureAlgorithmContent getDataStructureAlgorithmContent() {
        return dataStructureAlgorithmContent;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Integer getIcon() {
        return icon;
    }

}
