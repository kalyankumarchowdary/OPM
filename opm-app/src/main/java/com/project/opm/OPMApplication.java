package com.project.opm;

import com.project.opm.entity.TenantEntity;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.sql.Date;


public class OPMApplication {
    public static void main( String[] args ){

        LocalDate currentDate = LocalDate.now();
        LocalDate currentDatePlusMonth = currentDate.plusMonths(1);

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(TenantEntity.class);

        //Create session factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        //Initialize the session object
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        TenantEntity tenantEntity = new TenantEntity();

        tenantEntity.setTenantId("KALYAN");
        tenantEntity.setAccount("NETFLIX");
        tenantEntity.setEmail("kalyankumar1013@gmail.com");
        tenantEntity.setPassword("password123");
        tenantEntity.setStatus("CREATED");
        tenantEntity.setCreatedDate(Date.valueOf(currentDate));
        tenantEntity.setExpirationDate(Date.valueOf(currentDatePlusMonth));

        System.out.println("TENANT_ID" +": "+tenantEntity.getTenantId());
        System.out.println("ACCOUNT" +": "+tenantEntity.getAccount());
        System.out.println("EMAIL" +": "+tenantEntity.getEmail());
        //System.out.println("PASSWORD" +": "+tenantEntity.getPassword());
        System.out.println("STATUS" +": "+tenantEntity.getStatus());
        System.out.println("CREATED_DATE"+": "+tenantEntity.getCreatedDate());
        System.out.println("EXPIRATION_DATE"+": "+tenantEntity.getExpirationDate());

        session.save(tenantEntity);
        tx.commit();
    }

}