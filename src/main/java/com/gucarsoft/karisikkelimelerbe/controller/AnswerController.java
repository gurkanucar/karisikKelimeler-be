package com.gucarsoft.karisikkelimelerbe.controller;

import com.gucarsoft.karisikkelimelerbe.model.Answer;
import com.gucarsoft.karisikkelimelerbe.model.AnswerPojo;
import com.gucarsoft.karisikkelimelerbe.model.ResponsePojo;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Transactional
@RestController
@RequestMapping(value="/api/answer")
public class AnswerController extends BaseController {
    @GetMapping
    public ResponsePojo list() {
        try {
            return new ResponsePojo(answerService.findAll());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage(), e);
        }
    }

    @GetMapping("/{id}")
    public ResponsePojo get(@PathVariable Long id) {
        try {
            return new ResponsePojo(answerService.findById(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage(), e);
        }
    }

    @PostMapping
    public ResponsePojo create(@RequestBody AnswerPojo answer) {
        try {
            return new ResponsePojo(answerService.save(answer));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage(), e);
        }
    }

    @PutMapping
    public ResponsePojo update(@RequestBody Answer answer) {
        try {
            return new ResponsePojo(answerService.update(answer));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage(), e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponsePojo delete(@PathVariable Long id) {
        try {
            return new ResponsePojo(answerService.delete(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage(), e);
        }
    }
}
