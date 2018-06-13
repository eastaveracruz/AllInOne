package JDCB;

import java.sql.*;

public class Transactionst {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String name = "root";
        String password = "root";
        String connectionURL = "jdbc:mysql://localhost:3306/lessons?useSSL=false";
        Class.forName("com.mysql.jdbc.Driver");
        
        Savepoint savepoint = null;
        Connection connection = null;
        try {
            
            connection = DriverManager.getConnection(connectionURL, name, password);
            Statement statement = connection.createStatement();

            connection.setAutoCommit(false);

            statement.executeUpdate("drop table Books");
            statement.executeUpdate("create table Books (id mediumint auto_increment primary key not null , name varchar(30) not null, date TIMESTAMP );");
            statement.executeUpdate("insert into Books(name) values ('Perecrestok sumerek')");
            statement.executeUpdate("insert into Books(name) values ('Nozh snovideniy')");

            savepoint = connection.setSavepoint();

            statement.executeUpdate("insert into Books(name, date) values ('Oko Mira', NOW())");
            statement.executeUpdate("insert into Books(name) values ('Velikaya Ohota')");
            statement.executeUpdate("insert into Books(name) values ('Ogni Nebes')");

            //            connection.rollback(); откад операций апдейта и инсерта

//            откад после сетпоинта
            connection.rollback(savepoint);
            connection.commit();
            connection.releaseSavepoint(savepoint);


        }catch (SQLException e){
            connection.rollback(savepoint);
            connection.commit();
        }
    }
}
