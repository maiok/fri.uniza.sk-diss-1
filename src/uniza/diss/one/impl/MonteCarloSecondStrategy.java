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
 * Trieda implementujuca metodu monte carlo strategie 2, cize ked sutiazaci
 * zmeni svoju volbu po tom ako moderator otvori jedny dvere
 *
 * @author mariokemen
 */
public class MonteCarloSecondStrategy extends MonteCarlo {

    private Random rnd1; // generator pre jav urcenia vyhernych dveri
    private Random rnd2; // - // - urcenia dveri sutiaziacim
    private Random rnd3; // - // - urcenia dveri moderatorom

    private int winDoor;

    @Override
    public double runMonteCarlo(int countReplications, int countDoors) {

        Random seed = new Random(); // generator pre nasady do inych generatorov

        rnd1 = new Random(seed.nextInt()); // generator pre jav urcenia vyhernych dveri
        rnd2 = new Random(seed.nextInt()); // - // - urcenia dveri sutiaziacim
        rnd3 = new Random(seed.nextInt()); // - // - urcenia dveri moderatorom

        int i;
        int countWins = 0;
        int pick; // vyber sutiaziaceho
        int pickModerator; // vyber moderatora

        for (i = 0; i < countReplications; i++) {

            winDoor = rnd1.nextInt(countDoors);
            pick = rnd2.nextInt(countDoors);
            pickModerator = getModeratorDoor(pick, rnd3, countDoors);
            pick = getChangeMyMind(pick, pickModerator, rnd2, countDoors);
            // Vyhral?
            if (pick == winDoor) {
                countWins++;
            }
            // Poslanie hodnoty do GUI za podmienok, ze prebehlo 30% prvych
            // replikacii a ide o kazdu 100 hodnotu (kvoli rychlejsiemu vykresleniu)
            if (i > countReplications * 0.3 && i % 100 == 0) {
                AppOutput.addReplicaStrategy2(i, (double) countWins / (i + 1));
            }
        }

        return (double) countWins / countReplications;
    }

    /**
     * Metoda, ktora mi vrati dvere vybrane moderatorom, tak aby to neboli
     * vyherne dvere a zaroven dvere, ktore si vybral sutaziaci
     *
     * @param winDoor
     * @param pick
     * @param rnd generator nahodneho javu
     * @param bound nasada
     * @return
     */
    private int getModeratorDoor(int pick, Random rnd, int bound) {

        // Triedu Random pouzijem iba raz, dalej v cykle hladam najblizsie volne
        // dvere, teda tak aby som hodnotu nezahadzoval
        int door = rnd.nextInt(bound);
        while (true) {
            // Podmienka aby moderator neotvoril vitazne dvere a tie, ktore
            // si vybral sutaziaci
            if (door != winDoor && door != pick) {
                break;
            }
            // Pokial som narazil nejake vybrate dvere niekym, tak mi dalej v poradi
            // hladaj dalsie volne
            door++;
            // Zabezpecenie aby som nevyskocil z roszahu poctu dveri
            door %= bound;
        }
        return door;
    }

    /**
     * Metoda, ktora mi vrati dvere vybrane sutaziacim po tom ako moderator
     * otvoril nejake dvere tak, aby novo vybrane dvere neboli ani tie, ktore
     * vybral moderator ale ani tie, ktore si vybral predtym.
     *
     * @param pick
     * @param pickModerator
     * @param rnd
     * @param bound
     * @return
     */
    private int getChangeMyMind(int pick, int pickModerator, Random rnd, int bound) {

        int door = rnd.nextInt(bound);
        while (true) {
            if (door != pick && door != pickModerator) {
                break;
            }
            door++;
            door %= bound;
        }
        return door;
    }

}
