package com.learningmanagementsystem.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "module_id", nullable = false)
    private Integer moduleId;

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Column(name = "content_url", columnDefinition = "TEXT")
    private String contentUrl;

    @Column(name = "content_type", length = 20, nullable = false)
    private String contentType;

//    @Column(name = "order", nullable = false)
//    private Integer order;

    @ManyToOne
    @JoinColumn(name = "module_id", insertable = false, updatable = false)
    @JsonIgnore
    private Module module;

//    @OneToMany(mappedBy = "lesson")
//    private List<Assessment> assessments;

//    @OneToMany(mappedBy = "lesson")
//    @JsonManagedReference
//    private List<Content> contents;


}