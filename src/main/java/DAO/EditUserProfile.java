package DAO;

import Connectivity.DatabaseConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/editUserProfile")
    public class EditUserProfile extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();

        Connection connection = null;

        try {
            connection = DatabaseConnection.getConnection(); // Fetch Database connection object

            String partyId = (String) httpSession.getAttribute("partyId");
            PreparedStatement statement = connection.prepareStatement("UPDATE party SET firstName = ?, lastName = ?, " +
                    "address = ?, city = ?, zip = ?, state = ?, " +
                    "country = ? WHERE partyId =" +partyId);

            statement.setString(1, request.getParameter("firstName"));
            System.out.println("First Name "+request.getParameter("firstName"));

            statement.setString(2, request.getParameter("lastName"));
            System.out.println("Last Name "+request.getParameter("lastName"));

            statement.setString(3, request.getParameter("address"));
            System.out.println("Address "+request.getParameter("address"));

            statement.setString(4, request.getParameter("city"));
            System.out.println("City "+request.getParameter("city"));

            statement.setInt(5, Integer.parseInt(request.getParameter("zip")));
            System.out.println("Zip "+request.getParameter("zip"));

            statement.setString(6, request.getParameter("state"));
            System.out.println("State "+request.getParameter("state"));

            statement.setString(7, request.getParameter("country"));
            System.out.println("Country"+request.getParameter("country"));

            statement.executeUpdate();
            connection.close();

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/profile.jsp");
            requestDispatcher.include(request, response);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}

