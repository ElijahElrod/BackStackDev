package com.backstackdev.tutorialmicroservice.controllers;

import com.backstackdev.tutorialmicroservice.models.Tutorial;
import com.backstackdev.tutorialmicroservice.repositories.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tutorials")
public class TutorialController {

    private TutorialRepository tutorialRepository;

    @Autowired
    public TutorialController(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }

    @GetMapping(value = "/tutorial")
    public ResponseEntity<Tutorial> getTutorialById(@RequestParam Long id) {
        Tutorial tutorial = tutorialRepository.getTutorialByTutorialId(id);
        if (tutorial != null) {
            return new ResponseEntity<>(tutorial, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/create-tutorial")
    public ResponseEntity<Long> createTutorial(@RequestBody Tutorial tutorial) {
        Tutorial tutorialCreated = tutorialRepository.save(tutorial);
        return new ResponseEntity<>(tutorialCreated.getTutorialId(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-tutorial")
    public ResponseEntity<String> deleteTutorial(@RequestParam Long id) {
        Tutorial tutorialToDelete = tutorialRepository.getTutorialByTutorialId(id);
        if (tutorialToDelete != null) {
            tutorialRepository.delete(tutorialToDelete);
            return new ResponseEntity<>("Deleted Tutorial With ID: " + id, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Tutorial With ID: " + id, HttpStatus.BAD_REQUEST);
        }
    }
}
