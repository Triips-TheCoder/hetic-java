package fr.hetic;

public class Calculateur {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java Calculateur <numérique> <numérique> <opérateur>");
            return;
        }

        try {
            double num1 = Double.parseDouble(args[0]);
            double num2 = Double.parseDouble(args[1]);
            String operateur = args[2];

            double resultat = calculer(num1, num2, operateur);
            System.out.println("Résultat : " + resultat);
        } catch (NumberFormatException e) {
            System.out.println("Les deux premiers arguments doivent être des nombres.");
        }
    }

    public static double calculer(double num1, double num2, String operateur) {
        switch (operateur) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            default:
                throw new IllegalArgumentException("Opérateur non valide : " + operateur);
        }
    }
}


