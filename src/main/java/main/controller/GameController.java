/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.controller;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import main.model.Board;
import main.model.GameArea;
import main.model.Piece;
import main.model.Position;
import main.view.BoardPanel;
import main.view.ControllPanel;
import main.view.GUIInicio;
import main.view.GUITablero;

/**
 *
 * @author Gabriel Mora Hernandez
 */
public class GameController implements ActionListener{
    private BoardPanel boardPanel;
    private GUITablero gUITablero;
    private GameArea gameArea;
    private Piece piece;
    private ControllPanel controllPanel;
    private GUIInicio gUIInicio;
   
    public GameController() {
        this.gUIInicio = gUIInicio;
        this.gUITablero = new GUITablero(this);
        this.gUITablero.setVisible(true);
        this.boardPanel = gUITablero.getBoardPanel();
        this.gameArea = new GameArea();
        this.controllPanel = gUITablero.getPanelControll();
        
    //piece = new Piece(new Position(453,468), new ImageIcon("./src/main/resources/img/fichaAmarilla.png"));
    }
    
    public void draw(Component c, Graphics g){
        piece.draw(c, g);
        gameArea.draw(c, g);
        }
    
    @Override
    public void actionPerformed(ActionEvent e) {
         switch (e.getActionCommand()) {
            case "Dado":
                System.out.println("Dado presionado");
            break;
            case "Jugador1":
                System.out.println("Jugador 1 presionado");
            break;
            case "Jugador2":
                System.out.println("Jugador 2 presionado");
            break;
            case "Jugar":
                System.out.println("Jugar presionado");
            break;
            case "Salir":
                System.exit(0);
            break;
        }
    }
    
    
    
    
}
