/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.act2_lary;

public abstract class clsCuenta {
    protected String titular;
    protected double saldo;

    // Constructor con validación
    public clsCuenta(String titular, double saldoInicial) {
        this.titular = titular;
        if(saldoInicial < 0) {
            this.saldo = 0;
        } else {
            this.saldo = saldoInicial;
        }
    }

    public abstract void depositar(double cantidad);
    public abstract void retirar(double cantidad);
}