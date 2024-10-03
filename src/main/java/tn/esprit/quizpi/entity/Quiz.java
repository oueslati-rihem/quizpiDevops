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

public class Quiz implements Serializable {
    @Id

    Long idQ;
    String title ;
    @ManyToOne
    @JoinColumn(name = "Cours_id")
    @JsonIgnore
    Cours cours;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="quiz")
    private Set<Question> Questions;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="quiz")
    private Set<Tentative> Tentatives;
}
