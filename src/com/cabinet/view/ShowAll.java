package com.cabinet.view;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.cabinet.bean.Patient;
import com.cabinet.bean.RendezVous;
import com.cabinet.dao.PatientDao;


public class ShowAll extends JFrame{

	private JTable patientsTable;
	private JTable RendezVousTable;
	private JButton back;
	private int selectedRowIndex;
	

	public ShowAll() {
		this.setLayout(new BorderLayout());
		this.setSize(800,600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTextField cinn = new JTextField("Numero cin");
		JLabel lab = new JLabel();
		JButton recherche = new JButton();
		
		
		
		String[] columnNames = {"cin","nom","prenom","dateNaissance","mobile","email","address","metier","gender","maladie" };
		String[][] data = PatientAsTable(PatientDao.findAll());
		
		this.patientsTable = new JTable(new DefaultTableModel(data,columnNames));
		
		this.patientsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }

			private void jTable1MouseClicked(MouseEvent evt) {
			
			DefaultTableModel model = (DefaultTableModel)RendezVousTable.getModel();
			String[] columnNames1 = { "date", "type", "prix" };
			String[][] data = RendezVousAsTable(PatientDao.
					findById(Integer.parseInt(
							patientsTable
							.getModel()
							.getValueAt(patientsTable.getSelectedRow(), 0).toString())).getRendezVous());
			model.setDataVector(data,columnNames1);
			}
        });

		this.patientsTable.setBounds(30, 40, 200, 300);
		JScrollPane sp = new JScrollPane(this.patientsTable);
		
		this.add(sp,BorderLayout.NORTH);
		
		String[] columnNames1 = { "date", "type", "prix" };
		this.RendezVousTable = new JTable(new DefaultTableModel(null,columnNames1));
		this.RendezVousTable.setBounds(30, 40, 200, 300);
		JScrollPane sr = new JScrollPane(this.RendezVousTable);
		
		this.add(sr,BorderLayout.CENTER);
		
		this.show();
		
	}
	
	
	protected String[][] RendezVousAsTable(Vector<RendezVous> rendezVous) {
		System.out.print(rendezVous.size());	
		String[][] data1 = new String[rendezVous.size()][3];
		int i=0;
		for (RendezVous rv : rendezVous) {
			data1[i][0] =rv.getDate();
			data1[i][1] =rv.getType();
			data1[i][2] = Integer.toString(rv.getPrix());
			i++;
		}
		
		return data1;
	}
	
	private String[][] PatientAsTable(Vector<Patient> patients) {
		System.out.print(patients.size());
		String[][] data = new String[patients.size()][10];
		int i= 0;
		
		for (Patient p : patients) {
			data[i][0] =Integer.toString(p.getCin());
			data[i][1] = p.getNom();
			data[i][2] = p.getPrenom();
			data[i][3] = p.getDateNaissance();
			data[i][4] = Integer.toString(p.getMobile());
			data[i][5] = p.getEmail();
			data[i][6] = p.getAddress();
			data[i][7] = p.getMetier();
			data[i][8] = p.getGender();
			data[i][9] = p.getMaladie();
			i++;
		}
		
		return data;}
	}

	
	

