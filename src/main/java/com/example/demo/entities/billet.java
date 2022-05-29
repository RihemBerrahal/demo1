package com.example.demo.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
@Table(name = "billet" )
public class billet {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "numeroDuVol", referencedColumnName = "numeroDuVol")
    private Vols vols ;




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public Vols getVols() {
        return vols;
    }

    public void setVols(Vols vols) {
        this.vols = vols;
    }
}
