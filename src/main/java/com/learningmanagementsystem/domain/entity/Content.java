//package com.learningmanagementsystem.domain.entity;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "content")
//public class Content {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Integer id;
//
//    @Column(name = "lesson_id", nullable = false)
//    private Integer lessonId;
//
//    @Column(name = "content_url", columnDefinition = "TEXT")
//    private String contentUrl;
//
//    @Column(name = "content_type", length = 20, nullable = false)
//    private String contentType;
//
//    @ManyToOne
//    @JoinColumn(name = "lesson_id", insertable = false, updatable = false)
//    @JsonBackReference
//    private Lesson lesson;
//
//    // Getters and Setters
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Integer getLessonId() {
//        return lessonId;
//    }
//
//    public void setLessonId(Integer lessonId) {
//        this.lessonId = lessonId;
//    }
//
//    public String getContentUrl() {
//        return contentUrl;
//    }
//
//    public void setContentUrl(String contentUrl) {
//        this.contentUrl = contentUrl;
//    }
//
//    public String getContentType() {
//        return contentType;
//    }
//
//    public void setContentType(String contentType) {
//        this.contentType = contentType;
//    }
//
//    public Lesson getLesson() {
//        return lesson;
//    }
//
//    public void setLesson(Lesson lesson) {
//        this.lesson = lesson;
//    }
//}