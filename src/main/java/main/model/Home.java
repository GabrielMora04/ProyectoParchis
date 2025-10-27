/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

/**
 *
 * @author Gabriel Mora Hernandez
 */
public class Home {
    private Color color;
    private  Piece[] pieces;

    public Home(String color) {
        this.color = this.color;
        this.pieces = new Piece[4];
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public void setPiece(int index, Piece piece){
        this.pieces[index] = piece;
    }
    
    public Piece getPiece(int index){
        return this.pieces[index];
    }
    
    public int getLength(){
        return this.pieces.length;
    }
    
    public void draw(Component c, Graphics g){
        if (pieces !=null) {
            for (int i = 0; i < pieces.length; i++) {
                if(pieces[i] != null){
                    pieces[i].draw(c, g);
                }
            }
        } 
    }
}//end class
