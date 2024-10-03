package tn.esprit.quizpi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.quizpi.entity.Question;
import tn.esprit.quizpi.entity.Quiz;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {

    List<Question> findByQuizIdQ(Long quizIdQ);
    void deleteByQuizIdQ(Long quizIdQ); }

