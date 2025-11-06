package com.cu.partb;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // CREATE
        Student s1 = new Student("Rohit Kumar", "rohit@example.com", "B.Tech CSE");
        session.save(s1);

        tx.commit();

        // READ
        List<Student> students = session.createQuery("from Student", Student.class).list();
        System.out.println("All Students:");
        students.forEach(System.out::println);

        session.close();
        HibernateUtil.shutdown();
    }
}
