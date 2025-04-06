package com.learningmanagementsystem.domain.repository;

import com.learningmanagementsystem.domain.entity.Assessment;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssessmentRepo extends IBaseRepo<Assessment, Long> {
    @Query(value = "select a from Assessment a " +
                   "where a.lessonId = :id")
    List<Assessment>getAssessmentsByLessonId(Long id);
    //    @Query(value = "  select q.id, q.question_text, q.question_type, q.assessment_id, a.title\n" +
//           "  from questions q, lessons l, assessments a\n" +
//           "  where l.id = 1 and a.id = q.assessment_id", nativeQuery = true)
//    List<Assessment> findAll();
}
