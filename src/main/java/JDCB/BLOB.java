package JDCB;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

public class BLOB {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        String name = "root";
        String password = "root";
        String connectionURL = "jdbc:mysql://localhost:3306/lessons?useSSL=false";
        Class.forName("com.mysql.jdbc.Driver");

        try(Connection connection = DriverManager.getConnection(connectionURL, name, password);
        Statement stat = connection.createStatement()){

            stat.executeUpdate("drop table Books");
            stat.executeUpdate("create table Books (id mediumint auto_increment primary key not null , name varchar(30) not null, img MEDIUMBLOB);");

            BufferedImage bufferedImage = ImageIO.read(new File("367.jpg"));
            Blob blob = connection.createBlob();
            try(OutputStream outputStream = blob.setBinaryStream(1)){
                ImageIO.write(bufferedImage, "jpg", outputStream);
            }

            PreparedStatement statement = connection.prepareStatement("insert into Books (name, img) values (?,?)");
            statement.setString(1, "Perecrestki Sumerek");
            statement.setBlob(2, blob);
            statement.execute();


            ResultSet resultSet = stat.executeQuery("select * from Books where name = 'Perecrestki Sumerek'");
            while (resultSet.next()){
                Blob blob1 = resultSet.getBlob("img");
                BufferedImage bufferedImage1 = ImageIO.read(blob1.getBinaryStream());
                File outPutImg = new File("img.png");
                ImageIO.write(bufferedImage1, "png", outPutImg);
            }

        }
    }


}
