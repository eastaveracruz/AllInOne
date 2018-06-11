package controllers;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet ("/context")
public class Context extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        в любом месте можно достать
        req.getServletContext().setAttribute("one", "1");

        resp.getWriter().write(String.valueOf(req.getServletContext().getAttribute("one")));


        ServletContext servletContext = getServletContext();

//        получить контекст другого приложения
        servletContext.getContext("/url");

        Enumeration<String> attributeNames = servletContext.getAttributeNames();
        while (attributeNames.hasMoreElements()){
            String s = attributeNames.nextElement();
            resp.getWriter().write(s + " - " + servletContext.getAttribute(s));
        }

    }
}
