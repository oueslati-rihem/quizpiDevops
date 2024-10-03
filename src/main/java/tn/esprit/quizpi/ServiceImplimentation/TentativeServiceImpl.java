package tn.esprit.quizpi.ServiceImplimentation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.quizpi.Repository.TentativeRepository;
import tn.esprit.quizpi.ServiceInterface.ITentativeService;
import tn.esprit.quizpi.entity.Quiz;
import tn.esprit.quizpi.entity.Tentative;
import tn.esprit.quizpi.entity.User;

import java.util.List;

@Service
@AllArgsConstructor
public class TentativeServiceImpl implements ITentativeService {
    TentativeRepository tentativeRepository;


    @Override
    public List<Tentative> getTentativeByUserIdAndQuizId(long userId, long quizId) {
        return tentativeRepository.findByUserIdUAndQuizIdQ(userId,quizId) ;   }

    @Override
    public Tentative saveTentative(Tentative tentative) {

        return tentativeRepository.save(tentative);

    }




}
