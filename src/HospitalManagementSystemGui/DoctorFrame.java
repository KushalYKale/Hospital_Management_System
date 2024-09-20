package HospitalManagementSystemGui;

import javax.swing.*;
import java.awt.*;

public class DoctorFrame {

    JFrame frame;
    JTextArea viewArea;


    public DoctorFrame() {

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setTitle("Doctor");
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);


        //------------------------------TOP PANEL------------------------------//
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.setBounds(0, 0, 800, 50);
        topPanel.setBackground(Color.BLACK);

        JLabel label1 = new JLabel("Manage Doctors");
        label1.setForeground(Color.white);
        label1.setFont(new Font("MV BOLI", Font.BOLD, 30));

        topPanel.add(label1);


        //------------------------------CENTER PANEL------------------------------//

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(null);
        centerPanel.setBounds(0, 50, 800, 230);

        JButton viewDoctor = new JButton("View Doctors");
        viewDoctor.setBounds(10, 10, 200, 30);
        viewDoctor.setFont(new Font("MV BOLI", Font.BOLD, 20));
        viewDoctor.setFocusable(false);
        viewDoctor.setBackground(Color.BLACK);
        viewDoctor.setForeground(Color.white);
        viewDoctor.addActionListener(e -> {
            if(e.getSource() == viewDoctor){
                DoctorClass doctorClass = new DoctorClass();
                try{
                    viewArea.setText(doctorClass.viewDoctor());
                }catch(Exception s){
                    s.printStackTrace();
                }

            }
        });
        centerPanel.add(viewDoctor);



        //------------------------------BOTTOM PANEL------------------------------//

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBounds(0, 280, 800, 240);

        viewArea = new JTextArea();
        viewArea.setFont(new Font("MV BOLI", Font.PLAIN, 20));
        viewArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(viewArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 50, 780, 300);

        bottomPanel.add(scrollPane, BorderLayout.CENTER);



        //------------------------------HOME BUTTON------------------------------//
        JPanel homeButton = new JPanel();
        homeButton.setLayout(new FlowLayout());
        homeButton.setBounds(0, 520, 800, 60);
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

        homeButton.add(home, BorderLayout.CENTER);


        frame.add(centerPanel);
        frame.add(bottomPanel);
        frame.add(topPanel);
        frame.add(homeButton);
        frame.setVisible(true);

    }
}
