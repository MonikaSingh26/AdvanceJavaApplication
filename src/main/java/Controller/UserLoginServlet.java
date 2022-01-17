package Controller;

import DAO.UserLoginDao;
import Model.UserLoginBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

    @WebServlet("/login")
    public class UserLoginServlet extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String userLoginId = request.getParameter("userLoginId");
            String password = request.getParameter("password");

            UserLoginBean userLoginBean = new UserLoginBean(userLoginId, password);
            Boolean authenticateUser = UserLoginDao.authenticateUserLogin(userLoginBean);

            if (authenticateUser.equals(true)) {
                HttpSession httpSession = request.getSession(true);
                httpSession.setAttribute("userLoginId", userLoginBean.getUserLoginId());
                httpSession.setAttribute("password", userLoginBean.getPassword());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("profile.jsp");
                requestDispatcher.forward(request, response);
            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
                request.setAttribute("Message", "Invalid Login ID and Password");
                requestDispatcher.forward(request, response);
            }
        }
    }
