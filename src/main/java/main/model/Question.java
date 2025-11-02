/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.model;

/**
 *
 * @author Gabriel Mora Hernandez
 */
public class Question {

    private String question;
    private boolean correctAnswer;
    private int level; // 1 = facil, 2 = medio, 3 = dificil
    private int correctCount;
    private int wrongCount;

    public Question(String question, boolean correctAnswer, int level) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.level = level;
        this.correctCount = 0;
        this.wrongCount = 0;
    }

    public boolean answer(boolean userAnswer) {
        if (userAnswer == correctAnswer) {
            correctCount++;
            return true;
        } else {
            wrongCount++;
            return false;
        }
    }

    public String getQuestion() {
        return question;
    }

    public int getLevel() {
        return level;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getWrongCount() {
        return wrongCount;
    }

}//fin class
