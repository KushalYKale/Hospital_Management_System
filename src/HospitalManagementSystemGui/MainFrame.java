package HospitalManagementSystemGui;

import javax.swing.*;
import java.awt.*;
import java.net.PasswordAuthentication;

public class MainFrame extends JFrame {

    private JPanel panel1;

    

    public MainFrame() {
        setTitle("HOSPITAL MANAGEMENT SYSTEM");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        // Initialize panel1
        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        panel1.setBackground(new Color(238, 238, 238));
        panel1.setBounds(0, 0, 800, 60);

        JLabel label1 = new JLabel("Hospital Management System");
        label1.setFont(new Font("MV Boli", Font.BOLD, 30));
        label1.setForeground(new Color(32, 0, 232));

        panel1.setBorder(null);
        panel1.add(label1);
        add(panel1);

        JButton button1 = new JButton();
        button1.setBounds(0, 61, 266, 540);
        button1.setFocusable(false);
        button1.setBorder(null);
        button1.setIcon(new ImageIcon("Hospital_Management_System/Resources/patient.png"));

        button1.addActionListener(e -> {
            if (e.getSource() == button1) {
                dispose();
                PatientFrame patientFrame = new PatientFrame();
            }
        });

        add(button1);


        JButton button2 = new JButton();
        button2.setText("Doctor");
        button2.setBounds(266, 61, 266, 540);
        button2.setFocusable(false);
        button2.setBorder(null);
        button2.setIcon(new ImageIcon("Hospital_Management_System/Resources/doctor (1).png"));

        button2.addActionListener(e -> {
            if (e.getSource() == button2) {
                dispose();
                DoctorFrame doctorFrame = new DoctorFrame();
            }
        });

        add(button2);

        JButton button3 = new JButton();
        button3.setText("ADMIN");
        button3.setBounds(532, 61, 266, 540);
        button3.setFocusable(false);
        button3.setBorder(null);

        button3.addActionListener(e -> {
            if (e.getSource() == button3) {
                dispose();
                PasswordFrame passwordFrame = new PasswordFrame();
            }
        });

        add(button3);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}