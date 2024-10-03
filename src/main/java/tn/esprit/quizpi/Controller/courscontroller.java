package tn.esprit.quizpi.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.quizpi.ServiceInterface.IcourService;
import tn.esprit.quizpi.entity.Cours;
import tn.esprit.quizpi.entity.User;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cours")
@AllArgsConstructor
public class courscontroller {

    IcourService courService;
    @GetMapping("/retrieveAllCours")
    public List<Cours> retrieveAllCours() {
        return courService.retrieveAllCours();
    }
    @PostMapping("/addCours")
    public Cours addCours(@RequestBody Cours cours) {
        return courService.addCours(cours);
    }
    @PutMapping("/updateCours")
    public Cours updateCours(@RequestBody Cours cours) {
        return courService.updateCours(cours);
    }

    @GetMapping("/getcoursbyid/{numCours}")
    public Cours retrieveCours(@PathVariable("numCours")Long numCours) {
        return courService.retrieveCours(numCours);
    }
    @DeleteMapping("/deleteCours/{id}")
    public void deleteCours(@PathVariable("id") Long id) {
        courService.deleteCours(id);
    }
    @GetMapping("/getCoursByUserId/{userId}")
    public List<Cours> getAllCoursByUserId(@PathVariable Long userId) {
        return courService.retrieveAllCoursByUserId(userId);
    }

    @PostMapping("/cours/{coursId}/quiz/{quizId}")
    public ResponseEntity<String> affecterQuizAuCours(@PathVariable Long coursId, @PathVariable Long quizId) {
        courService.affecterQuizAuCours(coursId, quizId);
        return ResponseEntity.ok("Quiz affecté au cours avec succès.");
    }
}