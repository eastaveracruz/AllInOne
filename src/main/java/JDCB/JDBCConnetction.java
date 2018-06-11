package JDCB;

import java.sql.*;

public class JDBCConnetction {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String name = "root";
        String password = "root";
        String connectionURL = "jdbc:mysql://localhost:3306/lessons?useSSL=false";
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectionURL, name, password);
            Statement statement = connection.createStatement()){

            statement.executeUpdate("drop table Books");
            statement.executeUpdate("create table Books (id mediumint auto_increment primary key not null , name varchar(30) not null);");
            statement.executeUpdate("insert into Books(name) values ('Perecrestok sumerek')");
            statement.executeUpdate("insert into Books(name) values ('Nozh snovideniy')");
            statement.executeUpdate("insert into Books set name = 'Oko Mira'");

            ResultSet resultSet = statement.executeQuery("select * from Books where id > 1" );
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));
                System.out.println("----------------------");
            }

            System.out.println("------------------------------------------------sql inqections");

            String id = "1 or 1 = 1";
            ResultSet resultSet1 = statement.executeQuery("select name from Books where id = " + id );
            while (resultSet1.next()){
                System.out.println(resultSet1.getString(1));
                System.out.println("------------------");
            }

            System.out.println("------------------------------------------------ kill sql inqections ");

            PreparedStatement preparedStatement = connection.prepareStatement("select name from Books where id = ?");
            preparedStatement.setString(1, id);
            ResultSet resultSet2 = preparedStatement.executeQuery();
            while (resultSet2.next()){
                System.out.println(resultSet2.getString(1));
                System.out.println("------------------");
            }
        }
    }
}
