/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniza.diss.one.app;

import java.util.Random;
import uniza.diss.one.impl.MonteCarloFirstVariant;
import uniza.diss.one.impl.MonteCarloSecondVariant;

/**
 *
 * @author mariokemen
 */
public class test {
    
    public static void main(final String[] args) {
        
        MonteCarloFirstVariant v1 = new MonteCarloFirstVariant();
        System.out.println(v1.runMonteCarlo(1000000, 3));
        
        MonteCarloSecondVariant v2 = new MonteCarloSecondVariant();
        System.out.println(v2.runMonteCarlo(1000000, 3));
        
    }
    
}
