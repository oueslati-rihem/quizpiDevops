package tn.esprit.quizpi.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.quizpi.ServiceInterface.ITentativeService;
import tn.esprit.quizpi.entity.Quiz;
import tn.esprit.quizpi.entity.Tentative;
import tn.esprit.quizpi.entity.User;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tentatives")
@AllArgsConstructor
public class TentativeController {


       ITentativeService tentativeService;


        @PostMapping("/save")
        public ResponseEntity<Tentative> saveTentative(@RequestBody Tentative tentative) {
            Tentative savedTentative = tentativeService.saveTentative(tentative);
            return new ResponseEntity<>(savedTentative, HttpStatus.CREATED);
        }
    @GetMapping("/{userId}/{quizId}")
    public ResponseEntity<List<Tentative>> getTentativesByUserIdAndQuizId(
            @PathVariable long userId,
            @PathVariable long quizId) {
        List<Tentative> tentatives = tentativeService.getTentativeByUserIdAndQuizId(userId, quizId);
        if (tentatives.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(tentatives, HttpStatus.OK);
        }
    }



}
