package game.model;

public class DiceCup {

    private int sum;
    Dice die1, die2;

    //Constructor
    public DiceCup(Dice dice1, Dice dice2){
        die1 = dice1;
        die2 = dice2;
    }

    //The method rolls two dice and returns their value as an integer.
    public int rollSum(){
        die1.roll();
        die2.roll();
        sum = die1.getFaceValue() + die2.getFaceValue();
        return sum;
    }

    public int getFaceValueDie1() {
        return die1.getFaceValue();
    }

    public int getFaceValueDie2() {
        return die2.getFaceValue();
    }

    public int getSum() {
        return sum;
    }
}
