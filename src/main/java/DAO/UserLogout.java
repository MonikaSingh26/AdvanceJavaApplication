package DAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;


@WebServlet("/userLogout")
    public class UserLogout extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("login.jsp");
        }
    }
