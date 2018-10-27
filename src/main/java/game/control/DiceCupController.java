package game.control;

import game.model.DiceCup;

public class DiceCupController {
    DiceCup model;
    DiceController die1, die2;

    //Constructor
    public DiceCupController(DiceCup model, DiceController die1, DiceController die2){
        this.model = model;
        this.die1 = die1;
        this.die2 = die2;
    }

    //The method rolls two dice and returns their value as an integer.
    public int rollSum(){
        die1.roll();
        die2.roll();
        model.setSum(die1.getFaceValue() + die2.getFaceValue());
        return getSum();
    }

    public int getSum() {
        return model.getSum();
    }
}