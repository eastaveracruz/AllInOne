import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/this")
public class Servlet_two extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("This is _GET");
        String s = "<html>" +
                "<header><title>This is Servlet!!!</title></header>" +
                "<body>"+
                "<h1>Hello dude!</h1>" +
                "</body>";
        resp.getWriter().write(s);
    }

}
