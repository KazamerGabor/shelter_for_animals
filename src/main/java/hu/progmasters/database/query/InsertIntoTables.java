package hu.progmasters.database.query;

import hu.progmasters.animals.Dog;
import hu.progmasters.animals.DogCoat;
import hu.progmasters.animals.DogHealth;
import hu.progmasters.database.config.DatabaseConfig;
import hu.progmasters.enums.*;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InsertIntoTables implements AutoCloseable {

    Connection connection;
    ReadTexts readTexts;


    public InsertIntoTables() {
        try {
            connection = DriverManager.getConnection
                    (DatabaseConfig.DB_URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertIntoDog() {

        String sql = "INSERT INTO dog (name, breed, date_of_birth, sex, weight, status, coat_color, coat_length," +
                " shedding, vaccinated, dewormed, health_status)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, readTexts.dogList.get(0).getName());
            preparedStatement.setString(2, readTexts.dogList.get(0).getBreed());
            preparedStatement.setString(3, readTexts.dogList.get(0).getDateOfBirth());
            preparedStatement.setString(4, String.valueOf(readTexts.dogList.get(0).getSex()));
            preparedStatement.setInt(5, readTexts.dogList.get(0).getWeight());
            preparedStatement.setString(6, String.valueOf(readTexts.dogList.get(0).getStatus()));
            preparedStatement.setString(7, String.valueOf(readTexts.dogList.get(0).getDogCoat().getCoatColor()));
            preparedStatement.setString(8, String.valueOf(readTexts.dogList.get(0).getDogCoat().getCoatLength()));
            preparedStatement.setString(9, String.valueOf(readTexts.dogList.get(0).getDogCoat().getShedding()));
            preparedStatement.setBoolean(10, readTexts.dogList.get(0).getDogHealth().isVaccinated());
            preparedStatement.setBoolean(11, readTexts.dogList.get(0).getDogHealth().isDewormed());
            preparedStatement.setString(12, String.valueOf(readTexts.dogList.get(0).getDogHealth().getHealthStatus()));

            System.out.println(preparedStatement.executeUpdate());

        } catch (SQLException e) {
            e.printStackTrace();
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
