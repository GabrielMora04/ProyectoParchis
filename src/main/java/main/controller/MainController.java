/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.view.GUICreditos;
import main.view.GUIHistoria;
import main.view.GUIInicio;
import main.view.GUIInstrucciones;



/**
 *
 * @author gabri
 */
public class MainController implements ActionListener {
    //Falta Pulir//
    
    
    private GUIInicio gUIInicio;
    private GUICreditos gUICreditos;
    private GUIHistoria gUIHistoria;
    private GUIInstrucciones gUIInstrucciones;
    private GameController gameController;

    public MainController() {
        gUIInicio =  new GUIInicio(this);
        gUIInicio.setVisible(true);
        gUICreditos =  new GUICreditos(this);
        gUIHistoria = new GUIHistoria(this);
        gUIInstrucciones = new GUIInstrucciones(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Jugar":
                gUIInicio.setVisible(false);
                gameController = new GameController();
            break;
            case "Instrucciones":
                gUIInicio.setVisible(false);
                gUIInstrucciones.setVisible(true);
            break;
            case "Historia":
                gUIInicio.setVisible(false);
                gUIHistoria.setVisible(true);
            break;
            case "Creditos":
                gUIInicio.setVisible(false);
                gUICreditos.setVisible(true);
            break;
            case "Atras":
                gUIInicio.setVisible(true);
                gUIInstrucciones.setVisible(false);
                gUIHistoria.setVisible(false);
                gUICreditos.setVisible(false);
            break;
            case "Salir":
                System.exit(0);
            break;
        }
    }
    
    
}


