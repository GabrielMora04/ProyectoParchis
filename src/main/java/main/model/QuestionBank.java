/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.model;

/**
 *
 * @author Gabriel Mora Hernandez
 */
public class QuestionBank {

    private Question[] questions;

    public QuestionBank() {
        questions = new Question[15];
        loadQuestions();
    }

    private void loadQuestions() {
        questions[0] = new Question("Los tiburones son mamíferos.", false, 1);
        questions[1] = new Question("El océano Pacífico es el océano más grande.", true, 1);
        questions[2] = new Question("Los arrecifes de coral están formados por plantas.", false, 1);
        questions[3] = new Question("La fosa de las Marianas es la parte más profunda del océano.", true, 2);
        questions[4] = new Question("Los delfines respiran a través de branquias.", false, 1);
        questions[5] = new Question("Las tortugas marinas ponen sus huevos en tierra.", true, 1);
        questions[6] = new Question("El océano cubre más del 70% de la superficie terrestre.", true, 2);
        questions[7] = new Question("Los pulpos tienen tres corazones", true, 2);
        questions[8] = new Question("El agua salada se congela a la misma temperatura que el agua dulce.", false, 2);
        questions[9] = new Question("El Titanic se hundió en el océano Pacífico.", false, 1);
        questions[10] = new Question("Las ballenas son los animales más grandes de la Tierra.", true, 2);
        questions[11] = new Question("El mar de los Sargazos no tiene fronteras terrestres.", true, 3);
        questions[12] = new Question("Las medusas son peces.", false, 1);
        questions[13] = new Question("El océano produce la mayor parte del oxígeno que respiramos.", true, 3);
        questions[14] = new Question("Todas las criaturas marinas viven en agua salada.", false, 1);
    }

    public Question getQuestionByLevel(int level) {

        int count = 0;
        for (int i = 0; i < questions.length; i++) {
            if (questions[i] != null && questions[i].getLevel() == level) {
                count++;
            }
        }
        if (count == 0) {
            return null;
        }

        //Arreglo con solo las preguntas del nivel que vayamos a ocupar
        Question[] filtro = new Question[count];
        int index = 0;
        for (int i = 0; i < questions.length; i++) {
            if (questions[i] != null && questions[i].getLevel() == level) {
                filtro[index++] = questions[i];
            }
        }

        // Se aleatoriza la pregunta que salga
        int aleatoria = (int) (Math.random() * filtro.length);
        return filtro[aleatoria];
    }
      
}//fin class
