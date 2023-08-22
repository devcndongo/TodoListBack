package com.example.TodoListBack.entities;

import com.example.TodoListBack.entities.Enum.Categorie;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    @Enumerated(EnumType.STRING)
    private Categorie categorie;

    private String commentaire;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date debut;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date fin;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date deadlines;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Task() {
        this.debut = new Date();
    }
}
