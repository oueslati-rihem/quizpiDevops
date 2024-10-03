package tn.esprit.quizpi.ServiceInterface;

import tn.esprit.quizpi.entity.Cours;
import tn.esprit.quizpi.entity.Quiz;

import java.util.List;

public interface IQuizService {

    Quiz addQuiz(Quiz Quiz);
    Quiz updateQuiz (Quiz Quiz);
    void deleteQuiz(Long id);
    List<Quiz> retrieveAllQuizByCourID(Long CourId);
    void  addQuestionToQuiz(Long quizId, long questionid);

}
