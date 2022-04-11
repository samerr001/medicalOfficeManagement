package com.cabinet.view;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.cabinet.bean.Patient;
import com.cabinet.bean.RendezVous;
import com.cabinet.dao.PatientDao;

public class ModInterface extends JFrame {
	
	private JTextField nomField, prenomField, dateNaissanceField,
	mobileField, emailField, addressField, metierField, maladieField ;
	private JTextField date, prix, type;
	private Choice genderField, rendezVousTypeField;
	private JButton enregistrer, annuler,add,delete;
	
	private JTable dataTable;
	
	private int cin;
	private static int selectedRowIndex ;
	private Patient p;
	
	public ModInterface(int cin) {
		
		this.cin =cin;
		this.p = PatientDao.findById(this.cin);

		this.setLayout(new BorderLayout());
		this.setSize(800,600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		//uppper panel initialization
				JPanel upperPanel =  new JPanel();
				
				JLabel upperLabel = new JLabel("Patient n° CIN : "+this.cin, SwingConstants.CENTER);
				upperLabel.setSize(200,50);
				upperLabel.setForeground(Color.darkGray);
				upperPanel.add(upperLabel);
				
				JPanel upperLowerPanel = new JPanel();
				upperLowerPanel.setLayout(new GridLayout(9,2));
				
				upperLowerPanel.add(new JLabel("nom: "));
				nomField = new JTextField(p.getNom());
				upperLowerPanel.add(nomField);
				
				upperLowerPanel.add(new JLabel("prenom : "));
				prenomField = new JTextField(p.getPrenom());
				upperLowerPanel.add(prenomField);
				
				upperLowerPanel.add(new JLabel("date de naissance : "));
				dateNaissanceField = new JTextField(p.getDateNaissance());
				upperLowerPanel.add(dateNaissanceField);
				
				upperLowerPanel.add(new JLabel("tel  : "));
				mobileField = new JTextField(Integer.toString(p.getMobile()));
				upperLowerPanel.add(mobileField);
				
				upperLowerPanel.add(new JLabel("email : "));
				emailField = new JTextField(p.getEmail());
				upperLowerPanel.add(emailField);
				
				upperLowerPanel.add(new JLabel("addresse : "));
				addressField = new JTextField(p.getAddress());
				upperLowerPanel.add(addressField);
				
				upperLowerPanel.add(new JLabel("metier : "));
				metierField = new JTextField(p.getMetier());
				upperLowerPanel.add(metierField);
				
				upperLowerPanel.add(new JLabel("sexe : "));
				genderField = new Choice();
				genderField.add("male");
				genderField.add("female");
				genderField.select(p.getGender());
				upperLowerPanel.add(genderField);
				
				upperLowerPanel.add(new JLabel("maladie : "));
				maladieField = new JTextField(p.getMaladie());
				upperLowerPanel.add(maladieField);
				
				Box vBox = Box.createVerticalBox();
				vBox.add(upperLabel);
			    vBox.add(Box.createVerticalStrut(10));
			    vBox.add(upperLowerPanel);
			    
				upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.Y_AXIS));
				upperPanel.add(vBox);
				
		//center panel initialization
				JPanel centerPanel =  new JPanel();
				centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		//Jtable initialization
				String[] columnNames = { "date", "type", "prix" };
				//to be changed
				String[][] data = RendezVousAsTable(this.p);
				
				dataTable = new JTable(new DefaultTableModel(data,columnNames));
				
				dataTable.addMouseListener(new java.awt.event.MouseAdapter() {
		            public void mouseClicked(java.awt.event.MouseEvent evt) {
		                jTable1MouseClicked(evt);
		            }

					private void jTable1MouseClicked(MouseEvent evt) {
						
						selectedRowIndex = dataTable.getSelectedRow();
							/*
						  DefaultTableModel model = (DefaultTableModel)dataTable.getModel();
						  int selectedRowIndex = dataTable.getSelectedRow();
						  System.out.println(selectedRowIndex);
						  System.out.println(model.getValueAt(selectedRowIndex, 0).toString());
						  System.out.println(model.getValueAt(selectedRowIndex, 1).toString());
						  System.out.println(model.getValueAt(selectedRowIndex, 2).toString());
						  model.setValueAt("mod", selectedRowIndex, 0);
						  model.setValueAt("mod", selectedRowIndex, 1);
						  model.setValueAt("mod", selectedRowIndex, 2);
						  */
					}
		        });
				
