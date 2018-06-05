import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet ("/header")
public class Header extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> headerName = req.getHeaderNames();
        while (headerName.hasMoreElements()){
            String name = headerName.nextElement();
            resp.getWriter().write("<p>" + name + " - " + req.getHeader(name) + "</p>");
        }
        resp.getWriter().write("<p>" +  req.getProtocol() + "</p>");
    }
}
