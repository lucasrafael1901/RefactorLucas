public class Left {
    private String filePath;
    private String startLine;
    private String endLine;
    private String startColumn;
    private String endColumn;
    private String codeElementType;
    private String description;
    private String codeElement;

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setStartLine(String startLine) {
        this.startLine = startLine;
    }

    public void setEndLine(String endLine) {
        this.endLine = endLine;
    }

    public void setStartColumn(String startColumn) {
        this.startColumn = startColumn;
    }

    public void setEndColumn(String endColumn) {
        this.endColumn = endColumn;
    }

    public void setCodeElementType(String codeElementType) {
        this.codeElementType = codeElementType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCodeElement(String codeElement) {
        this.codeElement = codeElement;
    }

    public String getFilePath() {
        return filePath;
    }
    public String getStartLine() {
        return startLine;
    }
    public String getEndLine() {
        return endLine;
    }
    public String getStartColumn() {
        return startColumn;
    }
    public String getEndColumn() {
        return endColumn;
    }
    public String getCodeElementType() {
        return codeElementType;
    }
    public String getDescription() {
        return description;
    }
    public String getCodeElement() {
        return codeElement;
    }

}
