package JDCB;

import java.sql.*;

public class ScrollRowSet {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String name = "root";
        String password = "root";
        String connectionURL = "jdbc:mysql://localhost:3306/lessons?useSSL=false";
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL, name, password);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("drop table Books");
            statement.executeUpdate("create table Books (id mediumint auto_increment primary key not null , name varchar(30) not null, date TIMESTAMP );");
            statement.executeUpdate("insert into Books(name) values ('Perecrestok sumerek')");
            statement.executeUpdate("insert into Books(name) values ('Nozh snovideniy')");
            statement.executeUpdate("insert into Books(name, date) values ('Oko Mira', NOW())");
            statement.executeUpdate("insert into Books(name) values ('Velikaya Ohota')");
            statement.executeUpdate("insert into Books(name) values ('Ogni Nebes')");

            Statement stat = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            PreparedStatement preparedStatement = connection.prepareStatement("sql", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = stat.executeQuery("select * from Books");
            if (resultSet.next()) System.out.println(resultSet.getString("name"));
            if (resultSet.next()) System.out.println(resultSet.getString("name"));
            if (resultSet.next()) System.out.println(resultSet.getString("name"));


            if (resultSet.previous()) System.out.println(resultSet.getString("name"));
            if (resultSet.previous()) System.out.println(resultSet.getString("name"));

            if (resultSet.relative(2)) System.out.println(resultSet.getString("name"));
            if (resultSet.relative(-2)) System.out.println(resultSet.getString("name"));

            if (resultSet.absolute(2)) System.out.println(resultSet.getString("name"));

            if (resultSet.first()) System.out.println(resultSet.getString("name"));
            if (resultSet.last()) System.out.println(resultSet.getString("name"));


        }
    }
}
