package HospitalManagementSystemGui;

import javax.swing.*;

public class PasswordFrame {

    private final String userName = "admin";
    private final String password = "1234";

    public PasswordFrame(){
        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JLabel label1 = new JLabel("Username");
        label1.setBounds(50, 50, 100, 25);

        JTextField textField1 = new JTextField();
        textField1.setBounds(150, 50, 200, 25);

        JLabel label2 = new JLabel("Password");
        label2.setBounds(50, 100, 100, 25);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 200, 25);

        JButton button = new JButton("Login");
        button.setBounds(150, 150, 100, 25);
        button.addActionListener(e -> {
            if(e.getSource() == button){
                String userName = textField1.getText();
                String password = passwordField.getText();

                if(userName.equals(this.userName) && password.equals(this.password)){
                    frame.dispose();
                    Admin admin = new Admin();
                } else{
                    JOptionPane.showMessageDialog(null,"Invalid UserName or Password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        frame.add(button);
        frame.add(textField1);
        frame.add(label1);
        frame.add(label2);
        frame.add(passwordField);
        frame.setVisible(true);
    }

}
