package controllers;

import jsp.MyModel;
import jsp.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/econtroller")
public class ExpressionController extends HttpServlet {

    MyModel myModel = new MyModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = myModel.getStudent();

        req.setAttribute("stud", student);

        List list = new ArrayList();
        list.add("a");
        list.add("b");
        req.setAttribute("list", list);

        Map map = new HashMap();
        map.put("one", "1");
        map.put("two", "2");
        req.setAttribute("map", map);


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/EView.jsp");
        requestDispatcher.forward(req, resp);
    }
}
