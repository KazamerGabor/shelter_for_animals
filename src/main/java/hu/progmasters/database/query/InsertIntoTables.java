package hu.progmasters.database.query;

import hu.progmasters.animals.Dog;
import hu.progmasters.animals.DogCoat;
import hu.progmasters.animals.DogHealth;
import hu.progmasters.database.config.DatabaseConfig;
import hu.progmasters.enums.*;
import hu.progmasters.humans.Address;
import hu.progmasters.humans.Worker;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InsertIntoTables implements AutoCloseable {

    Connection connection;
    List<Dog> dogList = new ArrayList<>();
    List<Worker> workerList = new ArrayList<>();


    public InsertIntoTables() {
        try {
            connection = DriverManager.getConnection
                    (DatabaseConfig.DB_URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void readDogText() {
        Path path = Path.of("src/main/resources/dog.txt");
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String line;
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] lines = line.split(";");
                String name = lines[0];
                String breed = lines[1];
                String dateOfBirth = lines[2];
                Sex sex = Sex.valueOf(lines[3].toUpperCase());
                int weight = Integer.valueOf(lines[4]);
                Status status = Status.valueOf(lines[5].toUpperCase());
                DogCoat dogCoat = new DogCoat(CoatColor.valueOf(lines[6].toUpperCase()),
                        CoatLength.valueOf(lines[7].toUpperCase()), Shedding.valueOf(lines[8].toUpperCase()));
                DogHealth dogHealth = new DogHealth(Boolean.valueOf(lines[9]), Boolean.valueOf(lines[10]),
                        HealthStatus.valueOf(lines[11].toUpperCase()));

                dogList.add(new Dog(name, breed, dateOfBirth, sex, weight, status, dogCoat, dogHealth));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readWorkerText() {
        Path path = Path.of("src/main/resources/worker.txt");
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String line;
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] lines = line.split(";");
                String name = lines[0];
                String phoneNumber = lines[1];
                String city = lines[2];
                int postalCode = Integer.parseInt(lines[3]);
                String street = lines[4];
                String number = lines[5];

                workerList.add(new Worker(name, phoneNumber, new Address(city, postalCode, street, number)));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insertIntoDog() {

        String sql = "INSERT INTO dog (name, breed, date_of_birth, sex, weight, status, coat_color, coat_length," +
                " shedding, vaccinated, dewormed, health_status, dog_coat_id, dog_health_id)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        for (Dog dog : dogList) {

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, dog.getName());
                preparedStatement.setString(2, dog.getBreed());
                preparedStatement.setString(3, dog.getDateOfBirth());
                preparedStatement.setString(4, String.valueOf(dog.getSex()));
                preparedStatement.setInt(5, dog.getWeight());
                preparedStatement.setString(6, String.valueOf(dog.getStatus()));
                preparedStatement.setString(7, String.valueOf(dog.getDogCoat().getCoatColor()));
                preparedStatement.setString(8, String.valueOf(dog.getDogCoat().getCoatLength()));
                preparedStatement.setString(9, String.valueOf(dog.getDogCoat().getShedding()));
                preparedStatement.setBoolean(10, dog.getDogHealth().isVaccinated());
                preparedStatement.setBoolean(11, dog.getDogHealth().isDewormed());
                preparedStatement.setString(12, String.valueOf(dog.getDogHealth().getHealthStatus()));
                preparedStatement.setInt(13, dog.getDogCoat().getDogCoatId());
                preparedStatement.setInt(14, dog.getDogHealth().getDogHealthId());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void insertIntoAddress() {

        String sql = "INSERT INTO address (postal_code, city, street, number) VALUES (?, ?, ?, ?);";
        for (Worker worker : workerList) {

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setInt(1, worker.getAddress().getPostalCode());
                preparedStatement.setString(2, worker.getAddress().getCity());
                preparedStatement.setString(3, worker.getAddress().getStreet());
                preparedStatement.setString(4, worker.getAddress().getNumber());

                preparedStatement.executeUpdate();

                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                int generatedKey = 0;
                if (resultSet.next()) {
                    generatedKey = resultSet.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void insertIntoDogCoat() {

        String sql = "INSERT INTO dog_coat (coat_length, coat_color, shedding) VALUES (?, ?, ?);";
        for (Dog dog : dogList) {

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, String.valueOf(dog.getDogCoat().getCoatLength()));
                preparedStatement.setString(2, String.valueOf(dog.getDogCoat().getCoatColor()));
                preparedStatement.setString(3, String.valueOf(dog.getDogCoat().getShedding()));

                preparedStatement.executeUpdate();

                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                int generatedKey = 0;
                if (resultSet.next()) {
                    generatedKey = resultSet.getInt(1);
                    dog.getDogCoat().setDogCoatId(generatedKey);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void insertIntoDogHealth() {

        String sql = "INSERT INTO dog_health (vaccinated, dewormed, health_status) VALUES (?, ?, ?);";
        for (Dog dog : dogList) {

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, String.valueOf(dog.getDogHealth().isVaccinated()));
                preparedStatement.setString(2, String.valueOf(dog.getDogHealth().isDewormed()));
                preparedStatement.setString(3, String.valueOf(dog.getDogHealth().getHealthStatus()));

                preparedStatement.executeUpdate();

                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                int generatedKey = 0;
                if (resultSet.next()) {
                    generatedKey = resultSet.getInt(1);
                    dog.getDogHealth().setDogHealthId(generatedKey);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


//    public void insertIntoVolunteer() {
//
//        String sql = "INSERT INTO volunteer (name, phoneNumber, address_id)" +
//                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            preparedStatement.setString(1, readTexts.dogList.get(0).getName());
//            preparedStatement.setString(2, readTexts.dogList.get(0).getBreed());
//            preparedStatement.setString(3, readTexts.dogList.get(0).getDateOfBirth());
//            preparedStatement.setString(4, String.valueOf(readTexts.dogList.get(0).getSex()));
//            preparedStatement.setInt(5, readTexts.dogList.get(0).getWeight());
//            preparedStatement.setString(6, String.valueOf(readTexts.dogList.get(0).getStatus()));
//            preparedStatement.setString(7, String.valueOf(readTexts.dogList.get(0).getDogCoat().getCoatColor()));
//            preparedStatement.setString(8, String.valueOf(readTexts.dogList.get(0).getDogCoat().getCoatLength()));
//            preparedStatement.setString(9, String.valueOf(readTexts.dogList.get(0).getDogCoat().getShedding()));
//            preparedStatement.setBoolean(10, readTexts.dogList.get(0).getDogHealth().isVaccinated());
//            preparedStatement.setBoolean(11, readTexts.dogList.get(0).getDogHealth().isDewormed());
//            preparedStatement.setString(12, String.valueOf(readTexts.dogList.get(0).getDogHealth().getHealthStatus()));
//
//            System.out.println(preparedStatement.executeUpdate());
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }
}
