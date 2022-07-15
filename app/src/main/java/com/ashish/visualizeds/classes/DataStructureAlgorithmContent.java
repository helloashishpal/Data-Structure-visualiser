package com.ashish.visualizeds.classes;

import java.io.Serializable;

public class DataStructureAlgorithmContent implements Serializable {
    private final String theory;
    private final String algorithm;
    private final String code;
    private final String worstCase;
    private final String averageCase;
    private final String bestCase;

    public DataStructureAlgorithmContent(String theory, String algorithm, String code, String worstCase, String averageCase, String bestCase) {
        this.theory = theory;
        this.algorithm = algorithm;
        this.code = code;
        this.worstCase = worstCase;
        this.averageCase = averageCase;
        this.bestCase = bestCase;
    }

    public String getTheory() {
        return theory;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public String getCode() {
        return code;
    }

    public String getWorstCase() {
        return worstCase;
    }

    public String getAverageCase() {
        return averageCase;
    }

    public String getBestCase() {
        return bestCase;
    }
}
