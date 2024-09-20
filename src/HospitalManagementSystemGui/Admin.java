package HospitalManagementSystemGui;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Admin {
    JFrame frame;
    private static final String url = "jdbc:mysql://localhost:3306/hospital";
    private static final String username = "root";
    private static final String password = "Kushal@2004";

    public Admin() {

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setTitle("Admin");
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        //------------------------------TOP PANEL------------------------------//
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.setBounds(0,0,800,50);
        topPanel.setBackground(Color.BLACK);

        JLabel label1 = new JLabel("ADMINISTRATOR");
        label1.setForeground(Color.white);
        label1.setFont(new Font("MV BOLI", Font.BOLD, 30));

        topPanel.add(label1);

        //------------------------------CENTER PANEL------------------------------//

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(null);
        centerPanel.setBounds(0,50,800,470);

        JLabel nameLabel = new JLabel("Doctor Name");
        nameLabel.setBounds(10,10,100,25);
        nameLabel.setFont(new Font("MV BOLI", Font.BOLD, 20));

        JTextField nameField = new JTextField();
        nameField.setBounds(150,10,200,25);
        nameField.setFont(new Font("MV BOLI", Font.PLAIN, 20));


        JLabel specializationLabel = new JLabel("Specialization");
        specializationLabel.setBounds(10,50,150,25);
        specializationLabel.setFont(new Font("MV BOLI", Font.BOLD, 20));

        JTextField specializationField = new JTextField();
        specializationField.setBounds(150,50,200,25);
        specializationField.setFont(new Font("MV BOLI", Font.PLAIN, 20));

        JButton addDoctor = new JButton("Add Doctor");
        addDoctor.setBounds(10,100,200,30);
        addDoctor.setFont(new Font("MV BOLI", Font.BOLD, 20));

        addDoctor.addActionListener(e -> {
            if(e.getSource() == addDoctor){
                String name = nameField.getText();
                String specialization = specializationField.getText();
                if(name.isEmpty() || specialization.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please fill all the fields","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                addDoctor(name,specialization);
            }

        });



        centerPanel.add(nameLabel);
        centerPanel.add(nameField);
        centerPanel.add(specializationLabel);
        centerPanel.add(specializationField);
        centerPanel.add(addDoctor);



        //------------------------------HOME PANEL------------------------------//
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new FlowLayout());
        homePanel.setBounds(0, 520, 800, 60);
        homePanel.setBackground(Color.BLACK);

        JButton button = new JButton("Back");
        button.setBounds(0, 0, 100, 50);
        button.setFocusable(false);
        button.addActionListener(e -> {
            if (e.getSource() == button) {
                frame.dispose();
                MainFrame mainFrame = new MainFrame();
            }
        });

        homePanel.add(button,BorderLayout.CENTER);


        frame.add(topPanel);
        frame.add(centerPanel);
        frame.add(homePanel);
        frame.setVisible(true);
    }

    public static void addDoctor(String name, String specialization){
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            PreparedStatement preparedStatement = connection.prepareStatement(("INSERT INTO doctor (name,specialization) VALUES(?,?)"));
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,specialization);
            preparedStatement.executeUpdate();
            connection.close();
            JOptionPane.showMessageDialog(null,"Doctor added successfully!","Success",JOptionPane.INFORMATION_MESSAGE);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
