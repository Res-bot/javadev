package com.example.constinj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        ApplicationContext con1 = new ClassPathXmlApplicationContext("applicationCon.xml");
        Stud1 st = (Stud1) con1.getBean("s1a");
        System.out.println(st);
    }
    
}
