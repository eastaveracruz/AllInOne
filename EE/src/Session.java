import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


@WebServlet ("/session")
public class Session extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Enumeration<String> attributeNames = session.getAttributeNames();
        PrintWriter writer = resp.getWriter();
        while (attributeNames.hasMoreElements()){
            String nextElement = attributeNames.nextElement();
            writer.write(nextElement + " - " + session.getAttribute(nextElement));
        }

        session.setAttribute("atribute one" , "value atribut one");
        System.out.println(session.getMaxInactiveInterval());

    }
}
