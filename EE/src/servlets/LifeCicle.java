package servlets;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Жизненный цикл сервлета

@WebServlet ("/servlets.LifeCicle")
public class LifeCicle extends HttpServlet {

    // Метод вызывается каждый раз при инициализации.
    @Override
    public void init() throws ServletException {
        System.out.println("This is initialization.");
    }

    // Обработка Get запросов.
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

    // Делаем чтобы Post запросы обрабатывались в методе doGet.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    // Все запросы обрабатываются этим методом, после обработки метод передает запрос методам doGetn, doPost и т.д.
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Service method.");
        super.service(req, res);
    }
    // Медот запускается вконце работы сервлета, служит для закрытия баз и т.д. (не желатльно полагаться)
    @Override
    public void destroy() {
        System.out.println("Destroy method.");
    }
}
