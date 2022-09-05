package org.refactoringminer.pred;


import java.util.ArrayList;
import java.util.List;

public class EmbeddingChunkOfCode {


    private String codeStatement;


    private List<String> refactoringType = new ArrayList<>();

    public String getCodeStatement() {
        return codeStatement;
    }

    public void setCodeStatement(String codeStatement) {
        this.codeStatement = codeStatement;
    }

    public List<String> getRefactoringType() {
        return refactoringType;
    }

    public void addRefactoringType(String refactoringType) {
        this.refactoringType.add(refactoringType);
    }

    public void setRefactoringType(List<String> refactoringType) {
        this.refactoringType = refactoringType;
    }
}
