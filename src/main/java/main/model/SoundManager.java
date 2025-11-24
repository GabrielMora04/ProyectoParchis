/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.model;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Gabriel Mora Hernandez
 */
public class SoundManager {
////////////???
    private static Clip ambienteClip;

    // Reproduce sonidos cortos
    public static void playEffect(String path) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                SoundManager.class.getResource(path));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Inicia sonido en loop
    public static void playAmbiente(String path) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                SoundManager.class.getResource(path));
            ambienteClip = AudioSystem.getClip();
            ambienteClip.open(audioInputStream);
            ambienteClip.loop(Clip.LOOP_CONTINUOUSLY); // se repite infinito
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Detiene la música de ambiente
    public static void stopAmbiente() {
        if (ambienteClip != null && ambienteClip.isRunning()) {
            ambienteClip.stop();
        }
    }
/////////////
}
