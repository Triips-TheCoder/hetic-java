package fr.hetic;

import fr.hetic.DatabaseConnector;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseFileProcessor {
    public static void processFilesFromDatabase() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnector.getConnection();

            String sql = "SELECT * FROM FICHIER WHERE TYPE = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "OP");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int fileId = resultSet.getInt("ID");
                String fileName = resultSet.getString("NOM");

                // Générer le nom du fichier par convention
                String filePath = generateFilePath(fileName);

                // Écrire les données dans le fichier
                writeDataToFile(filePath, fileId);
            }
            System.out.println("Traitement des fichiers terminé avec succès.");
        } catch (SQLException | IOException e) {
            System.out.println("Erreur lors du traitement des fichiers depuis la base de données : " + e.getMessage());
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                DatabaseConnector.closeConnection(connection);
            }
        }
    }

    private static String generateFilePath(String fileName) {
        return "../../database-output" + fileName + ".txt";
    }

    private static void writeDataToFile(String filePath, int fileId) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Données du fichier avec ID : " + fileId);
            System.out.println("Données écrites dans le fichier : " + filePath);
        }
    }
}
