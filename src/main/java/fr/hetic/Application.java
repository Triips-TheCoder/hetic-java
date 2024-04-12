package fr.hetic;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Application {
    public static void main(String[] args) {
        Properties properties = loadPropertiesFile("application.properties");

        String implementationType = properties.getProperty("implementation");

        if ("FILE".equals(implementationType)) {
            try (FileReader fileReader = new FileReader()) {
                fileReader.readFiles();
            } catch (IOException e) {
                System.err.println("Erreur lors de la lecture des fichiers : " + e.getMessage());
            }
        } else if ("JDBC".equals(implementationType)) {
            DatabaseFileProcessor.processFilesFromDatabase();
        } else {
            System.err.println("Type d'implémentation non reconnu : " + implementationType);
        }
    }

    private static Properties loadPropertiesFile(String filename) {
        Properties properties = new Properties();
        try (InputStream inputStream = Application.class.getClassLoader().getResourceAsStream(filename)) {
            properties.load(inputStream);
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement du fichier " + filename + ": " + e.getMessage());
        }
        return properties;
    }
}

