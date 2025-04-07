package com.learningmanagementsystem.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
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

    @LastModifiedDate
    @Column(name = "last_updated", insertable = false, columnDefinition = "DATETIME2 DEFAULT GETDATE()")
    private LocalDateTime lastUpdated;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @JsonIgnore
    private Users user;

    @ManyToOne
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    @JsonIgnore
    private Course course;


}