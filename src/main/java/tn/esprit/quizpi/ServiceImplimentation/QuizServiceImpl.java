package tn.esprit.quizpi.ServiceImplimentation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.quizpi.Repository.QuestionRepository;
import tn.esprit.quizpi.Repository.QuizRepository;
import tn.esprit.quizpi.ServiceInterface.IQuizService;
import tn.esprit.quizpi.entity.Question;
import tn.esprit.quizpi.entity.Quiz;

import java.util.List;
@Service
@AllArgsConstructor
public class QuizServiceImpl implements IQuizService {
    QuizRepository Quizrepo;
    QuestionRepository QuestionRepo;

    @Override
    public Quiz addQuiz(Quiz Quiz) {
        return Quizrepo.save(Quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz Quiz) {
        return Quizrepo.save(Quiz) ;
    }

    @Override
    public void deleteQuiz(Long id) {
        Quizrepo.deleteById(id);
    }

    @Override
    public List<Quiz> retrieveAllQuizByCourID(Long CourId) {
        return Quizrepo.findByCoursIdC(CourId);
    }

    @Override
    public void addQuestionToQuiz(Long quizId, long questionId) {
        Quiz quiz = Quizrepo.findById(quizId)
                .orElseThrow(() -> new IllegalArgumentException("Quiz not found with id: " + quizId));

        Question question = QuestionRepo.findById(questionId)
                .orElseThrow(() -> new IllegalArgumentException("Question not found with id: " + questionId));

        question.setQuiz(quiz);
        QuestionRepo.save(question);
    }
}