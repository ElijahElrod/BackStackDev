package com.backstackdev.tutorialmicroservice.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tutorials")
@Getter
@Setter
@AllArgsConstructor
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tutorialId;

    @Column(name = "author")
    private String tutorialAuthor;

    @Column(name = "title")
    private String tutorialTitle;

    @Column(name = "description")
    private String tutorialDescription;

    public Tutorial(String tutorialTitle, String tutorialAuthor, String tutorialDescription) {
        this.tutorialTitle = tutorialTitle;
        this.tutorialAuthor = tutorialAuthor;
        this.tutorialDescription = tutorialDescription;
    }
}
