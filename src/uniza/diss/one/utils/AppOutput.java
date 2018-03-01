/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniza.diss.one.utils;

import uniza.diss.one.app.App;

/**
 * @author mariokemen
 */
public final class AppOutput {

    private static App app;

    public static void setApp(App pApp) {
        app = pApp;
    }
    
    public static void addReplicaStrategy1(Number iteration, Number value) {
        app.addReplicaStrategy1(iteration, value);
    }
    
    public static void addReplicaStrategy2(Number iteration, Number value) {
        app.addReplicaStrategy2(iteration, value);
    }

}
