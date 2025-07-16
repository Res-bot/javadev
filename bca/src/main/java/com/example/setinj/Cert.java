package com.example.setinj;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cert {
    int cid;
    String cName;

    @Override
    public String toString() {
        return "Certificate [cid= " + cid + " cName= " + cName + "]";
    }
}
