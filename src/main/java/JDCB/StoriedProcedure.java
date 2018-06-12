package JDCB;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;

import java.sql.*;

public class StoriedProcedure {
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

            CallableStatement callableStatement = connection.prepareCall("{call BookCount(?)}");
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.execute();
            System.out.println(callableStatement.getInt(1));


//            create procedure BookCount (out o int)
//            begin
//            select count(*) into o from Books;
//            end;

            System.out.println("************************");

            CallableStatement callableStatement1 = connection.prepareCall("{call GetBooks(?)}");
            callableStatement1.setInt(1, 4);
            if (callableStatement1.execute()) {
                ResultSet resultSet = callableStatement1.getResultSet();
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("id"));
                    System.out.println(resultSet.getString("name"));
                }
            }

//            create procedure GetBooks (bookId int)
//            begin
//            select * from Books where id= bookId;
//            end;
            System.out.println("**********************");

            statement.executeUpdate("drop table Users");
            statement.executeUpdate("create table Users (id mediumint auto_increment primary key not null , name varchar(30) not null, date TIMESTAMP );");
            statement.executeUpdate("insert into Users(name) values ('coy')");
            statement.executeUpdate("insert into Users(name) values ('hoy')");
            statement.executeUpdate("insert into Users(name) values ('gorhok')");

            CallableStatement callableStatement2 = connection.prepareCall("{call CountTable()}");

            boolean hasResult = callableStatement2.execute();
            while (hasResult) {
                ResultSet resultSet = callableStatement2.getResultSet();
                while (resultSet.next()){
                    System.out.println(resultSet.getInt(1));
                }
                hasResult = callableStatement2.getMoreResults();
            }

//            create procedure CountTable ()
//            begin
//            select count(*) from Books;
//            select count(*) from Users;
//            end;

        }
    }

}
