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
public class NormalSquare extends Square {
    public void applyRule(Player player, QuestionBank bank) {
        Question question = bank.getQuestionByLevel(1); // dificultad facil
        if (question == null) return;

        String input = JOptionPane.showInputDialog(question.getQuestion() + "\n(V) Verdadero o (F) Falso:");
        if (input == null) return;

        boolean userAnswer = input.equals("V");
        boolean correct = question.answer(userAnswer);

        if (correct) {
            player.sumScore(1);
            JOptionPane.showMessageDialog(null, "Correcto. +1 punto");
        } else {
            player.resScore(1);
            JOptionPane.showMessageDialog(null, "Incorrecto. −1 punto");
        }
    }
    
}//fin class
