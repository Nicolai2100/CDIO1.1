package game.control;
import game.model.Dice;

public class DiceController {
    int faceValue;
    private Dice model;

    public DiceController(Dice model)
    {
        this.model = model;
        model.setFaceValue(1);
    }

    //The method generates an integer between 1 and 6.
    public int roll(){
        //faceValue = (int) (Math.random() * ((model.getMAX()+ 1)));
        faceValue = (int) ((Math.random() * model.getMAX()) + 1);

        model.setFaceValue(faceValue);
        return faceValue;
    }
    public int getFaceValue() {
        return model.getFaceValue();
    }
    public void setFaceValue(int faceValue) {
        model.setFaceValue(faceValue);
    }
}
