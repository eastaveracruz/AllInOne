package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;


//Сервлеты не потокобезопасны (вроде)
//у меня все нормально считает без синхронизации так что хз
@WebServlet ("/Thread")
public class ThreadServlet extends HttpServlet {
    int i = 0;
    @Override
    public void init() throws ServletException {
        ThreadServlet.addURL();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (int j = 0; j < 1_000_000; j++) {
            i++;
        }
        System.out.println(i);
        System.out.println(Thread.currentThread().getName());
    }

//    main не запускается,
    public static void addURL() {
        for (int i = 0; i < 200; i++) {
            new Thread(){
                @Override
                public void run() {
                    try {
                        URLConnection urlConnection = new URL("http://localhost:8080/Thread").openConnection();
                        urlConnection.getInputStream();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
