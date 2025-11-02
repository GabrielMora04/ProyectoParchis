/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.model;

import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Mora Hernandez
 */
public class SpecialSquare extends Square {

    private String type;

    public SpecialSquare(String type) {
        this.type = type;
        this.setType("special");
    }

    public SpecialSquare(String type, Position position) {
        super(position);
        this.type = type;
        this.setType("special");
    }

    public SpecialSquare(String type, Piece piece, Position position) {
        super(piece, position);
        this.type = type;
        this.setType("special");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void applySpecialRule(Player player, QuestionBank bank) {
        Question question = bank.getQuestionByLevel(2); // pregunta dificultad media o dificil
        if (question == null) {
            return;
        }

        String input = JOptionPane.showInputDialog(question.getQuestion() + "\n(V) Verdadero o (F) Falso:");
        if (input == null) {
            return;
        }

        boolean userAnswer = input.equals("V");
        boolean correct = question.answer(userAnswer);

        if (correct) {
            player.setExtraTurn(true);
            JOptionPane.showMessageDialog(null, "Correcto. Ganaste un turno extra.");
        } else {
            player.setSkipTurn(true);
            JOptionPane.showMessageDialog(null, "Incorrecto. Pierdes un turno");
        }
    }
}//fin class
