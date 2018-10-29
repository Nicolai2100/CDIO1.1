package game.control;
import game.model.Dice;

public class DiceController {
    private Dice model;

    public DiceController(Dice model)
    {
        this.model = model;
        model.setFaceValue(1);
    }

    //The method generates an integer between 1 and 6.
    public void roll(){
        model.setFaceValue((int) ((Math.random() * model.getMAX()) + 1));
    }
    public int getFaceValue() {
        return model.getFaceValue();
    }
    public void setFaceValue(int faceValue) {
        model.setFaceValue(faceValue);
    }
}
