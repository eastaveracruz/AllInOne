package JAVA_EE;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/* Экстендимся от HttpServlets (apache-tomcat-9.0.8\lib\servlet-api.jar)
 * Оверайдим doGet
  *Создаем в томкате в каталоги webapps свой "сайт"
  *Подкаталог WEB-INF, в нем файл web.xml и каталог classes (хранилище скомпилированных классов)
  *Компилируем класс, ложим в classes (в командной строке заходим в каталог classes, в котором лежит Servlets.java
  *     в командной строке набираем javac -cp e:\media\java\apache-tomcat-9.0.8\lib\servlet-api.jar Servlets.java)
  *Редактируем web.xml
  *     <?xml version="1.0" encoding="UTF-8"?>

            <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
                version="3.0"
                metadata-complete="true">

                <display-name>Hello World</display-name>
                <description>Some Comments</description>

                <servlet>
                    <servlet-name>MyServlet</servlet-name>      Обзываем сервелт
                    <servlet-class>Servlets</servlet-class>     Указываем имя скомпилированного класса
                </servlet>

                <servlet-mapping>
                    <servlet-name>MyServlet</servlet-name>      Указываем на сервелет
                    <url-pattern>/hello</url-pattern>           Задаем путь в адресной строке браузера по которой он будет вызываться
                </servlet-mapping>

            </web-app>


    Создание war архива
        в папке, содержимое которое будет архивироваться набираем команду
            jar -cfv <Имя архива>.war *
        Ложим архив в webapps
        Томкат при запуске распакует его и положит в папку с именем архива
  * */
public class Servlets extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("Hello World");
    }
}
