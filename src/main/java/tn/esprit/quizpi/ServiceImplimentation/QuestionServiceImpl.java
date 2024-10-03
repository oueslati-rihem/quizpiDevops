package tn.esprit.quizpi.ServiceImplimentation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.quizpi.Repository.QuestionRepository;
import tn.esprit.quizpi.Repository.QuizRepository;
import tn.esprit.quizpi.ServiceInterface.IQuestionService;
import tn.esprit.quizpi.entity.Question;
import tn.esprit.quizpi.entity.Quiz;

import java.util.List;
@Service
@AllArgsConstructor
public class QuestionServiceImpl implements IQuestionService {
    QuestionRepository QuestionRepo;
    QuizRepository quizRepository;

    @Override
    public Question addQuestion(Question Question) {
        return QuestionRepo.save(Question);
    }

    @Override
    public void deleteQuestion(Long id) {QuestionRepo.deleteById(id);

    }




    @Override
    public List<Question> retrieveAllQuestionByQuizID(Long QuizId) {
        return QuestionRepo.findByQuizIdQ(QuizId);

    }

    @Override
    public void deleteQuestionsByQuizId(Long QuizId) {
        QuestionRepo.deleteByQuizIdQ(QuizId);

    }


}
