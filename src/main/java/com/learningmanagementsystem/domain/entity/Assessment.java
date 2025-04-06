package com.learningmanagementsystem.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "assessments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "lesson_id", nullable = false)
    private Integer lessonId;

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Column(name = "created_at", columnDefinition = "DATETIME2 DEFAULT GETDATE()")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY) // by default fetch type is eager so even if you type @JsonIgnore..it will execute the select statement. @JsonIgnore only prevent the Cycle.
    @JoinColumn(name = "lesson_id", insertable = false, updatable = false) // even if you type some @Query in the Repo. you must also type FetchType.LAZY.
    @JsonIgnore // Update later
    private Lesson lesson;

    @OneToMany(mappedBy = "assessment", fetch = FetchType.LAZY)
    @JsonIgnore // update later
    private List<Question> questions;

   }