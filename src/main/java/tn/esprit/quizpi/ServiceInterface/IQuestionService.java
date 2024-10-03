package tn.esprit.quizpi.ServiceInterface;

import tn.esprit.quizpi.entity.Question;
import tn.esprit.quizpi.entity.Quiz;

import java.util.List;

public interface IQuestionService {
    Question addQuestion(Question Question);

    void deleteQuestion(Long id) ;

    List<Question> retrieveAllQuestionByQuizID(Long QuizId);
    void deleteQuestionsByQuizId(Long QuizId);
}
