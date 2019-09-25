package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modall.Authentication;

public class LoginView {
	
	public LoginView() {
		 JFrame myWindow = new JFrame();
		myWindow.setTitle("Students Information System");
		myWindow.setBounds(200, 200, 600, 400 );
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
		Container mainCont = myWindow.getContentPane(); 
		mainCont.setLayout(new BorderLayout()); 
		
		myWindow.getContentPane().setBackground(Color.GRAY);
		myWindow.setVisible(true);
		
		myDialog myDlg = new myDialog(myWindow);
		myDlg.setVisible(true);
	
	   
	}
}
