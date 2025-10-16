/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package main.view;

import java.awt.event.ActionListener;

/**
 *
 * @author gabri
 */
public class GUIInicio extends javax.swing.JPanel {

    /**
     * Creates new form GUIInicio
     */
    public GUIInicio() {
        initComponents();
    }

     public void setListener(ActionListener controller){
        this.btnInstructions.addActionListener(controller);
        this.btnHistory.addActionListener(controller);
        this.btnCredits.addActionListener(controller);
        this.btnHistory.addActionListener(controller);
        
        
     }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnInstructions = new javax.swing.JButton();
        btnHistory = new javax.swing.JButton();
        btnCredits = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();
        lblWelcome = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInstructions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnInstrucciones.png"))); // NOI18N
        add(btnInstructions, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 140, 50));

        btnHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnHistoria.png"))); // NOI18N
        add(btnHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 130, 50));

        btnCredits.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnCreditos.png"))); // NOI18N
        add(btnCredits, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 390, 130, 50));

        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnJugar.png"))); // NOI18N
        add(btnPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 130, 50));

        lblWelcome.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        lblWelcome.setText("¡Bienvenido a Parchís!");
        add(lblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, -1, -1));

        lblFondo.setBackground(new java.awt.Color(0, 0, 0));
        lblFondo.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 524));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCredits;
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnInstructions;
    private javax.swing.JButton btnPlay;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblWelcome;
    // End of variables declaration//GEN-END:variables
}
