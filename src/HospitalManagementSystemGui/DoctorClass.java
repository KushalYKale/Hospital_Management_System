package HospitalManagementSystemGui;

import java.sql.*;

public class DoctorClass {

    private static final String url = "jdbc:mysql://localhost:3306/hospital";
    private static final String username = "root";
    private static final String password = "Kushal@2004";

    public DoctorClass(){
        viewDoctor();
    }


    public String viewDoctor(){
        StringBuilder result = new StringBuilder();
        try{
            Connection connection =DriverManager.getConnection(url,username,password);
            String query  = "SELECT * FROM doctor";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specialization = resultSet.getString("specialization");
                result.append("ID :").append(id).append(", Name :").append(name).append(", Specialization :").append(specialization).append("\n");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }
}
