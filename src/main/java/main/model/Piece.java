/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.text.CollationElementIterator;
import javax.swing.ImageIcon;

/**
 *
 * @author Gabriel Mora Hernandez
 */
public class Piece {
    private Position position;
    private ImageIcon imageIcon;
    private Color color;

    public Piece() {
    }

    public Piece(Position position, ImageIcon imageIcon, Color color) {
        this.position = position;
        this.imageIcon = imageIcon;
        this.color = color;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public void draw(Component c, Graphics g){
        this.imageIcon.paintIcon(c, g, this.position.getX(), this.position.getY());
        
        
    }
}
