public class Json {
    private String type;
    private String description;
    private Left[] leftSideLocations;
    private Left[] rightSideLocations;
    private int i=0;
    private int j=0;

    public int getI(){
        return i;
    }

    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public Left getLeftSideLocations(int i){
        return leftSideLocations[i];
    }
    public void setLeftSideLocations(Left[] left){
        this.leftSideLocations = left;
        this.i++;
    }
    public Left getRightSideLocations(int j){
        return rightSideLocations[j];
    }
    public void setRightSideLocations(Left[] right){
        this.rightSideLocations = right;
        this.j++;
    }
}
