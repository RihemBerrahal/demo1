package com.example.demo.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@ToString
@Table(name = "reclamation" )
public class Reclamation  implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "dis", nullable = false)
    String dis ;
    @Column(name = "datedujour", nullable = false)
    String datedujour;
    @Column(name = "reponse")
    String reponse;
    String dateduvol;
    String billet;
    String numeroduvol;
    int iduser;
    String typederec;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
