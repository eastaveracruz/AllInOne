import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet ("/cookie")
public class Cookies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookie = req.getCookies();
        for (Cookie cookie1 : cookie) {
            System.out.println(cookie1.getName());
            System.out.println(cookie1.getValue());
            System.out.println(cookie1.getMaxAge());
        }
        Cookie cookie1 = new Cookie("one", "two");
//        cookie1.setMaxAge(5);   //удаляет куку через 5с
        cookie1.setPath("/cookie"); // только с этого домена можно получить куку
        cookie1.setSecure(true); // HTPS
        resp.addCookie(cookie1);
    }
}
