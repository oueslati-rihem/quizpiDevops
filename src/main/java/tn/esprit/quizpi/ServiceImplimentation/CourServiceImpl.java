package tn.esprit.quizpi.ServiceImplimentation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.quizpi.Repository.CoursRepository;
import tn.esprit.quizpi.Repository.QuizRepository;
import tn.esprit.quizpi.ServiceInterface.IcourService;
import tn.esprit.quizpi.entity.Cours;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.quizpi.entity.Quiz;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourServiceImpl implements IcourService {
    CoursRepository coursrepo;
    QuizRepository quizrepo;
    @Override
    public List<Cours> retrieveAllCours() {
        return coursrepo.findAll();
    }

    @Override
    public Cours addCours(Cours cours) {
        return coursrepo.save(cours);
    }

    @Override
    public Cours updateCours(Cours cours) {
        return coursrepo.save(cours);
    }

    @Override
    public void deleteCours(Long id) {coursrepo.deleteById(id);
    }

    @Override
    public Cours retrieveCours(Long idC) {
        return coursrepo.findById(idC).orElse(null);
    }
    @Override
    public List<Cours> retrieveAllCoursByUserId(Long userId) {
        return coursrepo.findByUser_idU(userId);
    }
    @Override
    public void affecterQuizAuCours(Long coursId, Long quizId) {
        Cours cours = coursrepo.findById(coursId).orElseThrow(() -> new IllegalArgumentException("Cours non trouvé"));
        Quiz quiz = quizrepo.findById(quizId).orElseThrow(() -> new IllegalArgumentException("Quiz non trouvé"));

        // Initialiser la collection de Quizs si elle est null
        if (cours.getQuizs() == null) {
            cours.setQuizs(new HashSet<>());
        }

        // Initialiser la collection de Questions si elle est null
        if (quiz.getQuestions() == null) {
            quiz.setQuestions(new HashSet<>());
        }

        // Affecter le cours au quiz et vice versa
        cours.getQuizs().add(quiz);
        quiz.setCours(cours);

        // Enregistrer les modifications dans la base de données
        coursrepo.save(cours);
        quizrepo.save(quiz);
    }
}