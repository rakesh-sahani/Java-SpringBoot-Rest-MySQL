package com.example.test.demo.Model;


import javax.persistence.*;

@Entity
@Table(name="test")
public class testModel {

    public testModel() {
        super();
    }


    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)


    private Integer tID;
    private String tName;

    public Integer gettID() {
        return tID;
    }

    public void settID(Integer tID) {
        this.tID = tID;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

}
