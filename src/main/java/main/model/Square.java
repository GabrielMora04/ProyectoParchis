/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.model;

/**
 *
 * @author Gabriel Mora Hernandez
 */
public class Square {
    
    private Piece piece;
    private Position position;

    public Square() {
    }

    public Square(Position position) {
        this.position = position;
    }

    public Square(Piece piece, Position position) {
        this.piece = piece;
        this.position = position;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    
    public boolean isEmpty(){
        return (piece != null);
    }
}
