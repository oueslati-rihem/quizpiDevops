package tn.esprit.quizpi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.quizpi.entity.Cours;
import tn.esprit.quizpi.entity.Quiz;

import java.util.List;
@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
   List<Quiz> findByCoursIdC(Long coursIdC);


}
