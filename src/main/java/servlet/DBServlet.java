package servlet;

import entity.Customer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBServlet extends HttpServlet {

    ServletConfig config;
    private String driverName;
    private String username;
    private String password;
    private Connection connection;
    private Statement statement;
    private String url;
    ResultSet resultSet =null;

    public void init(ServletConfig config)throws ServletException {
        super.init(config);
        this.config = config;
        driverName = config.getInitParameter("driverName");
        username = config.getInitParameter("username");
        password = config.getInitParameter("password");
        url = config.getInitParameter("url");
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        List<Customer> customerList = new ArrayList<>();
        try{
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            addCustomerToDB(request, connection);
            System.out.println("***********add customer to database***********");

            request.setAttribute("customerList", getCustomersFromDB(customerList));
            System.out.println("***********get customer from database***********");

            resultSet.close();
            statement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        throw new ServletException("ServletException");
        //request.getRequestDispatcher("result.jsp").forward(request,response);
    }

    private List<Customer> getCustomersFromDB(List<Customer> customerList) throws SQLException {
        String querySql="select * from customer;";
        resultSet = statement.executeQuery(querySql);
        while (resultSet.next()){
            customerList.add(new Customer(resultSet.getString(1), resultSet.getString(2)));
        }
        return customerList;
    }

    private void addCustomerToDB(HttpServletRequest request, Connection conn) throws SQLException {
        String insertSql ="INSERT customer(firstName, lastName) VALUES(?, ?);";
        PreparedStatement preparedStatement = conn.prepareStatement(insertSql);
        preparedStatement.setString(1, request.getParameter("firstName"));
        preparedStatement.setString(2, request.getParameter("lastName"));
        preparedStatement.executeUpdate();
    }

    @Override
    public void destroy() {
        System.out.println("***********This is the servlet destroy***********");
    }
}
