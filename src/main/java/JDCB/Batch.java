package JDCB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Batch {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String name = "root";
        String password = "root";
        String connectionURL = "jdbc:mysql://localhost:3306/lessons?useSSL=false";
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectionURL, name, password);
            Statement statement = connection.createStatement()){

            connection.setAutoCommit(false);

            statement.addBatch("drop table Books");
            statement.addBatch("create table Books (id mediumint auto_increment primary key not null , name varchar(30) not null, date TIMESTAMP );");
            statement.addBatch("insert into Books(name) values ('Perecrestok sumerek')");
            statement.addBatch("insert into Books(name) values ('Nozh snovideniy')");
            statement.addBatch("insert into Books(name, date) values ('Oko Mira', NOW())");
            statement.addBatch("insert into Books(name) values ('Velikaya Ohota')");
            statement.addBatch("insert into Books(name) values ('Ogni Nebes')");



            if (statement.executeBatch().length == 7){
                connection.commit();
            }else {
                connection.rollback();
            }



        }
    }

}
