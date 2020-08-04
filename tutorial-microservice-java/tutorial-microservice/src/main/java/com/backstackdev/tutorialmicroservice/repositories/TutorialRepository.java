package com.backstackdev.tutorialmicroservice.repositories;

import com.backstackdev.tutorialmicroservice.models.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface TutorialRepository  extends JpaRepository<Tutorial, Long> {

    Tutorial getTutorialByTutorialId(Long id);
    ArrayList<Tutorial> getAllByTutorialAuthor(String author);

}
