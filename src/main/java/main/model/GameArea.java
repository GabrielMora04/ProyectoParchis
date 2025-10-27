/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.model;

/**
 *
 * @author Gabriel Mora Hernandez
 */
public class GameArea {
    private Board board;

    public GameArea() {
        this.board = new Board("Rojo","Verde");
    }
    
    public Board getBoard(){
        return this.board;
        
    }
}
