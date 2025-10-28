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
    private String color;
    private Home quadrant;
   
    private int score;

    public Player(String name, String color, Home quadrant) {
        this.name = name;
        this.color = color;
        this.quadrant = quadrant;
        score = 5;
        
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
    
    
}
