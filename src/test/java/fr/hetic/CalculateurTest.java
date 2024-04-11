package fr.hetic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculateurTest {

    @Test
    public void testCalculerAddition() {
        double num1 = 5;
        double num2 = 3;
        String operateur = "+";
        double expectedResult = 8;

        double resultat = Calculateur.calculer(num1, num2, operateur);

        assertEquals(expectedResult, resultat);
    }

    @Test
    public void testCalculerSoustraction() {
        double num1 = 5;
        double num2 = 3;
        String operateur = "-";
        double expectedResult = 2;

        double resultat = Calculateur.calculer(num1, num2, operateur);

        assertEquals(expectedResult, resultat);
    }

    @Test
    public void testCalculerMultiplication() {
        double num1 = 5;
        double num2 = 3;
        String operateur = "*";
        double expectedResult = 15;

        double resultat = Calculateur.calculer(num1, num2, operateur);

        assertEquals(expectedResult, resultat);
    }

    @Test
    public void testCalculerOperateurInvalide() {
        double num1 = 5;
        double num2 = 3;
        String operateur = "/";

        assertThrows(IllegalArgumentException.class, () -> {
            Calculateur.calculer(num1, num2, operateur);
        });
    }
}
