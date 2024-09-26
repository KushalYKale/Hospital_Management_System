package HospitalManagementSystemGui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PatientFrame {

    JFrame frame;
    JTextArea viewArea;

    private static final String url = "jdbc:mysql://localhost:3306/hospital";
    private static final String username = "root";
    private static final String password = "password";//add your password


    public PatientFrame() {

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 710);
        frame.setTitle("Patient");
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        //------------------------------TOP PANEL------------------------------//
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.setBounds(0, 0, 1000, 50);
        topPanel.setBackground(Color.BLACK);

        JLabel label1 = new JLabel("Manage Patients");
        label1.setForeground(Color.white);
        label1.setFont(new Font("MV BOLI", Font.BOLD, 30));

        topPanel.add(label1);


        //------------------------------CENTER PANEL------------------------------//
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(null);
        centerPanel.setBounds(0, 50, 1000, 320);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(10, 30, 100, 30);
        nameLabel.setFont(new Font("MV BOLI", Font.BOLD, 30));

        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(100, 30, 200, 25);
        nameTextField.setFont(new Font("MV BOLI", Font.PLAIN, 20));

        JLabel ageLabel = new JLabel("Age");
        ageLabel.setBounds(10, 120, 100, 30);
        ageLabel.setFont(new Font("MV BOLI", Font.BOLD, 25));

        JTextField ageTextField = new JTextField();
        ageTextField.setBounds(100, 120, 200, 30);
        ageTextField.setFont(new Font("MV BOLI", Font.PLAIN, 20));

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(10, 210, 100, 30);
        genderLabel.setFont(new Font("MV BOLI", Font.BOLD, 25));

        JTextField genderTextField = new JTextField();
        genderTextField.setBounds(100, 210, 200, 30);
        genderTextField.setFont(new Font("MV BOLI", Font.PLAIN, 20));


        JButton addButton = new JButton("Add Patient");
        addButton.setBounds(10, 270, 200, 30);
        addButton.setFont(new Font("MV BOLI", Font.BOLD, 20));
        addButton.setFocusable(false);
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.white);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                int age = Integer.parseInt(ageTextField.getText());
                String gender = genderTextField.getText();
                try {
                    PatientClass patient = new PatientClass(name, age, gender);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        JButton viewButton = new JButton("View Patients");
        viewButton.setBounds(220, 270, 200, 30);
        viewButton.setFont(new Font("MV BOLI", Font.BOLD, 20));
        viewButton.setFocusable(false);
        viewButton.setBackground(Color.BLACK);
        viewButton.setForeground(Color.white);
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    viewArea.setText(PatientClass.viewPatients());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        centerPanel.add(viewButton);
        centerPanel.add(addButton);
        centerPanel.add(genderTextField);
        centerPanel.add(genderLabel);
        centerPanel.add(ageTextField);
        centerPanel.add(nameTextField);
        centerPanel.add(ageLabel);
        centerPanel.add(nameLabel);


        //------------------------------BOTTOM PANEL------------------------------//
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBounds(0, 370, 1000, 250);

        viewArea = new JTextArea();
        viewArea.setBounds(10, 10, 980, 230);
        viewArea.setFont(new Font("MV BOLI", Font.PLAIN, 20));
        viewArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(viewArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        bottomPanel.add(scrollPane, BorderLayout.CENTER);


        //------------------------------HOME BUTTON------------------------------//
        JPanel homeButton = new JPanel();
        homeButton.setLayout(new FlowLayout());
        homeButton.setBounds(0, 620, 1000, 60);
        homeButton.setBackground(Color.BLACK);

        JButton home = new JButton("Home");
        home.setFocusable(false);
        home.setFont(new Font("MV BOLI", Font.BOLD, 20));
        home.setForeground(Color.white);
        home.setBackground(Color.BLACK);
        home.addActionListener(e -> {
            if (e.getSource() == home) {
                frame.dispose();
                MainFrame mainFrame = new MainFrame();
            }
        });

        homeButton.add(home);
        //------------------------------HOME BUTTON------------------------------//


        frame.add(topPanel);
        frame.add(centerPanel);
        frame.add(bottomPanel);
        frame.add(homeButton);
        frame.setVisible(true);
    }
}
