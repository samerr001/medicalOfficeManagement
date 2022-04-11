import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.cabinet.bean.Patient;
import com.cabinet.bean.RendezVous;
import com.cabinet.dao.PatientDao;
import com.cabinet.view.IntroInterface;
import com.cabinet.view.ModInterface;
import com.cabinet.view.ShowAll;
import com.cabinet.view.authentification;

//import interfaces.IntroInterface;
//import interfaces.ModInterface;

public class Test {
	
	//JTable j;
	
	public static void main(String args[]) {
		
		new ShowAll();
		//new IntroInterface();
		
		
		//box layout example
		/*
		JFrame j = new JFrame();
		
		j.setTitle("Cabinet m\u00E9dical\r\n");
		j.setBounds(100, 100, 582, 450);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Box vBox = Box.createVerticalBox();
	    vBox.add(new JButton("button"));
	    vBox.add(Box.createVerticalStrut(10));
	    vBox.add(new JLabel("label"));
	    //vBox.add(Box.createVerticalGlue());
	    vBox.add(new JButton("button"));
	    vBox.add(Box.createVerticalStrut(10));
	    vBox.add(new JLabel("label"));

	    Box hBox = Box.createHorizontalBox();
	    hBox.add(new JButton("button"));
	    hBox.add(Box.createHorizontalStrut(10));
	    hBox.add(new JLabel("label"));
	    hBox.add(Box.createHorizontalGlue());
	    hBox.add(new JButton("button"));
	    hBox.add(Box.createHorizontalStrut(10));
	    hBox.add(new JLabel("label"));

	    JPanel panel = new JPanel();
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    panel.add(vBox);
	   // panel.add(Box.createGlue());
	   // panel.add(hBox);
	    
	    j.add(panel);
	    
	    j.show();
	    */
		
		//JTable example
		/*
		JFrame f = new JFrame();
		
		f.setTitle("Cabinet m\u00E9dical\r\n");
		f.setBounds(100, 100, 582, 450);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String[][] data = { 
	            { "Kundan Kumar Jha", "4031", "CSE" }, 
	            { "Anand Jha", "6014", "IT" } 
	        }; 
	  
	        // Column Names 
	        String[] columnNames = { "Name", "Roll Number", "Department" }; 
	  
	        // Initializing the JTable
	        
	        JTable j = new JTable(new DefaultTableModel(data,columnNames));
	        
	        j.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                jTable1MouseClicked(evt);
	            }

				private void jTable1MouseClicked(MouseEvent evt) {
				
					  DefaultTableModel model = (DefaultTableModel)j.getModel();
					  int selectedRowIndex = j.getSelectedRow();
					  System.out.println(selectedRowIndex);
					  System.out.println(model.getValueAt(selectedRowIndex, 0).toString());
					  System.out.println(model.getValueAt(selectedRowIndex, 1).toString());
					  System.out.println(model.getValueAt(selectedRowIndex, 2).toString());
					  model.setValueAt("mod", selectedRowIndex, 0);
					  model.setValueAt("mod", selectedRowIndex, 1);
					  model.setValueAt("mod", selectedRowIndex, 2);
				}

	        });
	       //JTable j = new JTable(data, columnNames); 
	        j.setBounds(30, 40, 200, 300); 
	        
	        //to add a row
	        DefaultTableModel model = (DefaultTableModel) j.getModel();
	        model.addRow(new String[]{"Column 1", "Column 2", "Column 3"});
	        //model.removeRow(2);
	        
	        // adding it to JScrollPane 
	        JScrollPane sp = new JScrollPane(j); 
	        f.add(sp); 
	        // Frame Size 
	        f.setSize(500, 200); 
	        // Frame Visible = true 
	        f.setVisible(true); 
	        f.show();
	        
	        */
		//new ModInterface(12124541);
		
	}
}



