package tn.esprit.quizpi.ServiceInterface;

import tn.esprit.quizpi.entity.Cours;

import java.util.List;
import java.util.Optional;

public interface IcourService {
    List<Cours> retrieveAllCours();
    Cours addCours(Cours cours);
    Cours updateCours (Cours cour);

    void deleteCours(Long id);
     Cours retrieveCours(Long idC);
    List<Cours> retrieveAllCoursByUserId(Long userId);
    public void affecterQuizAuCours(Long coursId, Long quizId);

}
