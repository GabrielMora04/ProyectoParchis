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
public class Board {
    private Square[] squares;
    private Home homeYellow;
    private Home homeRed;
    private Home homeBlue;
    private Home homeGreen;
    private Position[] positions;
    
    
    public Board(String color1, String color2){   
        this.squares = new Square[68];
        
        int[] especiales = {12, 17, 29, 34, 46, 51, 63, 68};

        this.positions = new Position[68];
        this.homeYellow = new Home(color1);
        this.homeRed = new Home(color2);
        this.homeBlue = new Home("Azul");
        this.homeGreen = new Home("verde");
    }
   
    public void draw(Component c, Graphics g){
        this.squares[0].getPiece().draw(c, g);
         
    }
    
    
}
