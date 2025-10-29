/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import main.model.Board;
import main.model.Dices;
import main.model.GameArea;
import main.model.Piece;
import main.model.Player;
import main.model.Position;
import main.view.BoardPanel;
import main.view.ControllPanel;
import main.view.GUIInicio;
import main.view.GUITablero;

/**
 *
 * @author Gabriel Mora Hernandez
 */
public class GameController implements ActionListener, MouseListener{
    private BoardPanel boardPanel;
    private GUITablero gUITablero;
    private GameArea gameArea;
    private Piece piece;
    private ControllPanel controllPanel;
    private GUIInicio gUIInicio;
    private Dices dices;
    private Board board;
    private Player player1;
    private Player player2;
    private int turno;
   
    public GameController(GUIInicio gUIInicio) {
        this.gUIInicio = gUIInicio;
        this.gUITablero = new GUITablero(this);
        this.gUITablero.setVisible(true);
        
        this.gUITablero.listener(this); 
        
        this.boardPanel = gUITablero.getBoardPanel();
        this.gameArea = new GameArea();
        this.controllPanel = gUITablero.getPanelControll();
        board = new Board("Red", "Amarillo");
        this.dices = new Dices();
        
        this.player1 = new Player("Jugador 1", Color.RED);
        this.player2 = new Player("Jugador 2", Color.YELLOW);
        
        piece = new Piece(new Position(100,100), new ImageIcon("./src/main/resources/img/fichaAmarilla.png"));
    }
    
    public void draw(Component c, Graphics g){
        piece.draw(c, g);
        gameArea.draw(c, g);
        board.draw(c, g);
        }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
         switch (e.getActionCommand()) {
            case "Lanzar Dado":
                Player active = getPlayerActive();
                System.out.println("Turno actual: " + active.getName());
                
                int resultado = dices.rollDice();
                System.out.println("Dado: " +resultado);
                
                controllPanel.getLblResultadoDado().setText("Dado: " + resultado);
                controllPanel.getLblResultadoDado().setForeground(active.getColor());
                
                alternateTurno();
                updatePlayerActive();  
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

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("X= " + e.getX() + " Y= " + e.getY());
        piece.getPosition().setX(e.getX());//
        piece.getPosition().setY(e.getY());//
        boardPanel.repaint();//
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) { 
    }
   
    private Player getPlayerActive(){
        if (turno == 0) {
        return player1;
    } else {
        return player2;
        }
    }
    
    private void alternateTurno() {
    turno = (turno + 1) % 2; //alterna entre 0 y 1, jugador1 = 0 y jugador 2 = 1
    }
    
    private void updatePlayerActive(){
        Player active = getPlayerActive();
        controllPanel.getLblJugador().setText("Turno: " + active.getName());
        controllPanel.getLblJugador().setForeground(active.getColor());
    }
    
   
}//end class
    

