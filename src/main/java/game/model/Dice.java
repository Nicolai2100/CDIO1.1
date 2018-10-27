package game.model;

public class Dice {

    private final int MAX = 6;
    private int faceValue;

    //public Dice(){
    //    faceValue = 1;
    //}

    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }

    public int getMAX() {
        return MAX;
    }
}