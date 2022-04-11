package com.cabinet.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import AppPackage.AnimationClass;

import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class authentification {
    AnimationClass Ac = new AnimationClass();
	JFrame frame;
	public JTextField textField;
	public JTextField textField_1;
	public JButton btnLogin, btnAnnuler;
	JLabel jLabel1;
  
	/**
	 * Launch the application.
	 */
 	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					authentification window = new authentification();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	public authentification() {
		initialize();}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()  {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\samer\\Downloads\\care.png"));
		frame.setBounds(100, 100, 725, 503);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblLogin = new JLabel("Login :");
		lblLogin.setForeground(Color.BLACK);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogin.setBounds(82, 216, 81, 25);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMotDePasse.setForeground(SystemColor.desktop);
		lblMotDePasse.setBounds(82, 258, 131, 25);
		frame.getContentPane().add(lblMotDePasse);
		
		textField = new JTextField();
		textField.setBounds(320, 222, 96, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(320, 264, 96, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblIdentifiezVous = DefaultComponentFactory.getInstance().createTitle("Identifiez Vous");
		lblIdentifiezVous.setBackground(Color.MAGENTA);
		lblIdentifiezVous.setFont(new Font("Brush Script MT", Font.PLAIN, 38));
		lblIdentifiezVous.setForeground(Color.WHITE);
		lblIdentifiezVous.setBounds(265, 69, 233, 66);
		frame.getContentPane().add(lblIdentifiezVous);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLogin.setForeground(SystemColor.textHighlight);
		btnLogin.setBounds(246, 322, 103, 36);
		frame.getContentPane().add(btnLogin);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAnnuler.setForeground(SystemColor.textHighlight);
		btnAnnuler.setBounds(379, 322, 103, 36);
		frame.getContentPane().add(btnAnnuler);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\samer\\eclipse-workspace\\JavaProject\\img\\authentification.jpg"));
		lblNewLabel.setBounds(0, 0, 709, 464);
		frame.getContentPane().add(lblNewLabel);
		btnAnnuler.addActionListener(e ->{
			
			System.exit(0);
		});
        btnLogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
			if (((textField.getText()).equalsIgnoreCase("admin") )&& ((textField_1.getText()).equalsIgnoreCase("admin"))) {
				IntroInterface au =new IntroInterface();
			}
		
		}});
	
}
}