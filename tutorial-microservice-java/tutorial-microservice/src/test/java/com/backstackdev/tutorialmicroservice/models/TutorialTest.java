package com.backstackdev.tutorialmicroservice.models;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TutorialTest {

    @Test
    public void testTutorialIdSetterAndGetter() {
        Tutorial tutorial = new Tutorial(0,"Introduction to Microservices","Elijah E","An introductory guide to developing microservices in Java");
        tutorial.setTutorialId(42);
        assertThat(tutorial.getTutorialId()).isEqualTo(42);
    }


    @Test
    public void testTutorialTitleSetterAndGetter() {
        Tutorial tutorial = new Tutorial("Introduction to Microservices","Elijah E","An introductory guide to developing microservices in Java");
        tutorial.setTutorialTitle("BackStackDev Microservices Course");
        assertThat(tutorial.getTutorialTitle()).isEqualTo("BackStackDev Microservices Course");
    }

    @Test
    public void testTutorialAuthorSetterAndGetter() {
        Tutorial tutorial = new Tutorial("Introduction to Microservices","Elijah E","An introductory guide to developing microservices in Java");
        tutorial.setTutorialAuthor("BackStackDev");
        assertThat(tutorial.getTutorialAuthor()).isEqualTo("BackStackDev");
    }

    @Test
    public void testTutorialDescriptionSetterAndGetter() {
        Tutorial tutorial = new Tutorial("Introduction to Microservices","Elijah E","An introductory guide to developing microservices in Java");
        tutorial.setTutorialDescription("A BackStackDev Microservices Tutorial");
        assertThat(tutorial.getTutorialDescription()).isEqualTo("A BackStackDev Microservices Tutorial");
    }

}
