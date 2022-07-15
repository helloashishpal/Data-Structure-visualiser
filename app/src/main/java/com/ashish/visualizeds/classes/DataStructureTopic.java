package com.ashish.visualizeds.classes;

import java.io.Serializable;
import java.util.List;

//For topics like searching and sorting
public class DataStructureTopic implements Serializable {
    private final String name;
    private final List<DataStructureAlgorithm> dataStructureAlgorithms;
    private final Difficulty difficulty;
    private final Integer icon;

    public DataStructureTopic(String name, List<DataStructureAlgorithm> dataStructureAlgorithms, Difficulty difficulty, Integer icon) {
        this.name = name;
        this.dataStructureAlgorithms = dataStructureAlgorithms;
        this.difficulty = difficulty;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public List<DataStructureAlgorithm> dataStructureAlgorithms() {
        return dataStructureAlgorithms;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Integer getIcon() {
        return icon;
    }

}
