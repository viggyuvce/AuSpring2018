package com.accolite.java.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class xmlParser {
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		List<Student> students = new ArrayList<Student>();
		
		File xmlFile = new File("./src/com/accolite/java/xml/college.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);
		FileWriter fw = new FileWriter("./src/com/accolite/java/xml/college.csv");
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("student");
		
		String rollnum, name;
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		Student student = new Student();
		for(int i=0;i<nList.getLength();++i) {
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			rollnum = eElement.getElementsByTagName("rollnum").item(0).getTextContent();
			name = eElement.getElementsByTagName("name").item(0).getTextContent();
			System.out.println("Rollnum :"+rollnum);
			System.out.println("Name: "+name);
			fw.append(rollnum);
			fw.append(",");
			fw.append(name);
			fw.append("\r\n");
		}
		fw.flush();
		fw.close();
	}
}
