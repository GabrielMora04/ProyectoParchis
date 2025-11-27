/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.view;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import main.controller.GameController;

/**
 *
 * @author Gabriel Mora Hernandez
 */
public class GUIGameOver extends javax.swing.JFrame {

    private GUIInicio gUIInicio;
    private GameController gameController;

    /**
     * Creates new form GUIGameOver
     */
    public GUIGameOver(String nombreJugador, int tiempoSegundos, int puntajeFinal) {
        initComponents();
        lblJugador.setText("Jugador: " + nombreJugador);
        lblTiempo.setText("Tiempo total: " + tiempoSegundos + " segundos");
        lblPuntaje.setText("Puntaje final: " + puntajeFinal);
    }

    public JLabel getLblJugador() {
        return lblJugador;
    }

    public JLabel getLblTiempo() {
        return lblTiempo;
    }

    public JLabel getLblPuntaje() {
        return lblPuntaje;
    }
    
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnReiniciar = new javax.swing.JButton();
        btnVolverInicio = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblJugador = new javax.swing.JLabel();
        lblTiempo = new javax.swing.JLabel();
        lblPuntaje = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnReiniciar.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnReiniciar.setText("Reiniciar");
        btnReiniciar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnReiniciar.setContentAreaFilled(false);
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btnReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 90, 40));

        btnVolverInicio.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnVolverInicio.setText("Volver a Inicio");
        btnVolverInicio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVolverInicio.setContentAreaFilled(false);
        btnVolverInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverInicioActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolverInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 130, 40));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        lblTitulo.setText("¡GAME OVER!");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));

        lblJugador.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lblJugador.setText("Jugador: ");
        getContentPane().add(lblJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 230, -1));

        lblTiempo.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lblTiempo.setText("Tiempo total:");
        getContentPane().add(lblTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 310, -1));

        lblPuntaje.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lblPuntaje.setText("Puntaje final: ");
        getContentPane().add(lblPuntaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 280, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoGameOver.png"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverInicioActionPerformed
        dispose(); // cierra la ventana de GameOver
    GUIInicio inicio = new GUIInicio();
    inicio.setVisible(true); // Abre la ventana de GUIInicio
    
    }//GEN-LAST:event_btnVolverInicioActionPerformed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
       dispose(); // cierra la ventana de GUIWin
    GUIInicio inicio = new GUIInicio(); 
    inicio.setVisible(true);
    new GameController(inicio); // reinicia la partida
    }//GEN-LAST:event_btnReiniciarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnVolverInicio;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblJugador;
    private javax.swing.JLabel lblPuntaje;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
