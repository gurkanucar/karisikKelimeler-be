package com.gucarsoft.karisikkelimelerbe.controller;

import com.gucarsoft.karisikkelimelerbe.model.ResponsePojo;
import com.gucarsoft.karisikkelimelerbe.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value="/api/user")
public class UserController extends BaseController {
    @GetMapping
    public ResponsePojo list() {
        try {
            return new ResponsePojo(userService.findAll());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage(), e);
        }
    }

    @GetMapping("/{id}")
    public ResponsePojo get(@PathVariable Long id) {
        try {
            return new ResponsePojo(userService.findById(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage(), e);
        }
    }

    @PostMapping
    public ResponsePojo create(@RequestBody User user) {
        try {
            if (userService.findAllByMail(user) != null) {
                return new ResponsePojo(409, "already exist");
            }
            return new ResponsePojo(userService.save(user));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage(), e);
        }
    }

    @PutMapping
    public ResponsePojo update(@RequestBody User user) {
        try {
            return new ResponsePojo(userService.update(user));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage(), e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponsePojo delete(@PathVariable Long id) {
        try {
            return new ResponsePojo(userService.delete(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage(), e);
        }
    }
}
