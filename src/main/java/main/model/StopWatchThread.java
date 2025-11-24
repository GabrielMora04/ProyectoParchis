/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.model;

import main.view.ControllPanel;

/**
 *
 * @author Gabriel Mora Hernández
 */
public class StopWatchThread extends Thread {

    private boolean corriendo = true;
    private int segundos = 0;
    private ControllPanel controllPanel;

    public StopWatchThread(ControllPanel controllPanel) {
        this.controllPanel = controllPanel;
    }

    public void detener() {
        this.corriendo = false;
    }

    @Override
    public void run() {
        while (corriendo) {
            try {
                this.sleep(1000);
                this.segundos++;
                this.controllPanel.setCronometro("" + segundos);
//                System.out.println("Tiempo:" + segundos + "s");
            } catch (InterruptedException ex) {
                System.err.println("Se interrumpió el hilo");

            }

        }

    }

    public int getSegundos() {
        return segundos;
    }

}//fin class

