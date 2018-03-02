package uniza.diss.one.tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import uniza.diss.one.app.*;
import java.util.Random;
import uniza.diss.one.impl.MonteCarloFirstStrategy;
import uniza.diss.one.impl.MonteCarloSecondStrategy;

/**
 *
 * @author mariokemen
 */
public class test {
    
    public static void main(final String[] args) {
        
//        MonteCarloFirstStrategy v1 = new MonteCarloFirstStrategy();
//        System.out.println(v1.runMonteCarlo(1000000, 3));
//        
//        MonteCarloSecondStrategy v2 = new MonteCarloSecondStrategy();
//        System.out.println(v2.runMonteCarlo(1000000, 3));

        Random rnd = new Random();
        System.out.println(rnd.nextInt());
        
    }
    
}
