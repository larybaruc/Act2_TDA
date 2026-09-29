/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.act2_lary;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

// ==========================================================
// Alumno: Lary Baruc Nolasco Linarte
// ==========================================================

public class Act2_laRY extends JFrame implements ActionListener {
    
    clsahorro cuentaLary; // Usamos el nombre de la clase
    JTextField txtMonto, txtMeses;
    JTextArea areaResultados;
    JButton btnDepositar, btnRetirar, btnProyectar, btnDatos;

    public Act2_laRY() {
        // Inicializamos el TDA con el nombre de la clase
        cuentaLary = new clsahorro("Lary Baruc Nolasco Linarte", 500.0, 5.0);

        setTitle("Actividad 02 - TDA en Java");
        setSize(350, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Identidad del autor visible
        JLabel labelAutor = new JLabel("Autor: Lary Baruc Nolasco Linarte");
        add(labelAutor);

        add(new JLabel("Monto a depositar o retirar:"));
        txtMonto = new JTextField(15);
        add(txtMonto);

        btnDepositar = new JButton("Depositar");
        btnDepositar.addActionListener(this);
        add(btnDepositar);

        btnRetirar = new JButton("Retirar");
        btnRetirar.addActionListener(this);
        add(btnRetirar);

        add(new JLabel("Meses para proyectar interes:"));
        txtMeses = new JTextField(15);
        add(txtMeses);

        btnProyectar = new JButton("Calcular con Recursividad");
        btnProyectar.addActionListener(this);
        add(btnProyectar);

        btnDatos = new JButton("Ver Resumen");
        btnDatos.addActionListener(this);
        add(btnDatos);

        areaResultados = new JTextArea(10, 25);
        areaResultados.setEditable(false);
        add(new JScrollPane(areaResultados));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDepositar) {
            double monto = Double.parseDouble(txtMonto.getText());
            cuentaLary.depositar(monto);
            areaResultados.setText("Se deposito el dinero.\n" + cuentaLary.verDatos());
        } 
        else if (e.getSource() == btnRetirar) {
            double monto = Double.parseDouble(txtMonto.getText());
            cuentaLary.retirar(monto);
            areaResultados.setText("Retiro procesado.\n" + cuentaLary.verDatos());
        }
        else if (e.getSource() == btnProyectar) {
            int meses = Integer.parseInt(txtMeses.getText());
            double total = cuentaLary.calcularInteresRecursivo(meses, cuentaLary.getSaldo());
            areaResultados.setText("Saldo en " + meses + " meses:\n$" + total);
        }
        else if (e.getSource() == btnDatos) {
            areaResultados.setText(cuentaLary.verDatos());
        }
    }

    public static void main(String[] args) {
        Act2_laRY ventana = new Act2_laRY();
        ventana.setVisible(true);
    }
}