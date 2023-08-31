package com.example.atmmachine.models;


import com.example.atmmachine.utils.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    private static final String INSERT_USER = "INSERT INTO customers(customerName, accountNumber, pin, availableBalance, totalBalance) VALUES (?,?,?,?,?)";
    private static final String UPDATE_USER = "UPDATE customers SET customerName = ?, accountNumber = ?, pin = ?, availableBalance = ?, totalBalance = ? WHERE id = ?";
    private static final String DELETE_USER = "DELETE FROM customers WHERE id = ?";
    private static final String GET_USER_BY_ID = "SELECT * FROM customers WHERE id = ?";
    private static final String GET_USER_BY_accountNumber = "SELECT * FROM customers WHERE accountNumber = ?";

    public static final String GET_ALL_USERS = "SELECT * FROM customers";
    private static final String UPDATE_USER_BALANCE = "UPDATE customers SET availableBalance = ? WHERE id = ?";

    public void createUser(Customer customer) throws  SQLException {
        try(Connection connection = DatabaseConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement (INSERT_USER)){
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setString(2, customer.getAccountNumber());
            preparedStatement.setString(3, customer.getPin());
            preparedStatement.setString(4, customer.getAvailableBalance());
            preparedStatement.setString(5, customer.getTotalBalance());

            preparedStatement.executeUpdate();




        }
    }

    public void updateUser(Customer customer) throws  SQLException {
        try(Connection connection = DatabaseConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement (UPDATE_USER)){
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setString(2, customer.getAccountNumber());
            preparedStatement.setString(3, customer.getPin());
            preparedStatement.setString(4, customer.getAvailableBalance());
            preparedStatement.setString(5, customer.getTotalBalance());
            preparedStatement.setInt(6, customer.getId());

            preparedStatement.executeUpdate();




        }
    }

    public void deleteUser(int userId) throws  SQLException {
        try(Connection connection = DatabaseConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement (DELETE_USER)){
            preparedStatement.setInt(1, userId);

            preparedStatement.executeUpdate();




        }
    }

    public Customer getUserById(int userId) throws  SQLException {
        try(Connection connection = DatabaseConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement (GET_USER_BY_ID)){
            preparedStatement.setInt(1, userId);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    return extractCustomerFromResultSet(resultSet);
                }
            }





        }
        return null;
    }


    public void withdraw(int userId, double amount) throws SQLException {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_BALANCE)) {
            Customer customer = getUserById(userId);
            if (customer != null) {
                double currentBalance = Double.parseDouble(customer.getAvailableBalance());


                if (currentBalance >= amount) {
                    double newBalance = currentBalance - amount;


                    customer.setAvailableBalance(String.valueOf(newBalance));
                    customer.setTotalBalance(String.valueOf(newBalance));

                    updateUser(customer);
                } else {
                    throw new IllegalArgumentException("Insufficient funds for withdrawal.");
                }
            } else {
                throw new IllegalArgumentException("User not found.");
            }
        }
    }
    public Customer getCustomerByAccountNumber(String accountNumber) throws SQLException {
        try(Connection connection = DatabaseConnector.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement (GET_USER_BY_accountNumber)){
            preparedStatement.setString(1, accountNumber);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    return extractCustomerFromResultSet(resultSet);
                }
            }
        }
        return null;
    }
    public List<Customer> getAllUsers() throws SQLException{
        List<Customer> customers = new ArrayList<>();
        try(Connection connection = DatabaseConnector.getConnection(); PreparedStatement
                preparedStatement = connection.prepareStatement(GET_ALL_USERS); ResultSet resultSet =
                    preparedStatement.executeQuery()){
            while(resultSet.next()) {
                Customer customer = extractCustomerFromResultSet(resultSet);
                customers.add(customer);
            }
        }
        return customers;
    }
    private Customer extractCustomerFromResultSet(ResultSet resultSet) throws  SQLException {
        Customer customer = new Customer();
        customer.setId(resultSet.getInt("id"));
        customer.setCustomerName(resultSet.getString("customerName"));
        customer.setAccountNumber(resultSet.getString("accountNumber"));
        customer.setPin(resultSet.getString("pin"));
        customer.setAvailableBalance(resultSet.getString("availableBalance"));
        customer.setTotalBalance(resultSet.getString("totalBalance"));
        return customer;
    }
}
