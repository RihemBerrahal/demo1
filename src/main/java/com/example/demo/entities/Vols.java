package com.example.demo.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data@ToString
@Table(name = "vols")
public class Vols implements Serializable {
    @Id
    @Column(name = "numeroduvol")
    String numeroDuVol;
    String dateDuvol;
    @OneToOne(mappedBy = "vols")
    private billet billet;

    public Vols() {

    }


    public String getDateDuvol() {
        return dateDuvol;
    }

    public void setDateDuvol(String dateDuvol) {
        this.dateDuvol = dateDuvol;
    }

    String EscaleDepart;
    String EscaleArrive;
    String EtatDuVol;
    String DepartProgramme;
    String arrivep;
    String DepartEstime;
    String ArriveeEstimee;

    @Override
    public String toString() {
        return "Vols{" +
                "NumeroDuVol='" + numeroDuVol + '\'' +
                ", dateDuvol='" + dateDuvol + '\'' +
                ", EscaleDepart='" + EscaleDepart + '\'' +
                ", EscaleArrive='" + EscaleArrive + '\'' +
                ", EtatDuVol='" + EtatDuVol + '\'' +
                ", DepartProgrammé='" + DepartProgramme + '\'' +
                ", ArriveeProgrammee='" + arrivep + '\'' +
                ", DepartEstime='" + DepartEstime + '\'' +
                ", ArriveeEstimee='" + ArriveeEstimee + '\'' +
                '}';
    }

    public Vols(String numeroDuVol, String dateDuvol, String escaleDepart, String escaleArrive, String etatDuVol, String departProgrammé, String arriveeProgrammee, String departEstime, String arriveeEstimee) {
        numeroDuVol = numeroDuVol;
        this.dateDuvol = dateDuvol;
        EscaleDepart = escaleDepart;
        EscaleArrive = escaleArrive;
        EtatDuVol = etatDuVol;
        DepartProgramme = departProgrammé;
        arrivep = arriveeProgrammee;
        DepartEstime = departEstime;
        ArriveeEstimee = arriveeEstimee;
    }
}
