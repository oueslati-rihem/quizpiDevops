package tn.esprit.quizpi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class User implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idU ;
    @OneToMany(mappedBy ="user")
    @JsonIgnore
    Set <Cours> cours ;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<Tentative> tentatives;


}
