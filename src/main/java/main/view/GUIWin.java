/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.view;

import javax.swing.JLabel;
import main.controller.GameController;

/**
 *
 * @author Gabriel Mora Hernandez
 */
public class GUIWin extends javax.swing.JFrame {

    private GUIInicio gUIInicio;
    private GameController gameController;

    /**
     * Creates new form GUIWin
     */
    public GUIWin(String nombreJugador, int tiempoSegundos, int puntajeFinal) {
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

        lblWin = new javax.swing.JLabel();
        lblJugador = new javax.swing.JLabel();
        lblPuntaje = new javax.swing.JLabel();
        lblTiempo = new javax.swing.JLabel();
        btnReiniciar = new javax.swing.JButton();
        lblInicio = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblWin.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        lblWin.setText("¡Has Ganado!");
        getContentPane().add(lblWin, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, -1, -1));

        lblJugador.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblJugador.setText("Jugador:");
        getContentPane().add(lblJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 200, -1));

        lblPuntaje.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblPuntaje.setText("Puntaje Final:");
        getContentPane().add(lblPuntaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 180, -1));

        lblTiempo.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblTiempo.setText("Tiempo total:");
        getContentPane().add(lblTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 160, -1));

        btnReiniciar.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnReiniciar.setText("Reiniciar");
        btnReiniciar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btnReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, 90, 40));

        lblInicio.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblInicio.setText("Volver a inicio");
        lblInicio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblInicioActionPerformed(evt);
            }
        });
        getContentPane().add(lblInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 361, 140, 40));

        lblFondo.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblFondo.setText("jLabel4");
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -4, 560, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblInicioActionPerformed
        dispose(); // cierra la ventana de GUIWin
        GUIInicio inicio = new GUIInicio();
        inicio.setVisible(true); // Abre la ventana de GUIInicio
    }//GEN-LAST:event_lblInicioActionPerformed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        dispose(); // cierra la ventana de GUIWin
        GUIInicio inicio = new GUIInicio();
        inicio.setVisible(true);
        new GameController(inicio); // reinicia la partida
    }//GEN-LAST:event_btnReiniciarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JButton lblInicio;
    private javax.swing.JLabel lblJugador;
    private javax.swing.JLabel lblPuntaje;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JLabel lblWin;
    // End of variables declaration//GEN-END:variables
}
