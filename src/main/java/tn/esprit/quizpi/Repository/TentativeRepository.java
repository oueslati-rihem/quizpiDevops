package tn.esprit.quizpi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.quizpi.entity.Tentative;

import java.util.List;
import java.util.Set;

@Repository
public interface TentativeRepository extends JpaRepository<Tentative,Long> {
    List<Tentative> findByUserIdUAndQuizIdQ(long userId, long quizId);}
