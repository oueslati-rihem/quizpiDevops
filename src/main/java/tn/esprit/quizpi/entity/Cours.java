package tn.esprit.quizpi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity

public class Cours implements Serializable {

    @Id
    Long idC ;
    String title ;
    String path ;
    @JoinColumn(name = "user_id")

    @ManyToOne
    User user;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="cours")
    private Set<Quiz> Quizs;


}

