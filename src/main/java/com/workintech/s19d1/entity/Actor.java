package com.workintech.s19d1.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate birthDate;

    @ManyToMany
    @JoinTable(
            name = "movie_actor",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);

        if (!movie.getActors().contains(this)) {
            movie.getActors().add(this);
        }
    }
}