				dataTable.setBounds(30, 40, 200, 300);
				 JScrollPane sp = new JScrollPane(dataTable);
				 
		//table mod fields init
				 JPanel tableModFields = new JPanel();
				 tableModFields.setLayout(new GridLayout(1,3));
				 date = new JTextField("date");
				 date.setSize(100, 50);
				 tableModFields.add(date);
				 prix = new JTextField("prix");
				 prix.setSize(100, 50);
				 tableModFields.add(prix);
				 /*
				 type = new JTextField("type");
				 type.setSize(100, 50);
				 tableModFields.add(type);
				 */
				 rendezVousTypeField = new Choice();
				rendezVousTypeField.add("Rendez-vous");
				rendezVousTypeField.add("controle");
				 rendezVousTypeField.setSize(100,50);
				 tableModFields.add(rendezVousTypeField);
		// table buttons init
				 JPanel tableModButtons = new JPanel();
				 add = new JButton("ajouter");
				 add.addActionListener(e->{
					 
					 if((date.getText()!=""|| date.getText()!="date")
							 ||(prix.getText()!=""|| prix.getText()!="prix")
							 ||(type.getText()!=""|| type.getText()!="type")
							 ) {
						 
						 DefaultTableModel model = (DefaultTableModel)dataTable.getModel();
						 model.addRow(new String[]{date.getText(), rendezVousTypeField.getSelectedItem(), prix.getText()});
					 }
				 });
				 tableModButtons.add(add);
				 delete = new JButton("delete");
				 delete.addActionListener(e->{
					 DefaultTableModel model = (DefaultTableModel)dataTable.getModel();
					 model.removeRow(selectedRowIndex);
					 
				 });
				 tableModButtons.add(delete);
				 
				 Box vBoxc = Box.createVerticalBox();
				 vBoxc.add(sp);
				 vBoxc.add(tableModFields);
				 vBoxc.add(tableModButtons);
				 centerPanel.add(vBoxc);
				
				 
		//lower panel
				JPanel lowerPanel = new JPanel();
				enregistrer = new JButton("enregistrer");
				enregistrer.addActionListener(e->{
					
					DefaultTableModel model = (DefaultTableModel)dataTable.getModel();
					
		        	p.setNom(nomField.getText());
		        	p.setPrenom(prenomField.getText());
		        	p.setDateNaissance(dateNaissanceField.getText());
		        	p.setMobile(Integer.parseInt(mobileField.getText()));
		        	p.setEmail(emailField.getText());
		        	p.setAddress(addressField.getText());
		        	p.setMetier(metierField.getText());
		        	p.setGender(genderField.getSelectedItem());
		        	p.setMaladie(maladieField.getText());
		        	
		        	p.resetRendezVous();
		        	
		        	for(int row = 0;row < dataTable.getRowCount();row++) {
		        		
		        		    p.AppendeRendezVous(new RendezVous(
		        		    		model.getValueAt(row, 0).toString(), 
		        		    		Integer.parseInt(model.getValueAt(row, 2).toString()), 
		        		    		model.getValueAt(row, 1).toString()
		        		    		));
		        		
		        		}
		        	PatientDao.updatePatient(p);
		        	System.out.println("done");

				});
				lowerPanel.add(enregistrer);
				annuler = new JButton("annuler");
				annuler.addActionListener(e->{
					new IntroInterface();
					this.dispose();
				});
				lowerPanel.add(annuler);
				
				this.add(upperPanel,BorderLayout.NORTH);
				this.add(centerPanel,BorderLayout.CENTER);
				this.add(lowerPanel,BorderLayout.SOUTH);
				this.show();
				
	}	
	
	String[][] RendezVousAsTable(Patient p){
		System.out.print(p.getRendezVous().size());
		String[][] data = new String[p.getRendezVous().size()][3];
		int i= 0;
		
		for (RendezVous rv: p.getRendezVous()) {
			data[i][0] =rv.getDate();
			data[i][1] =rv.getType();
			data[i][2] = Integer.toString(rv.getPrix());
			i++;
		}
		
		return data;
	}
	
}
