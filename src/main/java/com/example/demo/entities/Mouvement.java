package com.example.demo.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@ToString
@Table(name = "MOUVEMENTs")

public class Mouvement {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String transaction;
    private int credit;
    private int debit;
    private int iduser;
  private String dateajout;
   private  int milesqalifiant;

    public Mouvement(String transaction, int credit, int debit, int iduser, String dateajout, int milesqalifiant) {
        this.transaction = transaction;
        this.credit = credit;
        this.debit = debit;
        this.iduser = iduser;
        this.dateajout = dateajout;
        this.milesqalifiant = milesqalifiant;
    }

    public Mouvement() {

    }
}