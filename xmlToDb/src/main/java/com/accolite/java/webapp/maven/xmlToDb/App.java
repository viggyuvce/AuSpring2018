package com.accolite.java.webapp.maven.xmlToDb;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class App 
{
    public static void main( String[] args ) throws ParserConfigurationException, SAXException, IOException, SQLException
    {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AU","root", "Superstar!2");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File xmlFile = new File("C:\\Users\\vignesh.b\\eclipse-workspace\\xmlToDb\\src\\main\\java\\com\\accolite\\java\\webapp\\maven\\xmlToDb\\college.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("student");
		
		String rollnum, name;
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		String query = "insert into student values (?,?)";
		for(int i=0;i<nList.getLength();++i) {
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			rollnum = eElement.getElementsByTagName("rollnum").item(0).getTextContent();
			name = eElement.getElementsByTagName("name").item(0).getTextContent();
			System.out.println("Rollnum :"+rollnum);
			System.out.println("Name: "+name);
			try {
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setString(1, rollnum);
				ps.setString(2,name);
				ps.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		connection.close();
		
    }
}
