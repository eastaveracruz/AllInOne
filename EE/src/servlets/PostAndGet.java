package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;


@WebServlet("/hello")
public class PostAndGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String s = req.getParameter("next"); // получаем параметр
//        System.out.println(s);
//        String[] d = req.getParameterValues("first"); // получаем массив параметров
//        for (String m : d) System.out.println(m);
//
//        Enumeration<String> enumeration = req.getParameterNames(); // получаем имена параметров
//
//        while (enumeration.hasMoreElements()) {
//            String elementName = enumeration.nextElement();
//            System.out.println(elementName + " = " + req.getParameter(elementName));
//        }
//
//        Map<String, String[]> parameterMap = req.getParameterMap(); // получаем параметры ключ - массив занчений
//
//        // куча получаемой инфы
//        req.setCharacterEncoding("UTF-8");
//        System.out.println(req.getQueryString());
//        System.out.println(req.getRequestURI());
//        System.out.println(req.getRequestURL());
//        System.out.println(req.getServletPath());
//        System.out.println(req.getRemoteHost());
        String one = req.getParameter("one");
        String two = req.getParameter("two");

        resp.getWriter().write("<html>" +
                "<header><title>This is title</title></header>" +
                "<body>" +
                "one = " + one + "<br>" +
                "two = " + two +
                "<form method='post' action='hello'>" +
                "<input type='text' name='one'/>" +
                "<input type='text' name='two'/>" +
                "<input type='submit' value='submit'/>" +
                "</form>" +
                "</body>" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
