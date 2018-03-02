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
 * Trieda implementujuca metodu monte carlo strategie 1, cize ked sutiazaci
 * nezmeni svoj povodny nazor
 * 
 * @author mariokemen
 */
public class MonteCarloFirstStrategy extends MonteCarlo {

    @Override
    public double runMonteCarlo(int countReplications, int countDoors) {

        Random seed = new Random(); // generator pre nasady do simulacie
        
        // Poznamka1: Random bez parametra dava nasadu systemoveho casu
        // co vedie niekedy k nekvalitnemu generatu pokial mam tieto generatory
        // hned za sebou, preto je lepsie vytvorit jeden generator ako nasadu
        // pre tie dalsie
        
        // Poznamka2: V pripade, ze by som chcel dobre ladit program, ked tusim
        // ze nejaky generator je problemovy, tak mu dam konstantnu nasadu
        // a tym padom bude generovat stale tie iste cisla
        
        
        Random rnd1 = new Random(seed.nextInt()); // generator pre jav urcenia vyhernych dveri
        Random rnd2 = new Random(seed.nextInt()); // - // - urcenia dveri sutiaziacim

        int i;
        int countWins = 0;

        for (i = 0; i < countReplications; i++) {
            // Vyhral?
            if (rnd2.nextInt(countDoors) == rnd1.nextInt(countDoors)) {
                countWins++;
            }
            // Prvych 30% vynecham kvoli zahrievaniu
            if (i > countReplications * 0.3 && i % 100 == 0) {
                AppOutput.addReplicaStrategy1(i, (double) countWins / (i + 1));
            }
        }

        return (double) countWins / countReplications;
    }

}
