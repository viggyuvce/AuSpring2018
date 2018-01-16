package com.accolite.au.hibernate.assignment;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
        Student std1 = new Student();
        std1.setSid(1);
        std1.setName("Vignesh");
        std1.setAge(21);
        std1.setMarks(87);
        
        Laptop ltp1 = new Laptop();
        ltp1.setLid(201);
        ltp1.setBrand("Dell");
        ltp1.setModel("Vostro");
        ltp1.setPrice(23000);
        
        std1.setLtp(ltp1);
        
        Expenses e1 = new Expenses();
        e1.setBillId(101);
        e1.setDescription("Cycle");
        e1.setAmount(15000);
        
        Expenses e2 = new Expenses();
        e2.setBillId(102);
        e2.setDescription("Theatre");
        e2.setAmount(150);
        
        
        List<Expenses> exps = new ArrayList<Expenses>();
        exps.add(e1);
        exps.add(e2);
        
        std1.setExps(exps);
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class).addAnnotatedClass(Expenses.class);
        SessionFactory sf = con.buildSessionFactory();
        
        Session session1 = sf.openSession();
        
        Transaction tx = session1.beginTransaction();
        session1.save(std1);
        session1.save(ltp1);
        session1.save(e1);
        session1.save(e2);
        tx.commit();
        session1.close();
        
        Session session2 = sf.openSession();
        tx = session2.beginTransaction();
        Student std = session2.get(Student.class, 1);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Name: "+std.getName());
        System.out.println("Student Id: "+std.getSid());
        System.out.println("Age :"+std.getAge());
        System.out.println("Marks :"+std.getMarks());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Expenses by "+std.getName());
        
        List<Expenses> resultExps = std.getExps();
        for(Expenses exp : resultExps) {
        	System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        	System.out.println("Billid :"+exp.getBillId());
        	System.out.println("Description: "+exp.getDescription());
        	System.out.println("Amount: "+exp.getAmount());
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Laptop owned by "+std.getName());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
        Laptop ltp = std.getLtp();
        
        System.out.println("Laptop Id: "+ltp.getLid());
        System.out.println("Brand :"+ltp.getBrand());
        System.out.println("Model :"+ltp.getModel());
        System.out.println("Price :"+ltp.getPrice());
        
        
    }
}
