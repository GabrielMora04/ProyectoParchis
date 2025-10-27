/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.model;

import java.awt.Component;
import java.awt.Graphics;

/**
 *
 * @author Gabriel Mora Hernandez
 */
public class GameArea {
    private Board board;
    private Player player1;
    private Player player2;

    public GameArea() {
        this.board = new Board("Rojo","Verde");
    }
   
    public Board getBoard(){
        return this.board;
        
    }
    
    public void draw(Component c, Graphics g){
        board.draw(c, g);
    }
}
