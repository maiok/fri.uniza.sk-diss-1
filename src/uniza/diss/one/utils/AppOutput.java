/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniza.diss.one.utils;

import uniza.diss.one.app.App;

/**
 * Trieda, ktora tvori komunikacnu vrstvu medzi biznis logikou aplikacie
 * a uzivatelskym rozhranim
 * 
 * @author mariokemen
 */
public final class AppOutput {

    private static App app;

    public static void setApp(App pApp) {
        app = pApp;
    }
    
    /**
     * Pridanie jednej repliky strategie 1 do grafu.
     * 
     * @param x
     * @param y 
     */
    public static void addReplicaStrategy1(int x, double y) {
        app.addReplicaStrategy1(x, y);
    }
    
    /**
     * Pridanie jednej repliky strategie 2 do grafu.
     * 
     * @param x
     * @param y 
     */
    public static void addReplicaStrategy2(int x, double y) {
        app.addReplicaStrategy2(x, y);
    }

}
