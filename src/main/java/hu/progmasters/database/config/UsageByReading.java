package hu.progmasters.database.config;

import hu.progmasters.animals.Dog;
import hu.progmasters.animals.DogCoat;
import hu.progmasters.animals.DogHealth;
import hu.progmasters.enums.*;
import hu.progmasters.humans.Address;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsageByReading implements AutoCloseable {
    Connection connection;
    List<Address> addresses;
    List<Dog> dogs = new ArrayList<>();


    public UsageByReading() throws IOException {
        try {
            connection = DriverManager.getConnection
                    (DatabaseConfig.DB_URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void initDogTable() {
        String sql = "CREATE TABLE dog(id INT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(10) NOT NULL," +
                "breed VARCHAR(20) NOT NULL," +
                "date_of_birth DATE NOT NULL," +
                "sex VARCHAR(6) NOT NULL," +
                "weight INT NOT NULL," +
                "status VARCHAR(20) NOT NULL," +
                "coat_color VARCHAR(20) NOT NULL," +
                "coat_length VARCHAR(20) NOT NULL," +
                "shedding VARCHAR(20) NOT NULL," +
                "vaccinated VARCHAR(20) NOT NULL," +
                "dewormed VARCHAR(20) NOT NULL," +
                "health_status VARCHAR(20) NOT NULL);";

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void readingDogsFromFileAndIntoSQL() {
        Path path = Path.of("src/main/resources/dog.txt");
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String line;
//            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] lines = line.split(";");
                String name = lines[0];
                String breed= lines[1];
                String dateOfBirth = lines[2];
                Sex sex = Sex.valueOf(lines[3].toUpperCase());
                int weight = Integer.valueOf(lines[4]);
                Status status = Status.valueOf(lines[5].toUpperCase());
                DogCoat dogCoat = new DogCoat(CoatColor.valueOf(lines[6].toUpperCase()),
                        CoatLength.valueOf(lines[7].toUpperCase()), Shedding.valueOf(lines[8].toUpperCase()));
                DogHealth dogHealt = new DogHealth(Boolean.valueOf(lines[9]), Boolean.valueOf(lines[10]),
                        HealthStatus.valueOf(lines[11].toUpperCase()));

                dogs.add(new Dog(name, breed, dateOfBirth, sex, weight, status, dogCoat, dogHealt));
                System.out.println(dogs);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(dogs);
    }


    public void intoSQL() {

        String sql = "INSERT INTO dog (name, breed, date_of_birth, sex, weight, status, coat_color, coat_length," +
                " shedding, vaccinated, dewormed, health_status)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, dogs.get(0).getName());
            preparedStatement.setString(2, dogs.get(0).getBreed());
            preparedStatement.setString(3, dogs.get(0).getDateOfBirth());
            preparedStatement.setString(4, String.valueOf(dogs.get(0).getSex()));
            preparedStatement.setInt(5, dogs.get(0).getWeight());
            preparedStatement.setString(6, String.valueOf(dogs.get(0).getStatus()));
            preparedStatement.setString(7, String.valueOf(dogs.get(0).getDogCoat().getCoatColor()));
            preparedStatement.setString(8, String.valueOf(dogs.get(0).getDogCoat().getCoatLength()));
            preparedStatement.setString(9, String.valueOf(dogs.get(0).getDogCoat().getShedding()));
            preparedStatement.setBoolean(10, dogs.get(0).getDogHealth().isVaccinated());
            preparedStatement.setBoolean(11, dogs.get(0).getDogHealth().isDewormed());
            preparedStatement.setString(12, String.valueOf(dogs.get(0).getDogHealth().getHealthStatus()));


            System.out.println(preparedStatement.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void close() throws Exception {
        connection.close();
    }
}
