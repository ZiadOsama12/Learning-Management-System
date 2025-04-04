package com.learningmanagementsystem.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "progress")
public class Progress {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Integer id;
//
//    @Column(name = "user_id", nullable = false)
//    private Integer userId;
//
//    @Column(name = "course_id", nullable = false)
//    private Integer courseId;

    @EmbeddedId
    private ProgressKey progressKey;

    @Column(name = "completed_modules")
    private Integer completedModules;

    @Column(name = "completed_lessons")
    private Integer completedLessons;

    @Column(name = "progress_percentage")
    private Float progressPercentage;

    @Column(name = "last_updated", columnDefinition = "DATETIME2 DEFAULT GETDATE()")
    private LocalDateTime lastUpdated;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;

    // Getters and Setters
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }
//
//    public Integer getCourseId() {
//        return courseId;
//    }
//
//    public void setCourseId(Integer courseId) {
//        this.courseId = courseId;
//    }

    public Integer getCompletedModules() {
        return completedModules;
    }

    public void setCompletedModules(Integer completedModules) {
        this.completedModules = completedModules;
    }

    public Integer getCompletedLessons() {
        return completedLessons;
    }

    public void setCompletedLessons(Integer completedLessons) {
        this.completedLessons = completedLessons;
    }

    public Float getProgressPercentage() {
        return progressPercentage;
    }

    public void setProgressPercentage(Float progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}