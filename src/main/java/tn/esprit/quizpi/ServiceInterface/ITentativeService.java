package tn.esprit.quizpi.ServiceInterface;


import tn.esprit.quizpi.entity.Quiz;
import tn.esprit.quizpi.entity.Tentative;
import tn.esprit.quizpi.entity.User;

import java.util.List;


public interface ITentativeService {
    List<Tentative> getTentativeByUserIdAndQuizId(long userId, long quizId);
    Tentative saveTentative(Tentative tentative);
}
