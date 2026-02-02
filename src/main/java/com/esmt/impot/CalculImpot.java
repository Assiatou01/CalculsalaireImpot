package com.esmt.impot;

public class CalculImpot {

    public static double calculerParts(boolean marie, int nbEnfants) {
        double parts = marie ? 2.0 : 1.5;
        parts += nbEnfants * 0.5;
        return Math.min(parts, 5.0);
    }

    public static double calculerAbattement(double salaireBrut) {
        double abattement = salaireBrut * 0.30;
        return Math.min(abattement, 300000);
    }

    public static double calculerImpot(double salaireBrut, boolean marie, int nbEnfants) {
        double parts = calculerParts(marie, nbEnfants);
        double abattement = calculerAbattement(salaireBrut);
        double revenuImposable = salaireBrut - abattement;
        return revenuImposable / parts;
    }

    public static double calculerSalaireNet(double salaireBrut, boolean marie, int nbEnfants) {
        if (salaireBrut < 60000 || salaireBrut > 3000000) {
            throw new IllegalArgumentException("Salaire invalide");
        }
        double impot = calculerImpot(salaireBrut, marie, nbEnfants);
        return salaireBrut - impot;
    }
}