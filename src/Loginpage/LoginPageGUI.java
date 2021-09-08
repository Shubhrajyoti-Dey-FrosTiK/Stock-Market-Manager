package Loginpage;


import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.MouseInputAdapter;
import javax.swing.text.AttributeSet.ColorAttribute;

import Info.CustomerInfo;
import Loginpage.customerLogInToAccount.CustomerLogInToAccount;
import Startpage.StartPage;
import dependencies.AbsolutePath;



public class LoginPageGUI extends JFrame implements ActionListener{
    
    public JFrame frame = new JFrame();
    public JButton button = new JButton("LOGIN");
    public JTextField EmailText = new JTextField();
    public JPasswordField PassText = new JPasswordField();
    public JLabel back = new JLabel();
    public JLabel WrongText = new JLabel();

    public LoginPageGUI(int val){

        frame.setTitle("Registration Form");
        frame.setBounds(300, 90, 1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        // frame.setUndecorated(true);
        
        JLabel Login = new JLabel();
        Login.setText("LOGIN");
        Login.setFont(new Font("Ariel",Font.BOLD,50));
        Login.setBounds(250,70,500,100);
        frame.add(Login);

        JLabel Email = new JLabel();
        Email.setText("Email :");
        Email.setFont(new Font("Ariel",Font.PLAIN,20));
        Email.setBounds(250,170,100,100);
        frame.add(Email);

        JLabel Password = new JLabel();
        Password.setText("Password :");
        Password.setFont(new Font("Ariel",Font.PLAIN,20));
        Password.setBounds(250,270,200,100);
        frame.add(Password);

        if(val==0){
            WrongText.setBounds(260,500,300,20);
            WrongText.setForeground(Color.red);
            WrongText.setText("* Invalid Credentials");
            frame.add(WrongText);
        }

        EmailText.setBounds(250,235,100,20);
        EmailText.setSize(400,40);
        EmailText.setVisible(true);
        frame.add(EmailText);

        PassText.setBounds(250,335,100,20);
        PassText.setSize(400,40);
        PassText.setVisible(true);
        frame.add(PassText);
        
        button.setBounds(260,410,300,50);
        button.setOpaque(true);
        button.setBackground(new Color(255,101,45));
        button.setForeground(Color.white);
        button.setBorderPainted(false);
        button.addActionListener(this);
        frame.add(button);

        back.setBounds(20,0,100,50);
        back.setText("< Back");
        back.setForeground(Color.white);
        back.setFont(new Font("Ariel",Font.PLAIN,20));
        back.addMouseListener(new MouseInputAdapter(){
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                StartPage SP = new StartPage();
            }
        });
        frame.add(back);

        JLabel jLabelObject = new JLabel();
        AbsolutePath P = new AbsolutePath();
        jLabelObject.setIcon(new ImageIcon(P.AbsPath() + "src/Image/1.jpg"));
        jLabelObject.setBounds(0,0,200,600);
        frame.add(jLabelObject);

        JPanel rightpannel= new JPanel();
        rightpannel.setBounds(200,0,800,600);
        rightpannel.setBackground(new Color(245,252,255));
        frame.add(rightpannel);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == button){
            System.out.println(EmailText.getText());
            // System.out.println(PassText.getText());
            CustomerInfo data = new CustomerInfo();
            data.EmailID = EmailText.getText();
            data.Password = PassText.getPassword();
            data.AadharNo = "";
            // data.ConPass[0] = 'a' ;
            data.FullName = "";
            data.Username = "";

            frame.setVisible(false);
            CustomerLogInToAccount CLIA = new CustomerLogInToAccount();
            int flag = CLIA.CustomerLoginToAccount(data);
            if(flag==1){frame.dispose(); }
            else{LoginPageGUI L = new LoginPageGUI(0);}
        }
    }
}