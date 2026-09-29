/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.act2_lary;

public class clsahorro extends clsCuenta {
    private double porcentajeInteres;
    public clsahorro(String titular, double saldoInicial, double porcentajeInteres) {
        super(titular, saldoInicial);
        if(porcentajeInteres < 0){
            this.porcentajeInteres = 0;
        } else {
            this.porcentajeInteres = porcentajeInteres;
        }
    }

    // Getters y setters
    public String getTitular() { return titular; }
    public void setTitular(String titular) { this.titular = titular; }
    public double getSaldo() { return saldo; }
    public double getPorcentajeInteres() { return porcentajeInteres; }

    @Override
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo = saldo + cantidad;
        }
    }

    @Override
    public void retirar(double cantidad) {
        if (cantidad > 0 && saldo >= cantidad) {
            saldo = saldo - cantidad;
        }
    }

    public String verDatos() {
        return "Cliente: " + titular + " | Saldo Actual: $" + saldo;
    }

    // Método recursivo obligatorio
    public double calcularInteresRecursivo(int meses, double saldoAcumulado) {
        if (meses == 0) {
            return saldoAcumulado; 
        }
        double interesMes = saldoAcumulado * (porcentajeInteres / 100);
        return calcularInteresRecursivo(meses - 1, saldoAcumulado + interesMes);
    }
}