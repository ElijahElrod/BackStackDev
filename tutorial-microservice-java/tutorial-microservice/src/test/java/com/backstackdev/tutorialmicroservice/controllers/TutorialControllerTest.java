package com.backstackdev.tutorialmicroservice.controllers;

import com.backstackdev.tutorialmicroservice.models.Tutorial;
import com.backstackdev.tutorialmicroservice.repositories.TutorialRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TutorialControllerTest {

    @Mock
    TutorialRepository tutorialRepository;

    @InjectMocks
    TutorialController tutorialController;

    @Test
    public void testGetTutorialById() {
        // Given
        Tutorial tutorial = new Tutorial(0,"Introduction to Microservices","Elijah E","An introductory guide to developing microservices in Java");
        // When
        when(tutorialRepository.getTutorialByTutorialId((long) 0)).thenReturn(tutorial);
        // Then
        ResponseEntity<Tutorial> tutorialGoodResponseEntity = tutorialController.getTutorialById((long) 0);
        ResponseEntity<Tutorial> tutorialBadResponseEntity = tutorialController.getTutorialById((long) 1);
        // Outcome 1, SUCCESS
        assertThat(tutorialGoodResponseEntity.getBody()).isNotNull();
        assertThat(tutorialGoodResponseEntity.getStatusCodeValue()).isEqualTo(200);
        // Outcome 2, FAILED
        assertThat(tutorialBadResponseEntity.getBody()).isNull();
        assertThat(tutorialBadResponseEntity.getStatusCodeValue()).isEqualTo(400);
    }

    @Test
    public void testCreateTutorial() {
        //Given
        Tutorial tutorial = new Tutorial(0,"Introduction to Microservices","Elijah E","An introductory guide to developing microservices in Java");
        // When
        when(tutorialRepository.save(any(Tutorial.class))).thenReturn(tutorial);
        // Then
        ResponseEntity<Long> tutorialResponseEntity = tutorialController.createTutorial(tutorial);
        assertThat(tutorialResponseEntity.getBody()).isEqualTo(0);
        assertThat(tutorialResponseEntity.getStatusCodeValue()).isEqualTo(200);
    }
    @Test
    public void testDeleteTutorial() {
        // Given
        Tutorial tutorial = new Tutorial(0,"Introduction to Microservices","Elijah E","An introductory guide to developing microservices in Java");
        //When
        when(tutorialRepository.getTutorialByTutorialId((long) 0)).thenReturn(tutorial);
        //Then
        ResponseEntity<String> tutorialGoodResponseEntity = tutorialController.deleteTutorial((long) 0);
        ResponseEntity<String> tutorialBadResponseEntity = tutorialController.deleteTutorial((long) 1);
        //Outcome 1, SUCCESS
        assertThat(tutorialGoodResponseEntity.getBody()).isEqualTo("Deleted Tutorial With ID: 0");
        assertThat(tutorialGoodResponseEntity.getStatusCodeValue()).isEqualTo(200);
        // Outcome 2, FAILED
        assertThat(tutorialBadResponseEntity.getBody()).isEqualTo("No Tutorial With ID: 1");
        assertThat(tutorialBadResponseEntity.getStatusCodeValue()).isEqualTo(400);
    }

}
