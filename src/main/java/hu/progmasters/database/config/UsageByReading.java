package hu.progmasters.database.config;

import hu.progmasters.humans.Address;

import javax.naming.InsufficientResourcesException;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsageByReading implements AutoCloseable {
    Connection connection;
    BufferedReader bufferedReader;
    Path path = Path.of("src/main/resources/dog.txt");
    List<Address> addresses = new ArrayList<>();

    public UsageByReading() {
        try {
            connection = DriverManager.getConnection
                    (DatabaseConfig.DB_URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    {
        try {
            bufferedReader = Files.newBufferedReader(path);
            String line;
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] lines = line.split(" ");
                String city=lines[0];
                int postalCode= Integer.valueOf(lines[1]);
                String street=lines[2];
                int number=Integer.valueOf(lines[3]);

                addresses.add(new Address(city, postalCode, street, number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
