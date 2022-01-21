package DAO;

import Connectivity.DatabaseConnection;
import Model.PartyBean;
import Model.UserLoginBean;

import java.sql.*;

public class PartyDao {

        public static boolean registerUser(PartyBean partyBean, UserLoginBean userLoginBean) throws SQLException {

            String userLoginId = userLoginBean.getUserLoginId();
            String password = userLoginBean.getPassword();

            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;

            try {
                connection = DatabaseConnection.getConnection(); // Fetch Database connection object
                statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT userLoginId FROM userlogin");
                System.out.println(resultSet);

                boolean flag = true;
                while (resultSet.next()) {
                    if (resultSet.getString("userLoginId").equalsIgnoreCase(userLoginId))
                    {
                        flag = false;
                        return false;
                    }
                }
                if (flag) {
                    Statement statement1 = connection.createStatement();
                    ResultSet resultSet1 = statement1.executeQuery("SELECT MAX(partyId) as partyId FROM party");

                    int partyId = -1;
                    if (resultSet1 != null) {
                        while (resultSet1.next()) {
                            partyId = (resultSet1.getInt("partyId")) + 1;
                        }
                    }
                    statement.close(); //statement close

                    PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `application`.`party` " +
                            "(`partyId`, `firstName`, `lastName`, `address`, `city`, `zip`, `state`, `country`, `phone`) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
                    preparedStatement.setInt(1, partyId);
                    preparedStatement.setString(2, partyBean.getFirstName());
                    preparedStatement.setString(3, partyBean.getLastName());
                    preparedStatement.setString(4, partyBean.getAddress());
                    preparedStatement.setString(5, partyBean.getCity());
                    preparedStatement.setInt(6, partyBean.getZip());
                    preparedStatement.setString(7, partyBean.getState());
                    preparedStatement.setString(8, partyBean.getCountry());
                    preparedStatement.setInt(9, partyBean.getPhone());
                    preparedStatement.executeUpdate();
                    preparedStatement.close(); //preparedStatement close

                    PreparedStatement preparedStatement1 = connection.prepareStatement("INSERT INTO `application`.`userlogin` " +
                            "(`userLoginId`, `password`, `partyId`) " +
                            "VALUES (?, ?, ?)");
                    preparedStatement1.setString(1, userLoginId);
                    preparedStatement1.setString(2, password);
                    preparedStatement1.setInt(3, partyId);
                    preparedStatement1.executeUpdate();
                    preparedStatement1.close(); //preparedStatement1 close
                }

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
            return true;
        }
    }
