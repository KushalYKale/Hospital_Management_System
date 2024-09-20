package hospitalManagementSystemCLI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Doctor {
    private Connection connection;


    public Doctor(Connection connection) {
        this.connection = connection;
    }


    public void viewDoctors() {
        String query = "SELECT * FROM doctor";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Doctors");
            System.out.println("+------------+--------------------+--------+--------+");
            System.out.println("| Doctor ID  | Name               | Specialization  |");
            System.out.println("+------------+--------------------+-----------------+");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specialization = resultSet.getString("specialization");
                System.out.printf("|%12s|%-20s|%-17s|\n", id, name, specialization);
                System.out.println("+------------+--------------------+-----------------+");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public boolean getDoctorById(int id) {
        String query = "SELECT * FROM doctor WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}


