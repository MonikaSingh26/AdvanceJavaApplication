package Controller;

import DAO.PartyDao;
import Model.PartyBean;
import Model.UserLoginBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registration")
    public class PartyServlet extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            int zip = Integer.parseInt(request.getParameter("zip"));
            String state = request.getParameter("state");
            String country = request.getParameter("country");
            int phone = Integer.parseInt(request.getParameter("phone"));
            String userLoginId = request.getParameter("userLoginId");
            String password = request.getParameter("password");

            UserLoginBean userLoginBean = new UserLoginBean();
            PartyBean partyBean = new PartyBean();

            partyBean.setFirstName(firstName);
            partyBean.setLastName(lastName);
            partyBean.setAddress(address);
            partyBean.setCity(city);
            partyBean.setZip(zip);
            partyBean.setState(state);
            partyBean.setCountry(country);
            partyBean.setPhone(Integer.parseInt(String.valueOf(phone)));

            userLoginBean.setUserLoginId(userLoginId);
            userLoginBean.setPassword(password);

            boolean authenticateUser = false;
            try {
                authenticateUser = PartyDao.registerUser(partyBean, userLoginBean);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }

            RequestDispatcher requestDispatcher;
            HttpSession httpSession = null;
            if (authenticateUser) {
                requestDispatcher = request.getRequestDispatcher("profile.jsp");
                httpSession = request.getSession(true);
                httpSession.setAttribute("userLoginId", userLoginId);
                httpSession.setAttribute("password", password);
                httpSession.setAttribute("firstName", partyBean.getFirstName());
                httpSession.setAttribute("lastName", partyBean.getLastName());
                httpSession.setAttribute("address", partyBean.getAddress());
                httpSession.setAttribute("city", partyBean.getCity());
                httpSession.setAttribute("zip", zip);
                httpSession.setAttribute("state", partyBean.getState());
                httpSession.setAttribute("country", partyBean.getCountry());
                httpSession.setAttribute("phone", partyBean.getPhone());
                httpSession.setAttribute("message", "Successful");
                response.sendRedirect("login.jsp");
            } else {
                requestDispatcher = request.getRequestDispatcher("registration.jsp");
                request.setAttribute("AlreadyExist", "User Already Exists");
                requestDispatcher.forward(request, response);
            }
        }
    }
