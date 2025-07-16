package com.example.constinj;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

public class Stud1 {

    int id;
    String name;
    Cert1 cert;

    @Override
    public String toString() {
        return "Certificate [id= " + id + " Name= " + name + " Cert= " + cert + "]";
    }
    
}
