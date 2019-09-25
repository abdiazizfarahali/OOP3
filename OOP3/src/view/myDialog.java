package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import modall.Authentication;

public class myDialog extends JDialog {
    private boolean succeeded;
    private JTextField usertxtfld;
    private JPasswordField PwdField;
    private JLabel userLabel;
    private JLabel pwdLabel;
 
    public myDialog(JFrame parent) {
    	 super(parent, " PLEASE LOGIN TO CONTINUE!", true);
        
        JPanel myPanel = new JPanel(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();

        grid.fill = GridBagConstraints.HORIZONTAL;
 
         userLabel = new JLabel("Username: ");
        grid.gridx = 0;  
        grid.gridy = 0;
        grid.gridwidth = 1;
        myPanel.add(userLabel,grid);
        
        pwdLabel = new JLabel("Password: ");
        grid.gridx = 0;
        grid.gridy = 1;
        grid.gridwidth = 1;
        myPanel.add(pwdLabel,grid);
 
        usertxtfld= new JTextField(25);
        grid.gridx = 1;
        grid.gridy = 0;
        grid.gridwidth = 1;
        myPanel.add(usertxtfld,grid);
        
        PwdField = new JPasswordField(20);
        grid.gridx = 1;
        grid.gridy = 1;
        grid.gridwidth = 2;
        myPanel.add(PwdField,grid);
        myPanel.setBorder(new LineBorder(Color.GRAY));    

       Authentication authorise = new Authentication();
       JButton btnLogin = new JButton("Login");
       btnLogin.addActionListener( new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(Authentication.authenticate(getUsername(), getPwd())) {
						JOptionPane.showMessageDialog(myDialog.this,"YOU ARE SUCCESSFULLY LOGGED IN",
								"LOGIN SUCCESS", JOptionPane.INFORMATION_MESSAGE);
						succeeded = true;
						
					}else {
						JOptionPane.showMessageDialog(myDialog.this,"Invalid Username or Password",
						"ERROR", JOptionPane.ERROR_MESSAGE);
						usertxtfld.setText("");
						PwdField.setText("");
						succeeded = false;
					}
		}
       });
       JButton btnCancel = new JButton("Cancel");
       btnCancel.addActionListener( 
    		   new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) { 
					// TODO Auto-generated method stub
					dispose();
				}
       });
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnLogin);
        buttonPanel.add(btnCancel);
 
        getContentPane().add(myPanel, BorderLayout.CENTER); 
        getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
        pack();
        setResizable(false);
        setLocationRelativeTo(parent); 
       
        
    }
	public String getUsername() {
		return usertxtfld.getText().trim();
	}
	public String getPwd() {
		return new String(PwdField.getPassword());
	}
	public boolean isSucceeded() {
		return succeeded;
	}
    
}

