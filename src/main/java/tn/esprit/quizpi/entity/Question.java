package tn.esprit.quizpi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Question implements Serializable {
    @Id

    Long idques;
    String question;
    String rep1 ;
    String rep2 ;
    String rep3 ;
    String repCorrect ;

    @JoinColumn(name = "quiz_id")
    @ManyToOne
    @JsonIgnore
    Quiz quiz;




}
