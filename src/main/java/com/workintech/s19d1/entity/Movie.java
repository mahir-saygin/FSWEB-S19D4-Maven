package com.workintech.s19d1.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String directorName;

    private int rating;

    private LocalDate releaseDate;

    @ManyToMany(mappedBy = "movies")
    private List<Actor> actors = new ArrayList<>();

    public void addActor(Actor actor) {
        actors.add(actor);

        if (!actor.getMovies().contains(this)) {
            actor.getMovies().add(this);
        }
    }
}