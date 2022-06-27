package fr.epita.mob.services.jdbc;

import fr.epita.mob.datamodel.Contact;
import fr.epita.mob.services.exceptions.ConfigurationException;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactJDBCDAO {

    DataSource ds;

    public ContactJDBCDAO(DataSource ds) {
        this.ds = ds;
    }

    public void create(Contact contact) throws SQLException {
        Connection connection = ds.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO CONTACT (first_name,last_name,company_name,address,city,county,states,phone1,phone,email) values(?,?,?,?,?,?,?,?,?,?)");

        preparedStatement.setString(1, contact.getFirstname());
        preparedStatement.setString(2, contact.getLastname());
        preparedStatement.setString(3, contact.getCompanyname());
        preparedStatement.setString(4, contact.getAddress());
        preparedStatement.setString(5, contact.getCity());
        preparedStatement.setString(6, contact.getCounty());
        preparedStatement.setString(7, contact.getState());
        preparedStatement.setString(8, contact.getPhone1());
        preparedStatement.setString(9, contact.getPhone());
        preparedStatement.setString(10, contact.getEmail());
        preparedStatement.execute();
    }


    public static String search(String firstname) throws SQLException {
        String names = "";
        String sql = "SELECT first_name FROM CONTACT WHERE first_name = ? ;";


        ConfigurationException conf = ConfigurationException.getInstance();
        Connection connection = DriverManager.getConnection(conf.getDBUrl(), conf.getDBUser(), conf.getDBPassword());

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, firstname);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            names += resultSet.getString("first_name");

        }

        return names;
    }

    public static Contact update(String email, String address) throws SQLException {
        Contact contact = new Contact();
        String sql = "UPDATE CONTACT SET address = ? where email = ?";


        ConfigurationException conf = ConfigurationException.getInstance();
        Connection connection = DriverManager.getConnection(conf.getDBUrl(), conf.getDBUser(), conf.getDBPassword());

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, address);
        preparedStatement.setString(2, email);
        preparedStatement.executeUpdate();

        PreparedStatement prepare = connection.prepareStatement("Select * From CONTACT where email = ?");
        prepare.setString(1, email);
        ResultSet result = prepare.executeQuery();

        while (result.next()) {
            contact.setFirstName(result.getString(1));
            contact.setLastname(result.getString(2));
            contact.setCompanyname(result.getString(3));
            contact.setAddress(result.getString(4));
            contact.setCity(result.getString(5));
            contact.setCounty(result.getString(6));
            contact.setState(result.getString(7));
            contact.setPhone1(result.getString(8));
            contact.setPhone(result.getString(9));
            contact.setEmail(result.getString(10));

        }



        return contact;
    }


    public static List<Contact> find(String states) throws SQLException {

        List<Contact> contacts = new ArrayList<>();
        String sql = " SELECT * from CONTACT WHERE states = ?";


        ConfigurationException conf = ConfigurationException.getInstance();
        Connection connection = DriverManager.getConnection(conf.getDBUrl(), conf.getDBUser(), conf.getDBPassword());

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, states);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            contacts.add(new Contact(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    resultSet.getString(9),
                    resultSet.getString(10)
            ));
        }

        return contacts;
    }

}
