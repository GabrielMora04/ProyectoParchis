/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.ImageIcon;

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
        
        this.positions = new Position[68];
        this.homeYellow = new Home(color1);
        this.homeRed = new Home(color2);
        this.homeBlue = new Home("Azul");
        this.homeGreen = new Home("verde");
        setPositions();
        setQuadrant1();
    }
    
    public void setPositions(){
        positions = new Position[68];
        squares = new Square[68];
        
        //Amarillo
        positions[0] = new Position(433, 694);
        positions[1] = new Position(433, 664);
        positions[2] = new Position(433, 634);
        positions[3] = new Position(433, 602);
        positions[4] = new Position(433, 571); // salida casa
        positions[5] = new Position(433, 538);
        positions[6] = new Position(433, 509);
        positions[7] = new Position(425, 478);
        positions[8] = new Position(452, 450);
        positions[9] = new Position(484, 461);
        positions[10] = new Position(513, 461);
        positions[11] = new Position(545, 461); // especial
        positions[12] = new Position(576, 461);
        positions[13] = new Position(607, 461);
        positions[14] = new Position(638, 461); 
        positions[15] = new Position(669, 461);
        positions[16] = new Position(669, 387); // especial

        // Azul
        positions[17] = new Position(669, 319);
        positions[18] = new Position(637, 319);
        positions[19] = new Position(609, 319);
        positions[20] = new Position(576, 319);
        positions[21] = new Position(546, 319); // salida casa
        positions[22] = new Position(516, 319);
        positions[23] = new Position(484, 319);
        positions[24] = new Position(452, 329);
        positions[25] = new Position(425, 297);
        positions[26] = new Position(433, 265);
        positions[27] = new Position(433, 235);
        positions[28] = new Position(435, 204); // especial
        positions[29] = new Position(433, 172);
        positions[30] = new Position(433, 140);
        positions[31] = new Position(433, 110);
        positions[32] = new Position(433, 80);
        positions[33] = new Position(363, 80); // especial
 
       // Rojo
        positions[34] = new Position(290, 80);
        positions[35] = new Position(290, 109);
        positions[36] = new Position(290, 143);
        positions[37] = new Position(290, 172);
        positions[38] = new Position(290, 202); // salida casa
        positions[39] = new Position(290, 234);
        positions[40] = new Position(290, 266);
        positions[41] = new Position(304, 297);
        positions[42] = new Position(275, 329);
        positions[43] = new Position(242, 317);
        positions[44] = new Position(213, 317);
        positions[45] = new Position(181, 317); // especial
        positions[46] = new Position(151, 317);
        positions[47] = new Position(119, 317);
        positions[48] = new Position(88, 317);
        positions[49] = new Position(58, 317);
        positions[50] = new Position(58, 388); // especial

        // Verde
        positions[51] = new Position(58, 461);
        positions[52] = new Position(88, 461);
        positions[53] = new Position(119, 461);
        positions[54] = new Position(148, 461);
        positions[55] = new Position(181, 461); // salida casa
        positions[56] = new Position(212, 461);
        positions[57] = new Position(241, 461);
        positions[58] = new Position(275, 446);
        positions[59] = new Position(304, 478);
        positions[60] = new Position(290, 509);
        positions[61] = new Position(290, 540);
        positions[62] = new Position(290, 571); // especial
        positions[63] = new Position(290, 604);
        positions[64] = new Position(290, 637);
        positions[65] = new Position(290, 667);
        positions[66] = new Position(290, 697);
        positions[67] = new Position(363, 696); // especial

       // Crear los Square
       for (int i = 0; i < 68; i++) {
        squares[i] = new Square(positions[i]);
        }
    }//end setPositions
    
    public void setQuadrant1() {
    // Amarillo
    homeYellow.setPiece(0, new Piece(new Position(480, 450), new ImageIcon("./src/main/resources/img/fichaAmarilla.png")));
    homeYellow.setPiece(1, new Piece(new Position(520, 450), new ImageIcon("./src/main/resources/img/fichaAmarilla.png")));
    homeYellow.setPiece(2, new Piece(new Position(480, 550), new ImageIcon("./src/main/resources/img/fichaAmarilla.png")));
    homeYellow.setPiece(3, new Piece(new Position(520, 550), new ImageIcon("./src/main/resources/img/fichaAmarilla.png")));

    // Rojo
    homeRed.setPiece(0, new Piece(new Position(80, 50), new ImageIcon("./src/main/resources/img/fichaRoja.png")));
    homeRed.setPiece(1, new Piece(new Position(120, 50), new ImageIcon("./src/main/resources/img/fichaRoja.png")));
    homeRed.setPiece(2, new Piece(new Position(80, 150), new ImageIcon("./src/main/resources/img/fichaRoja.png")));
    homeRed.setPiece(3, new Piece(new Position(120, 150), new ImageIcon("./src/main/resources/img/fichaRoja.png")));

    // Verde
    homeGreen.setPiece(0, new Piece(new Position(480, 50), new ImageIcon()));
    homeGreen.setPiece(1, new Piece(new Position(520, 50), new ImageIcon()));
    homeGreen.setPiece(2, new Piece(new Position(480, 150), new ImageIcon()));
    homeGreen.setPiece(3, new Piece(new Position(520, 150), new ImageIcon()));

    // Azul
    homeBlue.setPiece(0, new Piece(new Position(80, 450), new ImageIcon()));
    homeBlue.setPiece(1, new Piece(new Position(120, 450), new ImageIcon()));
    homeBlue.setPiece(2, new Piece(new Position(80, 550), new ImageIcon()));
    homeBlue.setPiece(3, new Piece(new Position(120, 550), new ImageIcon()));
}
    
    
   
    public void draw(Component c, Graphics g){
        //this.squares[0].getPiece().draw(c, g);
       
        for (int i = 0; i < homeYellow.getLength(); i++) {
            homeYellow.getPiece(i).draw(c, g);
            homeRed.getPiece(i).draw(c, g);
            homeBlue.getPiece(i).draw(c, g);
            homeGreen.getPiece(i).draw(c, g);
}
    }//end draw
    
    
    public void start(){
        setPositions();
        setQuadrant1();
    }
    
}
