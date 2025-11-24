/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import main.model.Board;
import main.model.Dices;
import main.model.GameArea;
import main.model.Home;
import main.model.NormalSquare;
import main.model.Piece;
import main.model.Player;
import main.model.Position;
import main.model.QuestionBank;
import main.model.SoundManager;
import main.model.SpecialSquare;
import main.model.Square;
import main.model.StopWatchThread;
import main.view.BoardPanel;
import main.view.ControllPanel;
import main.view.GUIGameOver;
import main.view.GUIInicio;
import main.view.GUITablero;
import main.view.GUIWin;

/**
 *
 * @author Gabriel Mora Hernandez
 */
public class GameController implements ActionListener, MouseListener {

    private BoardPanel boardPanel;
    private GUITablero gUITablero;
    private GameArea gameArea;
    private Piece piece;
    private ControllPanel controllPanel;
    private GUIInicio gUIInicio;
    private Dices dices;
    private Board board;
    private Player player1;
    private Player player2;
    private Player playerActive;
    private int turno;
    private QuestionBank questionBank;
    private StopWatchThread stopWatchThread;
    private GUIGameOver gUIGameOver;
    private GUIWin gUIWin;
    private SoundManager soundManager;

    public GameController(GUIInicio gUIInicio) {
        SoundManager.playAmbiente("/sounds/ambiente.wav");
        this.questionBank = new QuestionBank();
        this.gUIInicio = gUIInicio;
        this.gUITablero = new GUITablero(this);
        this.gUITablero.setVisible(true);

        this.controllPanel = gUITablero.getPanelControll();

        this.board = new Board("Red", "Amarillo");
        this.gameArea = new GameArea(this.board);
        this.boardPanel = gUITablero.getBoardPanel();
        this.boardPanel.setController(this);

        this.dices = new Dices();

        this.player1 = new Player("Jugador 1", Color.RED);
        this.player2 = new Player("Jugador 2", Color.YELLOW);

        this.stopWatchThread = new StopWatchThread(controllPanel);
        this.stopWatchThread.start();

        this.playerActive = player1;
        updatePlayerActive();
    }

    public GameController(Player p1, Player p2, ControllPanel controllPanel) {
        this.player1 = p1;
        this.player2 = p2;
        this.controllPanel = controllPanel;
    }

