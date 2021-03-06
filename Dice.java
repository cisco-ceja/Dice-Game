package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Dice {

    int diceValue;
    int held = 0;// 1 if held, 0 if not
    int diceIndex;

    Image diceImage;
    ImageView diceSlot;

    void createInit() {
        diceImage = new Image("file:./res/Dice1.png");
        diceSlot = new ImageView(diceImage);

        diceSlot.setPreserveRatio(true);
        diceSlot.setFitWidth(100);
        diceSlot.setVisible(false);
    }

    void setDiePic() {

        if (diceValue == 1) {
            diceImage = new Image("file:./res/Dice1.png");
            diceSlot.setImage(diceImage);
        }
        else if (diceValue == 2) {
            diceImage = new Image("file:./res/Dice2.png");
            diceSlot.setImage(diceImage);
        }
        else if (diceValue == 3) {
            diceImage = new Image("file:./res/Dice3.png");
            diceSlot.setImage(diceImage);
        }
        else if (diceValue == 4) {
            diceImage = new Image("file:./res/Dice4.png");
            diceSlot.setImage(diceImage);
        }
        else if (diceValue == 5) {
            diceImage = new Image("file:./res/Dice5.png");
            diceSlot.setImage(diceImage);
        }
        else {
            diceImage = new Image("file:./res/Dice6.png");
            diceSlot.setImage(diceImage);
        }
    }

    void updatePic() {

        switch (diceValue) {
            case 1:
                if (held == 0) {
                    diceImage = new Image("file:./res/Dice1Held.png");
                    diceSlot.setImage(diceImage);
                    held = 1;
                }
                else {
                    diceImage = new Image("file:./res/Dice1.png");
                    diceSlot.setImage(diceImage);
                    held = 0;
                }
                break;
            case 2:
                if (held == 0) {
                    diceImage = new Image("file:./res/Dice2Held.png");
                    diceSlot.setImage(diceImage);
                    held = 1;
                }
                else {
                    diceImage = new Image("file:./res/Dice2.png");
                    diceSlot.setImage(diceImage);
                    held = 0;
                }
                break;
            case 3:
                if (held == 0) {
                    diceImage = new Image("file:./res/Dice3Held.png");
                    diceSlot.setImage(diceImage);
                    held = 1;
                }
                else {
                    diceImage = new Image("file:./res/Dice3.png");
                    diceSlot.setImage(diceImage);
                    held = 0;
                }
                break;
            case 4:
                if (held == 0) {
                    diceImage = new Image("file:./res/Dice4Held.png");
                    diceSlot.setImage(diceImage);
                    held = 1;
                }
                else {
                    diceImage = new Image("file:./res/Dice4.png");
                    diceSlot.setImage(diceImage);
                    held = 0;
                }
                break;
            case 5:
                if (held == 0) {
                    diceImage = new Image("file:./res/Dice5Held.png");
                    diceSlot.setImage(diceImage);
                    held = 1;
                }
                else {
                    diceImage = new Image("file:./res/Dice5.png");
                    diceSlot.setImage(diceImage);
                    held = 0;
                }
                break;
            case 6:
                if (held == 0) {
                    diceImage = new Image("file:./res/Dice6Held.png");
                    diceSlot.setImage(diceImage);
                    held = 1;
                }
                else {
                    diceImage = new Image("file:./res/Dice6.png");
                    diceSlot.setImage(diceImage);
                    held = 0;
                }
                break;
            default:
                System.out.println("DEBUG-ERROR");
                break;
        }
    }

    void createRandomStart(Dice dice1, Dice dice2, Dice dice3, Dice dice4, Dice dice5) {

        Random randNum = new Random();

        dice1.diceValue = 1 + randNum.nextInt(6);
        dice2.diceValue = 1 + randNum.nextInt(6);
        dice3.diceValue = 1 + randNum.nextInt(6);
        dice4.diceValue = 1 + randNum.nextInt(6);
        dice5.diceValue = 1 + randNum.nextInt(6);

        dice1.setDiePic();
        dice2.setDiePic();
        dice3.setDiePic();
        dice4.setDiePic();
        dice5.setDiePic();
    }

    void checkIfRollDie(){
        // 1 if held, 0 if not
        if(held == 0){
            Random randNum = new Random();
            diceValue = 1 + randNum.nextInt(6);
            held = 1;
            this.updatePic();
        }
    }

    int findCurrScore(Dice dice1, Dice dice2, Dice dice3, Dice dice4, Dice dice5){
        int[] array = {0, 0, 0, 0, 0, 0};

        array = dice1.findTally(array);
        array = dice2.findTally(array);
        array = dice3.findTally(array);
        array = dice4.findTally(array);
        array = dice5.findTally(array);

        int found1 = array[0];
        int found2 = array[1];
        int found3 = array[2];
        int found4 = array[3];
        int found5 = array[4];
        int found6 = array[5];


        // 5 of a kind
        if(found1 == 5  || found2 == 5 || found3 == 5 || found4 == 5 || found5 == 5 || found6 == 5){
            return 10;
        }

        // Straight
        else if((found1 == 1 && found2 == 1 && found3 == 1 && found4 == 1 && found5 == 1) ||
                (found2 == 1 && found3 == 1 && found4 == 1 && found5 == 1 && found6==1)){
            return 8;
        }

        // 4 of a kind
        else if(found1 == 4  || found2 == 4 || found3 == 4 || found4 == 4 || found5 == 4 || found6 == 4){
            return 7;
        }

        // Full house
        else if((found1 == 2  || found2 == 2 || found3 == 2 || found4 == 2 || found5 == 2 || found6 == 2) &&
                (found1 == 3  || found2 == 3 || found3 == 3 || found4 == 3 || found5 == 3 || found6 == 3)){
            return 6;
        }

        // 3 of a kind
        else if(found1 == 3  || found2 == 3 || found3 == 3 || found4 == 3 || found5 == 3 || found6 == 3){
            return 5;
        }

        // 2 pair
        else if(
                (found1 == 2  && found2 == 2) || (found1 == 2  && found3 == 2) || (found1 == 2  && found4 == 2) || (found1 == 2  && found5 == 2) || (found1 == 2  && found6 == 2) ||
                        ((found2 == 2  && found3 == 2) || (found2 == 2  && found4 == 2) || (found2 == 2  && found5 == 2) || (found2 == 2  && found6 == 2)) ||
                        ((found3 == 2  && found4 == 2) || (found3 == 2  && found5 == 2) || (found3 == 2  && found6 == 2)) ||
                        ((found4 == 2  && found5 == 2) || (found4 == 2  && found6 == 2)) ||
                        ((found5 == 2  && found6 == 2))){
            return 4;
        }

        // 2 of a kind
        else if(found1 == 2  || found2 == 2 || found3 == 2 || found4 == 2 || found5 == 2 || found6 == 2){
            return 1;
        }

        return 0;
    }

    int[] findTally(int[] array) {
        switch (diceValue) {
            case 1:
                array[0] = array[0] + 1;
                break;
            case 2:
                array[1] = array[1] + 1;
                break;
            case 3:
                array[2] = array[2] + 1;
                break;
            case 4:
                array[3] = array[3] + 1;
                break;
            case 5:
                array[4] = array[4] + 1;
                break;
            case 6:
                array[5] = array[5] + 1;
                break;

            default:
                System.out.println("DEBUG-ERROR");
                break;
        }
        return array;
    }

}
