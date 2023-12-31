package Ziegen;

import java.util.Objects;

public class Main{

    static boolean active = false;
    static boolean activeOfSwap = false;
    static int counting;

    public static void main(String[] args){
        DoorCreation starter = new DoorCreation(null);
        System.out.println("Wollen Sie das Spiel automatisch simulieren?");
        if (active || activeOfSwap){
            System.out.println("Ja");
            System.out.println("Soll die Entscheidung der auszuwählenden Türen immer geändert werden, wenn möglich?");
            if(activatorOfSwap() && activeOfSwap){
                System.out.println("Ja");
                starter.creation(starter);
            }
            else if (activator() && active){
                System.out.println("Nein");
                starter.creation(starter);
            }
        }
        else {
            if(Objects.equals(ReadingInput.readingAnswer(), "Ja")){
                System.out.println("Soll die Entscheidung der auszuwählenden Türen immer geändert werden, wenn möglich?");
                if(Objects.equals(ReadingInput.readingAnswer(), "Ja")){
                    activatorOfSwap();
                    starter.creation(starter);
                }
                else {
                    activator();
                    starter.creation(starter);
                }
            }
            else {
                starter.creation(starter);
            }
        }
    }

    static boolean activator(){
        if (counting <= 1000){
            if(!active){
                active = true;
                return false;
            }
            else{
                if (counting == 1000){
                    System.out.println("Gewinnwahrscheinlichkeit: " + ((double) DoorCreation.win / counting) * 100 + "%");
                    System.exit(4);
                }
                counting++;
                return true;
            }
        }
        return false;
    }

    static boolean activatorOfSwap(){
        if (counting <= 1000){
            if(!activeOfSwap){
                activeOfSwap = true;
                return false;
            }
            else{
                if (counting == 1000){
                    System.out.println("Gewinnwahrscheinlichkeit: " + ((double) DoorCreation.win / counting) * 100 + "%");
                    System.exit(4);
                }
                counting++;
                return true;
            }
        }
        return false;
    }
}