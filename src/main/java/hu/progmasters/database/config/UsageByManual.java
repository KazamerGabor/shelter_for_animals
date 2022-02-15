//package hu.progmasters.database.config;
//
//import java.sql.*;
//
//public class UsageByManual implements AutoCloseable {
//    Connection connection;
//
//    public UsageByManual() {
//        try {
//            connection = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void initAddressTable() {
//        String sql = "CREATE TABLE IF NOT EXISTS address (" +
//                "address_id INT PRIMARY KEY AUTO_INCREMENT, " +
//                "name VARCHAR(100) NOT NULL, " +
//                "phone VARCHAR(100) NOT NULL, " +
//                "city VARCHAR(20) NOT NULL, " +
//                "post_code INT NOT NULL, " +
//                "street VARCHAR(100) NOT NULL, " +
//                "number INT NOT NULL);";
//
//        try (Statement statement = connection.createStatement()) {
//            statement.execute(sql);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//        public void initAddressFromFile(){
//            String sql = "INSERT INTO address (name, phone, city, post_code, street, number)" +
//                    "VALUES (?, ?, ?, ?, ?, ?)";
//
//            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//                preparedStatement.setString(1, "Kazamér Gábor");
//                preparedStatement.setString(2, "06209123456");
//                preparedStatement.setString(3, "Budapest");
//                preparedStatement.setInt(4, 1037);
//                preparedStatement.setString(5, "Szőlővész");
//                preparedStatement.setInt(6, 11);
//
//                preparedStatement.executeUpdate();
//
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//
//
//    @Override
//    public void close() throws Exception {
//        connection.close();
//    }
//}
