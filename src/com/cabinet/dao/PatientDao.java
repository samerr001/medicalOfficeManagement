package com.cabinet.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.dom4j.Branch;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.cabinet.bean.Patient;
import com.cabinet.bean.RendezVous;

public class PatientDao {

	private static String fileName = "cabinet.xml";

	public static void create(Patient p) {
		try {
			
			 File inputFile = new File(fileName);
	         SAXReader reader = new SAXReader();
	         Document document = reader.read( inputFile );
	         
	         Element root = document.getRootElement();
	         Element patient = root.addElement("patient")
	 	            .addAttribute("cin", Integer.toString(p.getCin()));
	         patient.addElement("nom").addText(p.getNom());
	         patient.addElement("prenom").addText(p.getPrenom());
	         patient.addElement("dateDeNaissance").addText(p.getDateNaissance());
	         patient.addElement("mobile").addText(Integer.toString(p.getMobile()));
	         patient.addElement("email").addText(p.getEmail());
	         patient.addElement("genre").addText(p.getGender());
	         patient.addElement("address").addText(p.getAddress());
	         patient.addElement("metier").addText(p.getMetier());
	         patient.addElement("maladie").addText(p.getMaladie());
	         Element historique = patient.addElement("historique");
	         for (RendezVous r : p.getRendezVous()) {
	        	 Element rendezVous = historique.addElement("rendezVous").addAttribute("type", r.getType());
	        	 rendezVous.addElement("date").addText(r.getDate()); 
	        	 rendezVous.addElement("prix").addText(Integer.toString(r.getPrix()));
	         }
	         
	         FileWriter out = new FileWriter(fileName);
	         document.write(out);
	         out.close();
	         
		}catch(Exception e) {
			
		}
	}
	
	public static Vector<Patient> findAll(){
		
		Vector<Patient> v = new Vector<Patient>();
		
		try {
		
		File inputFile = new File("cabinet.xml");
        SAXReader reader = new SAXReader();
        Document document = reader.read( inputFile );
        
        Element classElement = document.getRootElement();
        List<Node> nodes = document.selectNodes("/patients/patient" );
        for (Node node : nodes) {
        	Patient p = new Patient(
        			Integer.parseInt(node.valueOf("@cin")),
        			node.selectSingleNode("nom").getText(),
        			node.selectSingleNode("prenom").getText(),
        			node.selectSingleNode("dateDeNaissance").getText(),
        			Integer.parseInt(node.selectSingleNode("mobile").getText()),
        			node.selectSingleNode("email").getText(),
        			node.selectSingleNode("address").getText(),
        			node.selectSingleNode("metier").getText(),
        			node.selectSingleNode("genre").getText(),
        			node.selectSingleNode("maladie").getText()
        			);
        	List<Node> historique = node.selectSingleNode("historique").selectNodes("/rendezVous");
        	
        	for (Node h: historique) {
        		p.AppendeRendezVous(new RendezVous
        				(h.selectSingleNode("date").getText(),
        				Integer.parseInt(h.selectSingleNode("prix").getText()),
        				h.valueOf("@type")
        				));
        	}
        	
        	v.add(p);
        }
        
		}catch(Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	
	public static Patient findById(int cin) {
		Patient p = new Patient();
		
		try {
		
			File inputFile = new File("cabinet.xml");
	        SAXReader reader = new SAXReader();
	        Document document = reader.read( inputFile );
	        
	        Node node = document.selectSingleNode(("/patients/patient[@cin='"+cin+"']"));
	        
	        if(node.hasContent()) {
	        	
	        	p.setCin(Integer.parseInt(node.valueOf("@cin")));
	        	p.setNom(node.selectSingleNode("nom").getText());
	        	p.setPrenom(node.selectSingleNode("prenom").getText());
	        	p.setDateNaissance(node.selectSingleNode("dateDeNaissance").getText());
	        	p.setMobile(Integer.parseInt(node.selectSingleNode("mobile").getText()));
	        	p.setEmail(node.selectSingleNode("email").getText());
	        	p.setAddress(node.selectSingleNode("address").getText());
	        	p.setMetier(node.selectSingleNode("metier").getText());
	        	p.setGender(node.selectSingleNode("genre").getText());
	        	p.setMaladie(node.selectSingleNode("maladie").getText());
	        	p.resetRendezVous();
	        	
	        	
	        	List<Node> historique = node.selectSingleNode("historique").selectNodes("rendezVous");
	        	
	        	for (Node h: historique) {
	        		p.AppendeRendezVous(new RendezVous
	        				(h.selectSingleNode("date").getText(),
	        				Integer.parseInt(h.selectSingleNode("prix").getText()),
	        				h.valueOf("@type")
	        				));
	        	}
	        }
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return p;
			
	   }
	


	public static void updatePatient(Patient p) {
		try {
			
	         File inputFile = new File(fileName);
	         SAXReader reader = new SAXReader();
	         Document document = reader.read( inputFile );
	         
	         
	         Element classElement = document.getRootElement();
	         
	        Node node = document.selectSingleNode(("/patients/patient[@cin='"+p.getCin()+"']"));
	         
	        Element element = (Element)node;
	        
	        Iterator<Element> iterator = element.elementIterator("mobile");
	        while(iterator.hasNext()) {
	        	Element selement = (Element)iterator.next();
	        	selement.setText(Integer.toString(p.getMobile()));
	        }
	         iterator = element.elementIterator("email");
	        while(iterator.hasNext()) {
	        	Element selement = (Element)iterator.next();
	        	selement.setText(p.getEmail());
	        }
	        
	        iterator = element.elementIterator("address");
	        while(iterator.hasNext()) {
	        	Element selement = (Element)iterator.next();
	        	selement.setText(p.getAddress());
	        }
	        
	        iterator = element.elementIterator("metier");
	        while(iterator.hasNext()) {
	        	Element selement = (Element)iterator.next();
	        	selement.setText(p.getMetier());
	        }
	        
	        
	        Node historique = node.selectSingleNode("historique");
	        
	        		List<Node> lr = historique.selectNodes("rendezVous");
	        		
	        		for (Node n: lr) { 
	        			n.detach();
	        		}
	        	
	        		for (RendezVous r : p.getRendezVous()) {
	        			
	   	        	 Element rendezVous = ((Element) historique).addElement("rendezVous").addAttribute("type", r.getType());
	   	        	 rendezVous.addElement("date").addText(r.getDate()); 
	   	        	 rendezVous.addElement("prix").addText(Integer.toString(r.getPrix()));
	   	         }
	        		
	         	//Committing change
	         FileWriter out = new FileWriter(fileName);
	         document.write(out);
	         out.close();
	         
	      } catch (DocumentException e) {
	         e.printStackTrace();
	      } 
			catch (UnsupportedEncodingException e) {         
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
		}
	
	public static void deletePatient(int cin) {
	
		try {
			
			File inputFile = new File(fileName);
	        SAXReader reader = new SAXReader();
	        Document document = reader.read( inputFile );
	        
	        Node node = document.selectSingleNode(("/patients/patient[@cin='"+cin+"']"));
	        node.detach();
	        
	        FileWriter out = new FileWriter(fileName);
	         document.write(out);
	         out.close();
	        
	        
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
}