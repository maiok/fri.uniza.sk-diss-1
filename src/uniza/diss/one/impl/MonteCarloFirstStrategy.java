/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniza.diss.one.impl;

import java.util.Random;
import uniza.diss.one.base.MonteCarlo;
import uniza.diss.one.utils.AppOutput;

/**
 *
 * @author mariokemen
 */
public class MonteCarloFirstStrategy extends MonteCarlo {

    private double[] semiResults;

    @Override
    public double runMonteCarlo(int countReplications, int countDoors) {

        this.semiResults = new double[countReplications];
        Random rnd1 = new Random();
        Random rnd2 = new Random();

        int i;
        int countWins = 0;
        int winDoor;
        int pick;

        for (i = 0; i < countReplications; i++) {
            winDoor = rnd1.nextInt(countDoors);
            pick = rnd2.nextInt(countDoors);
            if (pick == winDoor) {
                countWins++;
            }
            // Prvych 0.5% vynecham kvoli zahrievaniu
            if (i > countReplications * 0.005 && i % 100 == 0) {
//                semiResults[i] = (double) countWins / (i + 1);
                AppOutput.addReplicaStrategy1(i, (double) countWins / (i + 1));
            }
        }

        return (double) countWins / countReplications;
    }

    public double[] getSemiResults() {
        return this.semiResults;
    }

}
