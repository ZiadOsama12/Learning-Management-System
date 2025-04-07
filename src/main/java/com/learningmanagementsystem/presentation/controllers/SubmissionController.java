//package com.learningmanagementsystem.presentation.controllers;
//
//import com.learningmanagementsystem.application.usecases.SubmitAssessmentUseCase;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/v1/submissions")
//public class SubmissionController {
//
//    private SubmitAssessmentUseCase submitAssessmentUseCase;
//
//    @Autowired
//    public SubmissionController(SubmitAssessmentUseCase submitAssessmentUseCase) {
//        this.submitAssessmentUseCase = submitAssessmentUseCase;
//    }
//
//    @PostMapping("/")
//    public ResponseEntity<?>submitAssessment(){
//        return ResponseEntity.ok().build();
//    }
//
//}
