package com.example.setinj;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Stud {
    int id;
    String name;
    Cert c;

    @Override
    public String toString() {
        return "Certificate [id= " + id + " Name= " + name + " Cert= " + c + "]";
    }
}
