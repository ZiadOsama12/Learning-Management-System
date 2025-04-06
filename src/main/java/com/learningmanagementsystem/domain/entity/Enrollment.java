package com.learningmanagementsystem.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "enrollments")
public class Enrollment {

    @EmbeddedId
    private EnrollmentKey id;


//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Integer id;
//
//    @Id
//    @Column(name = "user_id", nullable = false)
//    private Integer userId;

//    @Column(name = "course_id", nullable = false)
//    private Integer courseId;

    @Column(name = "enrolled_at", insertable = false, updatable = false, columnDefinition = "DATETIME2 DEFAULT GETDATE()")
    private LocalDateTime enrolledAt;

    @Column(name = "status", length = 20, nullable = false)
    private String status;

//    @ManyToOne
//    @JoinColumn(name = "user_id", insertable = false, updatable = false)
//    private Users user;
//
//    @ManyToOne
//    @JoinColumn(name = "course_id", insertable = false, updatable = false)
//    private Course course;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private Users user;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    @JsonIgnore
    private Course course;

    public Enrollment(EnrollmentKey id, Users user, Course course, String status) {
        this.id = id;
        this.user = user;
        this.course = course;
        this.status = status;
    }

  }