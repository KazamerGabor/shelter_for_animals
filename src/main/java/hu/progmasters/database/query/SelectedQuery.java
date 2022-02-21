package hu.progmasters.database.query;

import hu.progmasters.animals.Dog;
import hu.progmasters.database.config.DatabaseConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static hu.progmasters.database.query.Domain.selectedDog;
import static jdk.nashorn.internal.objects.NativeDate.getDate;

public class SelectedQuery {
    Connection connection;

    public SelectedQuery() {
        try {
            connection = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Dog> selectedQuery() {
        List<Dog> dogs = new ArrayList<>();
        String[] lines = selectedDog.split(" ");
        String sql;
        int a = 0;
        int b = 0;
        if (lines[2].equals("kicsi")){
            b = 6;
        sql = "SELECT * FROM dog_shelter AS ds WHERE breed = ? AND sex = ? AND weight < ?;";
        }
        else if (lines[2].equals("nagy")){
            a = 15;
        sql = "SELECT * FROM dog_shelter AS ds WHERE breed = ? AND sex = ? AND weight > ?;";
        }
        else {
        sql = "SELECT * FROM dog_shelter AS ds WHERE breed = ? AND sex = ?;";
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(3, lines[0]);
            preparedStatement.setString(5, lines[1]);
            preparedStatement.setInt(6, a);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                dogs.add(new Dog(
                        resultSet.getInt("dog_id"),
                        resultSet.getString("name"),
                        resultSet.getString("breed"),
                        resultSet.getString((date_of_birth)),
                        resultSet.getString("sex"),
                        resultSet.getInt("weight"),
                        resultSet.getString("status"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



        return dogs;
    }


}





