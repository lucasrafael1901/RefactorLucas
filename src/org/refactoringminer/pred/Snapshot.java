package org.refactoringminer.pred;


import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class Snapshot implements Serializable {


    private UUID id;


    private String commitId;


    private String pathBefore = "";


    private String pathAfter = "";


    private String sourceCodeBefore;

    private String sourceCodeAfter;

    //private List<Refactoring> allRefactoringsIdentified;

  
    private List<EmbeddingChunkOfCode> embeddingChunkOfCodes;

    public Snapshot() {
        this.id = UUID.randomUUID();
    }

    public Snapshot(Long id, String pathBefore, String pathAfter, String sourceCodeBefore, String sourceCodeAfter, List<EmbeddingChunkOfCode> embeddingChunkOfCodes) {
        this.pathBefore = pathBefore;
        this.pathAfter = pathAfter;
        this.sourceCodeBefore = sourceCodeBefore;
        this.sourceCodeAfter = sourceCodeAfter;
        this.embeddingChunkOfCodes = embeddingChunkOfCodes;
    }

    public List<EmbeddingChunkOfCode> getEmbeddingChunkOfCodes() {
        return embeddingChunkOfCodes;
    }

    public void setEmbeddingChunkOfCodes(List<EmbeddingChunkOfCode> embeddingChunkOfCodes) {
        this.embeddingChunkOfCodes = embeddingChunkOfCodes;
    }

    public String getPathBefore() {
        return pathBefore;
    }

    public void setPathBefore(String pathBefore) {
        this.pathBefore = pathBefore;
    }

    public String getPathAfter() {
        return pathAfter;
    }

    public void setPathAfter(String pathAfter) {
        this.pathAfter = pathAfter;
    }

    public String getSourceCodeBefore() {
        return sourceCodeBefore;
    }

    public void setSourceCodeBefore(String sourceCodeBefore) {
        this.sourceCodeBefore = sourceCodeBefore;
    }

    public String getSourceCodeAfter() {
        return sourceCodeAfter;
    }

    public void setSourceCodeAfter(String sourceCodeAfter) {
        this.sourceCodeAfter = sourceCodeAfter;
    }

    public String getCommitId() {
        return commitId;
    }

    public void setCommitId(String commitId) {
        this.commitId = commitId;
    }
}

