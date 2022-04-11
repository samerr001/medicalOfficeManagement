package com.cabinet.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.io.File;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.cabinet.bean.Patient;
import com.cabinet.dao.PatientDao;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class IntroInterface extends JFrame {
	
	private JTextField textField;
	int cin ;
	private static String fileName = "cabinet.xml";

	@SuppressWarnings("deprecation")
	public IntroInterface() {
		initialize();
		this.show();
	}
	
	private void initialize() {
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\samer\\Downloads\\care.png"));
		this.setTitle("Cabinet m\u00E9dical\r\n");
		this.setBounds(100, 100, 582, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);

		
		JLabel lblBienvenueChezNotre = DefaultComponentFactory.getInstance().createTitle("Bienvenue chez notre Cabinet m\u00E9dical");
		lblBienvenueChezNotre.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblBienvenueChezNotre.setBackground(new Color(139, 0, 139));
		lblBienvenueChezNotre.setForeground(new Color(0, 0, 0));
		lblBienvenueChezNotre.setBounds(100, 24, 379, 24);
		this.getContentPane().add(lblBienvenueChezNotre);
		
		JLabel lblCin = new JLabel("Votre CIN :\r\n");
		lblCin.setForeground(new Color(255, 255, 255));
		lblCin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCin.setBounds(151, 108, 92, 24);
		this.getContentPane().add(lblCin);
		
		textField = new JTextField();
		//textField.setText("\r\n\r\n\r\n\r\n");
		textField.setBounds(253, 110, 107, 24);
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Ajouter\r\n");
		btnNewButton.addActionListener(e ->{
			
			if (textField.getText().equals("")==false) {
				
				this.dispose();
			new addInterface(Integer.parseInt(textField.getText()));
			}
			
		});
		
		btnNewButton.setBounds(50, 319, 89, 23);
		this.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modifier\r\n");
		btnNewButton_1.addActionListener(e->{
		/*	
			try {
				File inputFile = new File(fileName);
		        SAXReader reader = new SAXReader();
		        Document document = reader.read( inputFile );
		        
		        List<Node> nodes = document.selectNodes("/patients/patient" );
		        for (Node node : nodes) {
		        	if (Integer.parseInt(node.valueOf("@cin"))==Integer.parseInt(textField.getText())) {
		        		this.dispose();
		        		new ModInterface(Integer.parseInt(textField.getText()));
		        		
		        	}
		        	
		        	else if (PatientDao.findById(cin)==null) {
		        		JOptionPane.showMessageDialog(null,"patient n'existe pas","Veuillez verifier", JOptionPane.INFORMATION_MESSAGE);
		        		}
		        }}
				catch(Exception exp) {
				}*/
			boolean verif = false;
			Vector<Patient> v =PatientDao.findAll();
			for (Patient p:v) {
				if (Integer.toString(p.getCin()).equals(textField.getText())){
					verif = true;
					break;
				}
			}
			
			if(verif) {
				this.dispose();
        		new ModInterface(Integer.parseInt(textField.getText()));
			}else {
				JOptionPane.showMessageDialog(null,"patient n'existe pas","Veuillez verifier", JOptionPane.INFORMATION_MESSAGE);
			}
				});
			
		
		btnNewButton_1.setBounds(175, 319, 89, 23);
		this.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Supprimer\r\n");
		btnNewButton_2.setBounds(300, 319, 89, 23);
		btnNewButton_2.addActionListener(e->{
			
			boolean verif = false;
			Vector<Patient> v =PatientDao.findAll();
			for (Patient p:v) {
				if (Integer.toString(p.getCin()).equals(textField.getText())){
					verif = true;
					break;
				}
			}
			
			if(verif) {
				this.dispose();
        		PatientDao.deletePatient(Integer.parseInt(textField.getText()));
        		JOptionPane.showMessageDialog(null,"patient supprimé","Admin", JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null,"patient n'existe pas","Veuillez verifier", JOptionPane.INFORMATION_MESSAGE);
			}
				});
		
		this.getContentPane().add(btnNewButton_2);
		JButton btnNewButton_3 = new JButton("Afficher\r\n");
		btnNewButton_3.setBounds(425, 319, 89, 23);
		this.getContentPane().add(btnNewButton_3);
	    btnNewButton_3.addActionListener(e->{
			new ShowAll(); });
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\samer\\eclipse-workspace\\JavaProject\\img\\pexels-photo-905874 (4).jpeg"));
		lblNewLabel.setBounds(0, 0, 566, 411);
		this.getContentPane().add(lblNewLabel);
	}

}
