/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniza.diss.one.impl;

import java.util.Random;
import uniza.diss.one.base.MonteCarlo;

/**
 *
 * @author mariokemen
 */
public class MonteCarloSecondVariant extends MonteCarlo {

    private double[] semiResults;
    
    @Override
    public double runMonteCarlo(int countReplications, int countDoors) {

        this.semiResults = new double[countReplications];
        Random rnd1 = new Random();
        Random rnd2 = new Random();
        Random rnd3 = new Random();
        
        int i;
        int countWins = 0;
        int winDoor;
        int pick;
        int pickModerator;

        for (i = 0; i < countReplications; i++) {

            winDoor = rnd1.nextInt(countDoors);
            pick = rnd2.nextInt(countDoors);
            pickModerator = getLoseDoor(winDoor, pick, rnd3, countDoors);
            pick = getChangeMyMind(pick, pickModerator, rnd2, countDoors);
            if(pick == winDoor) {
                countWins++;
            }
            if (countWins != 0) {
                semiResults[i] = (double) countWins / (i + 1);
            }
        }

        return (double)countWins/countReplications;
    }

    private int getLoseDoor(int winDoor, int pick, Random rnd, int bound) {
        
        int door;
        while (true) {
            door = rnd.nextInt(bound);
            if (door != winDoor && door != pick) {
                break;
            }
        }
        return door;
    }
    
    private int getChangeMyMind(int pick, int pickModerator, Random rnd, int bound) {
        
        int door;
        while (true) {
            door = rnd.nextInt(bound);
            if (door != pick && door != pickModerator) {
                break;
            }
        }
        return door;
    }
    
    public double[] getSemiResults() {
        return this.semiResults;
    }
}
