package fr.hetic;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectorTest {
    public static void main(String[] args) {
        try {
            Connection connection = DatabaseConnector.getConnection();
            if (connection != null) {
                System.out.println("Connexion à la base de données établie avec succès.");
                DatabaseConnector.closeConnection(connection);
                System.out.println("Connexion à la base de données fermée avec succès.");
            } else {
                System.out.println("La connexion à la base de données a échoué.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
        }
    }
}
