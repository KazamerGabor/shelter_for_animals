package hu.progmasters.database.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DogShelterRepository implements AutoCloseable {

    Connection connection;

    public DogShelterRepository() {
        try {
            connection = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void initAllTables() {
        initDogCoatTable();
        initDogHealthTable();
        initDogTable();
        initAddressTable();
        initOwnerTable();
        initWorkerTable();
    }

    public void initDogTable() {
        String sql = "CREATE TABLE IF NOT EXISTS dog (" +
                "dog_id INT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(255) NOT NULL," +
                "breed VARCHAR(255) NOT NULL," +
                "date_of_birth DATE NOT NULL," +
                "sex VARCHAR(6) NOT NULL," +
                "weight INT NOT NULL," +
                "status VARCHAR(20) NOT NULL," +
                "coat_color VARCHAR(20) NOT NULL," +
                "coat_length VARCHAR(20) NOT NULL," +
                "shedding VARCHAR(20) NOT NULL," +
                "vaccinated VARCHAR(20) NOT NULL," +
                "dewormed VARCHAR(20) NOT NULL," +
                "health_status VARCHAR(20) NOT NULL," +
                "dog_coat_id INT, " +
                "dog_health_id INT, " +
                "FOREIGN KEY (dog_coat_id) REFERENCES dog_coat(dog_coat_id), " +
                "FOREIGN KEY (dog_health_id) REFERENCES dog_health(dog_health_id));";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void initDogCoatTable() {
        String sql = "CREATE TABLE IF NOT EXISTS dog_coat (" +
                "dog_coat_id INT PRIMARY KEY AUTO_INCREMENT, " +
                "coat_length VARCHAR(10) NOT NULL, " +
                "coat_color VARCHAR(10) NOT NULL, " +
                "shedding VARCHAR(10) NOT NULL);";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void initDogHealthTable() {
        String sql = "CREATE TABLE IF NOT EXISTS dog_health (" +
                "dog_health_id INT PRIMARY KEY AUTO_INCREMENT, " +
                "vaccinated VARCHAR(10) NOT NULL, " +
                "dewormed VARCHAR(10) NOT NULL, " +
                "health_status VARCHAR(10) NOT NULL);";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void initOwnerTable() {
        String sql = "CREATE TABLE IF NOT EXISTS owner (" +
                "owner_id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(255) NOT NULL, " +
                "phoneNumber VARCHAR(25) NOT NULL, " +
                "address_id INT, " +
                "FOREIGN KEY (address_id) REFERENCES address(address_id));";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void initWorkerTable() {
        String sql = "CREATE TABLE IF NOT EXISTS worker (" +
                "worker_id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(255) NOT NULL, " +
                "phoneNumber VARCHAR(25) NOT NULL, " +
                "address_id INT, " +
                "FOREIGN KEY (address_id) REFERENCES address(address_id));";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void initAddressTable() {
        String sql = "CREATE TABLE IF NOT EXISTS address (" +
                "address_id INT PRIMARY KEY AUTO_INCREMENT, " +
                "postal_code INT NOT NULL, " +
                "city VARCHAR(20) NOT NULL, " +
                "street VARCHAR(100) NOT NULL, " +
                "number VARCHAR(10) NOT NULL);";

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }

}
