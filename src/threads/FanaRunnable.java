/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stefan
 */
public abstract class FanaRunnable implements Runnable {

    private boolean stop;
    private boolean infinite;
//    private JLabel labelCeas;
//    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

//    public FanaRunnable(JLabel labelCeas) {
//        this.labelCeas = labelCeas;
//    }
    public FanaRunnable(boolean... infinite) {
        if (infinite.length > 0) {
            this.infinite = infinite[0];
        }
    }

    @Override
    public void run() {
        System.out.println("Valoare lui infinite "+infinite);
        if (!infinite) {
            System.out.println("Run this fucking code!!!!");
            customRun();
            return;
        }
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(FanaRunnable.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!stop) {
                customRun();
            }
        }
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public abstract void customRun();

}