    public void draw(Component c, Graphics g) {
        gameArea.draw(c, g);
        //board.draw(c, g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Lanzar Dado":
                Player active = getPlayerActive();
                startTurn(active);
                System.out.println("Turno actual: " + active.getName());

                int resultado = dices.rollDice();
                System.out.println("Dado: " + resultado);

                controllPanel.getLblResultadoDado().setText("Dado: " + resultado);
//                controllPanel.getLblResultadoDado().setForeground(active.getColor());

                Piece piece;
                if (active == player1) {
                    piece = board.getHomeRed().getPiece(0);
                } else {
                    piece = board.getHomeYellow().getPiece(0);
                }

                //Movimiento de las ficha
                // Saca la ficha si esta en casa y si sale 5 en dado
                if (piece.getPosicionActual() == -1 && resultado == 5) {
                    if (active == player1) {
                        // salida del jugador 1 
                        piece.setPosicionActual(38);
                        piece.setPosition(board.getPosition(38));
                    } else {
                        // salida del jugador 2 
                        piece.setPosicionActual(4);
                        piece.setPosition(board.getPosition(47));
                    }

                    boardPanel.repaint();

                    Square squareActual = board.getSquareAt(piece.getPosicionActual());
                    if (squareActual.getType().equals("special")) {
                        ((SpecialSquare) squareActual).applySpecialRule(active, questionBank);
                    } else {
                        ((NormalSquare) squareActual).applyRule(active, questionBank);
                    }

                } else if (piece.getPosicionActual() != -1) {
                    int nuevaPos = piece.getPosicionActual() + resultado;

                    if (nuevaPos >= board.getPositions().length) {
                        nuevaPos = nuevaPos % board.getPositions().length;// 
                    }

                    piece.setPosicionActual(nuevaPos);
                    piece.setPosition(board.getPosition(nuevaPos));

                    boardPanel.repaint();

                    Square squareActual = board.getSquareAt(piece.getPosicionActual());
                    if (squareActual.getType().equals("special")) {
                        ((SpecialSquare) squareActual).applySpecialRule(active, questionBank);
                    } else {
                        ((NormalSquare) squareActual).applyRule(active, questionBank);
                    }
                }
                //

                //Sistema de Colisiones 
                Piece fichaRival;
                if (active == player1) {
                    fichaRival = board.getHomeYellow().getPiece(0);
                } else {
                    fichaRival = board.getHomeRed().getPiece(0);
                }

                if (fichaRival != null
                        && fichaRival.getPosicionActual() == piece.getPosicionActual()
                        && piece.getPosicionActual() != -1) {

                    System.out.println("Colisión detectada!");

                    boolean respuestaCorrecta = questionBank.launchSpecialQuest(active);

                    if (respuestaCorrecta) {
                        active.sumScore(2); // acierto +2
                        SoundManager.playEffect("/sounds/correcta.wav");   // acierto
                        System.out.println(active.getName() + " acertó, gana +2 puntos.");
                    } else {
                        active.resScore(3); // fallo −3
                        piece.setPosicionActual(-1); // ficha vuelve a casa
                        SoundManager.playEffect("/sounds/incorrecta.wav"); // error

                        System.out.println(active.getName() + " falló, pierde −3 puntos y su ficha vuelve a casa.");
                        boardPanel.repaint();
                    }
                }//Fin sistema de colisiones

                //Verifica si el porcentaje es 0 y muestra Over
                if (active.getScore() <= 0) {
                    stopWatchThread.detener();
                    int tiempoTotal = stopWatchThread.getSegundos();
                    SoundManager.stopAmbiente();

                    GUIGameOver gameOver = new GUIGameOver(active.getName(),
                            tiempoTotal, active.getScore());
                    gameOver.setVisible(true);

                    gUITablero.dispose();
                    return; // salir
                }

                //Prueba GUIWin
                if (active.getScore() == 6) {
                    stopWatchThread.detener();
                    int tiempoTotal = stopWatchThread.getSegundos();
                    SoundManager.stopAmbiente();
                    SoundManager.playEffect("/sounds/victory.wav");

                    GUIWin gUIWin = new GUIWin(active.getName(),
                            tiempoTotal, active.getScore());
                    gUIWin.setVisible(true);

                    gUITablero.dispose();
                    return; // salir
                }

                //Sistema de turno extra/pierde turno
                if (active.hasExtraTurn()) {
                    // el jugador gana un turno y juega otra vez
                    active.setExtraTurn(false); //usa el turno extra
                    System.out.println(active.getName() + " juega de nuevo por turno extra.");
                } else {
                    // sigue el turno del otro jugador
                    alternateTurno();
                }

                updatePlayerActive();

                break;
            case "Jugador1":
                System.out.println("Jugador 1 presionado");
                break;
            case "Jugador2":
                System.out.println("Jugador 2 presionado");
                break;
            case "Jugar":
                System.out.println("Jugar presionado");
                break;
            case "Detener tiempo":
                stopWatchThread.detener();
                break;
            case "Salir":
                System.exit(0);
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e
    ) {

        System.out.println("X= " + e.getX() + " Y= " + e.getY());

    }

    @Override
    public void mousePressed(MouseEvent e
    ) {
    }

    @Override
    public void mouseReleased(MouseEvent e
    ) {
    }

    @Override
    public void mouseEntered(MouseEvent e
    ) {
    }

    @Override
    public void mouseExited(MouseEvent e
    ) {
    }

    private Player getPlayerActive() {
        if (turno == 0) {
            return player1;
        } else {
            return player2;
        }
    }

    private void alternateTurno() {
        turno = (turno + 1) % 2; //alterna entre 0 y 1, jugador1 = 0 y jugador 2 = 1
    }

    private void updatePlayerActive() {
        Player active = getPlayerActive();
        controllPanel.getLblJugador().setText("Turno: " + active.getName());
        controllPanel.getLblJugador().setForeground(active.getColor());
        controllPanel.getLblPuntaje().setText("Puntaje: " + active.getScore());
    }

    public void startTurn(Player player) {
        if (player.SkipTurn()) {
            player.setSkipTurn(false);
            System.out.println(player.getName() + " pierde el turno.");
            alternateTurno();
            updatePlayerActive();
            return;
        }
        if (player.hasExtraTurn()) {
            player.setExtraTurn(false);
            System.out.println(player.getName() + " tiene un turno extra.");
        }

    }

}//end class

