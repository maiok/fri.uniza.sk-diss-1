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
public final class MonteCarloFirstVariant extends MonteCarlo {

    @Override
    public double runMonteCarlo(int countReplications, int countDoors) {

        Random rnd1 = new Random();
        Random rnd2 = new Random();
        
        int i;
        int countWins = 0;
        int winDoor;
        int pick;

        for (i = 0; i < countReplications; i++) {
            winDoor = rnd1.nextInt(countDoors);
            pick = rnd2.nextInt(countDoors);
            if(pick == winDoor) {
                countWins++;
            }
        }

        return (double)countWins/countReplications;
    }

}
