package HospitalManagementSystemGui;

import javax.swing.*;
import java.sql.*;


public class PatientClass {
    private static final String url = "jdbc:mysql://localhost:3306/hospital";
    private static final String username = "root";
    private static final String password = "password";//add your password

    private String name;
    private int age;
    private String gender;

    public PatientClass(String name, int age, String gender) throws SQLException {

        addPatient(name, age, gender);
        viewPatients();

    }

    public static void addPatient(String name, int age, String gender) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO patients (name,age,gender) Values(?,?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, gender);
            preparedStatement.executeUpdate();
            connection.close();
            JOptionPane.showMessageDialog(null, "User added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String viewPatients() {
        StringBuilder result = null;
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM patients";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            result = new StringBuilder();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                result.append("ID: ").append(id).append(", Name: ").append(name).append(", Age: ").append(age).append(", Gender: ").append(gender).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

}
