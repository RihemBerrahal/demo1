package com.example.demo.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Data@ToString
@Table(name = "fidelys")
@EqualsAndHashCode
public class Fidelys implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fidelys_seq")
    @SequenceGenerator(sequenceName = "fidelys_seq", allocationSize = 1, name = "fidelys_seq")
    int id;
    String firstname;
    String secondname;
    String birthdaydate;
    String email;
    String password;
    String sexe;
    String nationalite;
    String cin;
    String typeadhesion;
    String autrefidelisation;
    String idmmbre1;
    String idmmbre2;
    String idmmbre3;
    String adresse;
    String ville;
    String tel;
    String societe;
    String fonction;
    String codepostal;
    String telpro;
    String fax;
    String status;
    Double solde;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    private Boolean locked = false;
    private Boolean enabled =false;





    public Fidelys() {
    }

    /*public Fidelys(String firstname, String secondname, String birthdaydate, String email, String password) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.birthdaydate = birthdaydate;
        this.email = email;
        this.password = password;
    }*/

    public Fidelys(int id, String firstname, String secondname, String birthdaydate, String email, String password, String sexe, String nationalite, String cin, String typeadhesion, String autrefidelisation, String idmmbre1, String idmmbre2, String idmmbre3, String adresse, String ville, String tel, String societe, String fonction, String codepostal, String telpro, String fax) {
        this.id = id;
        this.firstname = firstname;
        this.secondname = secondname;
        this.birthdaydate = birthdaydate;
        this.email = email;
        this.password = password;
        this.sexe = sexe;
        this.nationalite = nationalite;
        this.cin = cin;
        this.typeadhesion = typeadhesion;
        this.autrefidelisation = autrefidelisation;
        this.idmmbre1 = idmmbre1;
        this.idmmbre2 = idmmbre2;
        this.idmmbre3 = idmmbre3;
        this.adresse = adresse;
        this.ville = ville;
        this.tel = tel;
        this.societe = societe;
        this.fonction = fonction;
        this.codepostal = codepostal;
        this.telpro = telpro;
        this.fax = fax;

    }

    public Fidelys(String firstname, String secondname, String birthdaydate, String email, String password, String adresse, String ville, String tel, String societe, String fonction, String codepostal, String telpro, String fax) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.birthdaydate = birthdaydate;
        this.email = email;
        this.password = password;
        this.adresse = adresse;
        this.ville = ville;
        this.tel = tel;
        this.societe = societe;
        this.fonction = fonction;
        this.codepostal = codepostal;
        this.telpro = telpro;
        this.fax = fax;
    }

    public Fidelys(Fidelys fidelys) {
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(authority);
        return authorities;
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

}
