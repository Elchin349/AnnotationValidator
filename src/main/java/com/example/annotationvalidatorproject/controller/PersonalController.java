package com.example.annotationvalidatorproject.controller;

import com.example.annotationvalidatorproject.model.AuthModel;
import com.example.annotationvalidatorproject.model.PersonalModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/personal")
public class PersonalController {

    @GetMapping
    public ResponseEntity<PersonalModel> getModel(@Valid @RequestBody PersonalModel personalModel) {
        return ResponseEntity.ok(personalModel);
    }
}
