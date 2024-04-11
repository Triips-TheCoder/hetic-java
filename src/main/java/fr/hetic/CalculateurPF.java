import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class Calculateur {
    private static final Map<String, BinaryOperator<Double>> OPERATEURS = new HashMap<>();

    static {
        OPERATEURS.put("+", (a, b) -> a + b);
        OPERATEURS.put("-", (a, b) -> a - b);
        OPERATEURS.put("*", (a, b) -> a * b);
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java Calculateur <numérique> <numérique> <opérateur>");
            return;
        }

        try {
            double num1 = Double.parseDouble(args[0]);
            double num2 = Double.parseDouble(args[1]);
            String operateur = args[2];

            if (!OPERATEURS.containsKey(operateur)) {
                throw new IllegalArgumentException("Opérateur non valide : " + operateur);
            }

            BinaryOperator<Double> operation = OPERATEURS.get(operateur);
            double resultat = operation.apply(num1, num2);
            System.out.println("Résultat : " + resultat);
        } catch (NumberFormatException e) {
            System.out.println("Les deux premiers arguments doivent être des nombres.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
