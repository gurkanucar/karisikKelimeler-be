package com.gucarsoft.karisikkelimelerbe.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gucarsoft.karisikkelimelerbe.model.Question;
import com.gucarsoft.karisikkelimelerbe.model.ResponsePojo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Transactional
@RestController
@RequestMapping(value="/api/question", consumes = MediaType.APPLICATION_JSON_VALUE)
public class QuestionController extends BaseController {
    @GetMapping
    public ResponsePojo list() {
        try {
            return new ResponsePojo(questionService.findAll());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage(), e);
        }
    }

    @GetMapping("/public")
    public ResponsePojo findAllPublic () {
        try {
            return new ResponsePojo(questionService.findAllPublic());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage(), e);
        }
    }


    @GetMapping("/{id}")
    public ResponsePojo get(@PathVariable Long id) {
        try {
            return new ResponsePojo(questionService.findById(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage(), e);
        }
    }

    @PostMapping
    public ResponsePojo create(@RequestBody Question question) {
        try {
            return new ResponsePojo(questionService.save(question));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage(), e);
        }
    }

    @PutMapping
    public ResponsePojo update(@RequestBody Question question) {
        try {
            return new ResponsePojo(questionService.update(question));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage(), e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponsePojo delete(@PathVariable Long id) {
        try {
            return new ResponsePojo(questionService.delete(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage(), e);
        }
    }
}
