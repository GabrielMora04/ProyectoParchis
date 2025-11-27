/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import main.model.Position;

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

    //casillas de color de meta
    private Position[] goalYellow;
    private Position[] goalRed;
    private Position[] goalBlue;
    private Position[] goalGreen;

    public Home getHomeYellow() {
        return homeYellow;
    }

    public Home getHomeRed() {
        return homeRed;
    }

    public Home getHomeBlue() {
        return homeBlue;
    }

    public Home getHomeGreen() {
        return homeGreen;
    }

    public Board(String color1, String color2) {
        this.squares = new Square[68];

        this.goalYellow = new Position[8];
        this.goalRed = new Position[8];
        this.goalBlue = new Position[8];
        this.goalGreen = new Position[8];

        this.positions = new Position[68];
        this.homeYellow = new Home(color1);
        this.homeRed = new Home(color2);
        this.homeBlue = new Home("Azul");
        this.homeGreen = new Home("verde");
        setPositions();
        setQuadrant1();
        setGoalPositions();
    }

    public void setPositions() {
        positions = new Position[68];
        squares = new Square[68];

        //Amarillo
        positions[0] = new Position(385, 624);
        positions[1] = new Position(385, 594);
        positions[2] = new Position(385, 564);
        positions[3] = new Position(385, 534);
        positions[4] = new Position(385, 504); // salida casa
        positions[5] = new Position(385, 474);
        positions[6] = new Position(385, 444);
        positions[7] = new Position(370, 407);
        positions[8] = new Position(399, 380);
        positions[9] = new Position(434, 393);
        positions[10] = new Position(463, 393);
        positions[11] = new Position(498, 393); // especial
        positions[12] = new Position(529, 393);
        positions[13] = new Position(557, 393);
        positions[14] = new Position(586, 393);
        positions[15] = new Position(615, 393);
        positions[16] = new Position(615, 320); // especial

        // Azul
        positions[17] = new Position(615, 250);
        positions[18] = new Position(587, 250);
        positions[19] = new Position(559, 250);
        positions[20] = new Position(531, 250);
        positions[21] = new Position(493, 246); // salida casa
        positions[22] = new Position(465, 250);
        positions[23] = new Position(434, 250);

        positions[24] = new Position(404, 258);
        positions[25] = new Position(367, 234);
        positions[26] = new Position(385, 199);
        positions[27] = new Position(385, 171);
        positions[28] = new Position(385, 143); // especial
        positions[29] = new Position(385, 104);
        positions[30] = new Position(385, 76);
        positions[31] = new Position(385, 45);
        positions[32] = new Position(385, 12);

        positions[33] = new Position(315, 12); // especial

        // Rojo
        positions[34] = new Position(247, 12);
        positions[35] = new Position(247, 45);
        positions[36] = new Position(247, 78);
        positions[37] = new Position(247, 111);
        positions[38] = new Position(247, 144); // salida casa
        positions[39] = new Position(247, 177);
        positions[40] = new Position(247, 210);

        positions[41] = new Position(259, 226);
        positions[42] = new Position(228, 261);

        positions[43] = new Position(229, 259);
        positions[44] = new Position(190, 248);
        positions[45] = new Position(130, 252); // especial
        positions[46] = new Position(98, 252);
        positions[47] = new Position(67, 252);
        positions[48] = new Position(40, 252);
        positions[49] = new Position(5, 252);
        positions[50] = new Position(11, 313); // especial

        // Verde
        positions[51] = new Position(11, 389);
        positions[52] = new Position(39, 389);
        positions[53] = new Position(71, 389);
        positions[54] = new Position(104, 389);
        positions[55] = new Position(132, 389); // salida casa
        positions[56] = new Position(165, 389);
        positions[57] = new Position(196, 389);
        positions[58] = new Position(224, 389);

        positions[59] = new Position(256, 409);
        positions[60] = new Position(250, 440);
        positions[61] = new Position(250, 468);
        positions[62] = new Position(250, 502); // especial
        positions[63] = new Position(250, 536);
        positions[64] = new Position(250, 565);
        positions[65] = new Position(250, 597);
        positions[66] = new Position(250, 628);
        positions[67] = new Position(314, 629); // especial

        // Crear los Square
        //casillas especiales
        int[] specialPositions = {11, 16, 28, 33, 45, 50, 62, 67};

        for (int i = 0; i < 68; i++) {
            boolean isSpecial = false;
            for (int j = 0; j < specialPositions.length; j++) {
                if (i == specialPositions[j]) {
                    isSpecial = true;
                    break;
                }
            }
            if (isSpecial) {
                squares[i] = new SpecialSquare(null, positions[i]);
                squares[i].setType("special");
            } else {
                squares[i] = new NormalSquare();
                squares[i].setPosition(positions[i]);
                squares[i].setType("normal");
            }
        }

    }//end setPositions

    public void setGoalPositions() {
        // Asigna TUS 8 coordenadas para cada color (índices 0 a 7)

        // CASILLAS DE META AMARILLAS
        goalYellow[0] = new Position(318, 599);
        goalYellow[1] = new Position(318, 561);
        goalYellow[2] = new Position(318, 530);
        goalYellow[3] = new Position(318, 497);
        goalYellow[4] = new Position(318, 467);
        goalYellow[5] = new Position(318, 439);
        goalYellow[6] = new Position(318, 397);
        goalYellow[7] = new Position(318, 352); // Casilla de meta

        // CASILLAS DE META ROJAS
        goalRed[0] = new Position(316, 40);
        goalRed[1] = new Position(316, 67);
        goalRed[2] = new Position(316, 99);
        goalRed[3] = new Position(316, 128);
        goalRed[4] = new Position(316, 163);
        goalRed[5] = new Position(316, 189);
        goalRed[6] = new Position(316, 222);
        goalRed[7] = new Position(316, 362); //Casilla demeta

        // CASILLAS DE META AZULES
        goalBlue[0] = new Position(590, 325);
        goalBlue[1] = new Position(559, 325);
        goalBlue[2] = new Position(526, 325);
        goalBlue[3] = new Position(495, 325);
        goalBlue[4] = new Position(466, 325);
        goalBlue[5] = new Position(437, 325);
        goalBlue[6] = new Position(400, 325);
        goalBlue[7] = new Position(364, 325);//Casilla de meta

        // CASILLAS DE META VERDES
        goalGreen[0] = new Position(40, 322);
        goalGreen[1] = new Position(70, 322);
        goalGreen[2] = new Position(100, 322);
        goalGreen[3] = new Position(128, 322);
        goalGreen[4] = new Position(163, 322);
        goalGreen[5] = new Position(195, 322);
        goalGreen[6] = new Position(222, 322);
        goalGreen[7] = new Position(259, 322);

    }

    public void setQuadrant1() {
        // Amarillo
        Piece fichaAmarilla0 = new Piece(new Position(512, 521), new ImageIcon("./src/main/resources/img/fichaAmarilla.png"));
        fichaAmarilla0.setPosicionActual(-1);
        fichaAmarilla0.setColor(Color.YELLOW);
        homeYellow.setPiece(0, fichaAmarilla0);
        //
        Piece fichaAmarilla1 = new Piece(new Position(550, 521), new ImageIcon("./src/main/resources/img/fichaAmarilla.png"));
        fichaAmarilla1.setPosicionActual(-1);
        fichaAmarilla1.setColor(Color.YELLOW);
        homeYellow.setPiece(1, fichaAmarilla1);
        //
        Piece fichaAmarilla2 = new Piece(new Position(515, 558), new ImageIcon("./src/main/resources/img/fichaAmarilla.png"));
        fichaAmarilla2.setPosicionActual(-1);
        fichaAmarilla2.setColor(Color.YELLOW);
        homeYellow.setPiece(2, fichaAmarilla2);
        //
        Piece fichaAmarilla3 = new Piece(new Position(550, 558), new ImageIcon("./src/main/resources/img/fichaAmarilla.png"));
        fichaAmarilla3.setPosicionActual(-1);
        fichaAmarilla3.setColor(Color.YELLOW);
        homeYellow.setPiece(3, fichaAmarilla3);

        // Rojo
        Piece fichaRoja0 = new Piece(new Position(84, 75), new ImageIcon("./src/main/resources/img/fichaRoja.png"));
        fichaRoja0.setPosicionActual(-1);
        fichaRoja0.setColor(Color.RED);
        homeRed.setPiece(0, fichaRoja0);
        //
        Piece fichaRoja1 = new Piece(new Position(120, 75), new ImageIcon("./src/main/resources/img/fichaRoja.png"));
        fichaRoja1.setPosicionActual(-1);
        fichaRoja1.setColor(Color.RED);
        homeRed.setPiece(1, fichaRoja1);
        //
        Piece fichaRoja2 = new Piece(new Position(84, 117), new ImageIcon("./src/main/resources/img/fichaRoja.png"));
        fichaRoja2.setPosicionActual(-1);
        fichaRoja2.setColor(Color.RED);
        homeRed.setPiece(2, fichaRoja2);
        //
        Piece fichaRoja3 = new Piece(new Position(120, 117), new ImageIcon("./src/main/resources/img/fichaRoja.png"));
        fichaRoja3.setPosicionActual(-1);
        fichaRoja3.setColor(Color.RED);
        homeRed.setPiece(3, fichaRoja3);

        // Verde
        Piece fichaVerde0 = new Piece(new Position(89, 516), new ImageIcon("./src/main/resources/img/fichaVerde.png"));
        fichaVerde0.setPosicionActual(-1);
        fichaVerde0.setColor(Color.GREEN);
        homeGreen.setPiece(0, fichaVerde0);
        //
        Piece fichaVerde1 = new Piece(new Position(119, 516), new ImageIcon("./src/main/resources/img/fichaVerde.png"));
        fichaVerde1.setPosicionActual(-1);
        fichaVerde1.setColor(Color.GREEN);
        homeGreen.setPiece(1, fichaVerde1);
        //
        Piece fichaVerde2 = new Piece(new Position(89, 561), new ImageIcon("./src/main/resources/img/fichaVerde.png"));
        fichaVerde2.setPosicionActual(-1);
        fichaVerde2.setColor(Color.GREEN);
        homeGreen.setPiece(2, fichaVerde2);
        //
        Piece fichaVerde3 = new Piece(new Position(119, 561), new ImageIcon("./src/main/resources/img/fichaVerde.png"));
        fichaVerde3.setPosicionActual(-1);
        fichaVerde3.setColor(Color.GREEN);
        homeGreen.setPiece(3, fichaVerde3);

        // Azul
        Piece fichaAzul0 = new Piece(new Position(509, 88), new ImageIcon("./src/main/resources/img/fichaAzul.png"));
        fichaAzul0.setPosicionActual(-1);
        fichaAzul0.setColor(Color.BLUE);
        homeBlue.setPiece(0, fichaAzul0);
        //
        Piece fichaAzul1 = new Piece(new Position(548, 88), new ImageIcon("./src/main/resources/img/fichaAzul.png"));
        fichaAzul1.setPosicionActual(-1);
        fichaAzul1.setColor(Color.BLUE);
        homeBlue.setPiece(1, fichaAzul1);
        //
        Piece fichaAzul2 = new Piece(new Position(509, 130), new ImageIcon("./src/main/resources/img/fichaAzul.png"));
        fichaAzul2.setPosicionActual(-1);
        fichaAzul2.setColor(Color.BLUE);
        homeBlue.setPiece(2, fichaAzul2);
        //
        Piece fichaAzul3 = new Piece(new Position(548, 130), new ImageIcon("./src/main/resources/img/fichaAzul.png"));
        fichaAzul3.setPosicionActual(-1);
        fichaAzul3.setColor(Color.BLUE);
        homeBlue.setPiece(3, fichaAzul3);

    }

    public void draw(Component c, Graphics g) {
        //this.squares[0].getPiece().draw(c, g);

        for (int i = 0; i < homeYellow.getLength(); i++) {

            homeYellow.getPiece(i).draw(c, g);
            homeRed.getPiece(i).draw(c, g);
            homeBlue.getPiece(i).draw(c, g);
            homeGreen.getPiece(i).draw(c, g);
        }
    }//end draw

    public void start() {
        setPositions();
        setQuadrant1();
        setGoalPositions();
    }

    public void movePice(Piece piece, int steps) {
        int posActual = piece.getPosicionActual();

        // Salida de casa
        if (posActual == -1) {
            if (steps == 5) {
                int exit = 0;
                if (piece.getColor().equals(Color.YELLOW)) {
                    exit = 4;
                } else if (piece.getColor().equals(Color.BLUE)) {
                    exit = 21;
                } else if (piece.getColor().equals(Color.RED)) {
                    exit = 38;
                } else if (piece.getColor().equals(Color.GREEN)) {
                    exit = 55;
                }

                piece.setPosicionActual(exit);
                piece.setPosition(positions[exit]);
            }
            return;
        }

        // Ya en meta
        if (piece.isInGoalTrack()) {
            int posMetaActual = piece.getPosicionActualEnMeta();
            int nuevaMetaPos = posMetaActual + steps;
            if (nuevaMetaPos <= 7) {
                piece.setPosicionActualEnMeta(nuevaMetaPos);
                Position[] goalArray = getGoalArrayForColor(piece.getColor());
                piece.setPosition(goalArray[nuevaMetaPos]);
            }
            return;
        }

//        int entryIndex = getEntrySquareIndex(piece.getColor());
        int entryIndex = getEntrySquareIndex(piece.getColor());

        if (posActual <= entryIndex && posActual + steps > entryIndex) {
            int pasosSobrantes = (posActual + steps) - entryIndex - 1;

            if (pasosSobrantes <= 7) {
                piece.setInGoalTrack(true);
                piece.setPosicionActualEnMeta(pasosSobrantes);
                piece.setPosicionActual(-2);
                Position[] goalArray = getGoalArrayForColor(piece.getColor());
                piece.setPosition(goalArray[pasosSobrantes]);
                return;
            }
        }

        // Movimiento normal
        int nuevaPos = (posActual + steps) % 68;
        piece.setPosicionActual(nuevaPos);
        piece.setPosition(positions[nuevaPos]);
    }//fin class movePiece

    public Position getPosition(int i) {
        if (i >= 0 && i < positions.length) {
            return positions[i];
        } else {
            return null;
        }
    }

    public Position[] getPositions() {
        return positions;
    }

    public Square getSquareAt(int index) {
        if (index >= 0 && index < squares.length) {
            return squares[index];
        } else {
            return null;
        }
    }

    private Position[] getGoalArrayForColor(Color color) {
        //devuelve el arreglo de coordenadas de cada meta segun el color
        if (color.equals(Color.YELLOW)) {
            return goalYellow;
        } else if (color.equals(Color.RED)) {
            return goalRed;
        } else if (color.equals(Color.BLUE)) {
            return goalBlue;
        } else if (color.equals(Color.GREEN)) {
            return goalGreen;
        }
        return null;
    }

    public int countPiecesInGoal(Home home) {
        int count = 0;

        if (home == null) {
            return 0;
        }
        for (int i = 0; i < home.getLength(); i++) {
            Piece piece = home.getPiece(i);

            if (piece.isInGoalTrack() && piece.getPosicionActualEnMeta() == 7) {
                count++;
            }
        }
        return count;
    }

    private int getEntrySquareIndex(Color color) {
        if (color.equals(Color.YELLOW)) {
            return 67; // Entrada Amarilla
        } else if (color.equals(Color.BLUE)) {
            return 16; // Entrada Azul
        } else if (color.equals(Color.RED)) {
            return 33; // Entrada Roja
        } else if (color.equals(Color.GREEN)) {
            return 50; // Entrada Verde
        }
        return -1;
    }

}//fin class
