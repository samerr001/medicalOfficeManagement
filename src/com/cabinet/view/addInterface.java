package com.cabinet.view;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.cabinet.bean.Patient;
import com.cabinet.bean.RendezVous;
import com.cabinet.dao.PatientDao;

public class addInterface extends JFrame{
	
	private JTextField nomField, prenomField, dateNaissanceField,
		mobileField, emailField, addressField, metierField, maladieField, prixField, dateField;
	private Choice genderField, rendezVousTypeField;
	private JButton enregistrer, annuler;
	private JLabel upperLabel;
	private int cin;
	
	@SuppressWarnings("deprecation")
	public addInterface(int cin) {
		this.cin = cin;
		
		//window initialization
		this.setLayout(new BorderLayout());
		this.setSize(640,480);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		//uppper panel initialization
		JPanel upperPanel =  new JPanel();
		upperLabel = new JLabel("Patient n° CIN : "+this.cin, SwingConstants.CENTER);
		upperLabel.setSize(200,50);
		upperLabel.setForeground(Color.darkGray);
		upperPanel.add(upperLabel);
		
		//central panel initialization
		JPanel centralPanel = new JPanel();
		centralPanel.setLayout(new GridLayout(13,2));
		
		centralPanel.add(new JLabel("nom: "));
		nomField = new JTextField();
		centralPanel.add(nomField);
		
		centralPanel.add(new JLabel("prenom : "));
		prenomField = new JTextField();
		centralPanel.add(prenomField);
		
		centralPanel.add(new JLabel("date de naissance : "));
		dateNaissanceField = new JTextField();
		centralPanel.add(dateNaissanceField);
		
		centralPanel.add(new JLabel("tel  : "));
		mobileField = new JTextField();
		centralPanel.add(mobileField);
		
		centralPanel.add(new JLabel("email : "));
		emailField = new JTextField();
		centralPanel.add(emailField);
		
		centralPanel.add(new JLabel("addresse : "));
		addressField = new JTextField();
		centralPanel.add(addressField);
		
		centralPanel.add(new JLabel("metier : "));
		metierField = new JTextField();
		centralPanel.add(metierField);
		
		centralPanel.add(new JLabel("sexe : "));
		genderField = new Choice();
		genderField.add("male");
		genderField.add("female");
		centralPanel.add(genderField);
		
		centralPanel.add(new JLabel("maladie : "));
		maladieField = new JTextField();
		centralPanel.add(maladieField);
		
		centralPanel.add(new JLabel("type de RendezVous : "));
		rendezVousTypeField = new Choice();
		rendezVousTypeField.add("Rendez-vous");
		rendezVousTypeField.add("controle");
		
		centralPanel.add(rendezVousTypeField);
		
		centralPanel.add(new JLabel("prix à payer : "));
		prixField = new JTextField();
		centralPanel.add(prixField);
		
		centralPanel.add(new JLabel("date : "));
		dateField = new JTextField();
		centralPanel.add(dateField);
		
		//lower field initialization
		JPanel lowerPanel = new JPanel();
		enregistrer = new JButton("enregistrer");
		
		enregistrer.addActionListener(e->{
					if (verifData()) {
					Patient p = new Patient(
					cin,
					nomField.getText(),
					prenomField.getText(),
					dateNaissanceField.getText(),
					Integer.parseInt((mobileField.getText())),
					emailField.getText(),addressField.getText(),
					metierField.getText(),
					genderField.getItem(genderField.getSelectedIndex()),
					maladieField.getText()
					);
			
					p.AppendeRendezVous(new RendezVous(
									dateField.getText(),
									Integer.parseInt(prixField.getText()),
									rendezVousTypeField.getItem(rendezVousTypeField.getSelectedIndex())
									));
					
					PatientDao.create(p);
					JOptionPane.showMessageDialog(null,"patient bien enregistré","confirmation", JOptionPane.INFORMATION_MESSAGE);
					}else {
						
					}
					dispose();
					new IntroInterface();
		
		});
		
		lowerPanel.add(enregistrer);
		
		annuler = new JButton("annuler");
		annuler.addActionListener(e->{
			new IntroInterface();
			this.dispose();
		});
		lowerPanel.add(annuler);
		
		//adding the panels
		this.add(upperPanel,BorderLayout.NORTH);
		this.add(centralPanel,BorderLayout.CENTER);
		this.add(lowerPanel,BorderLayout.SOUTH);
		
		this.show();
	}

	private boolean verifData() {
		return true;
	}

}
