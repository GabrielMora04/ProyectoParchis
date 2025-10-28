/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.model;

import java.util.Random;

/**
 *
 * @author Gabriel Mora Hernandez
 */
public class Dices {
    private Random random;
    private int numero;

    public Dices(Random random, int numero) {
        this.random = new Random();
        this.numero = numero;
    }

    public Dices() {
        this.random = new Random();
        
    }

    public int getNumero() {
        return numero;
    }
   
    
    public int rollDice(){
        numero = random.nextInt(6) + 1;
        return numero;
    }
}
