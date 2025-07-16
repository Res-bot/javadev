package com.example.constinj;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

public class Cert1 {

    int cid;
    String cName;

    public Cert1(String cName, int cid){
        cName = this.cName;
        
    }

    @Override
    public String toString() {
        return "Certificate [cid= " + cid + " cName= " + cName + "]";
    }

    
}
