package com.example.setinj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext con = new ClassPathXmlApplicationContext("applicationCont.xml");
        Stud s = (Stud) con.getBean("s1");
        System.out.println(s);
    }
    
}
