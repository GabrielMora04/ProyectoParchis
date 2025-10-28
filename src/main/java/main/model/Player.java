/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.model;

import java.awt.Color;

/**
 *
 * @author Gabriel Mora Hernandez
 */
public class Player {
    private String name;
    private Color color;
    private Home quadrant;
    private int score;

    public Player(String name, Color color, Home quadrant) {
        this.name = name;
        this.color = color;
        this.quadrant = quadrant;
        score = 5;
    }

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
        
    }

    
    

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }
    
    
}
