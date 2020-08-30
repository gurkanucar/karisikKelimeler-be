package com.gucarsoft.karisikkelimelerbe.service;

import com.gucarsoft.karisikkelimelerbe.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly=true)
public class UserService extends BaseService {
    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User findById(Long id) {
        return userRepo.findById(id).get();
    }

    public User save(User user) {
        return userRepo.save(user);
    }

    public User update(User user) {
        User existing = findById(user.getId());
        if (user.getName() != null) {
            existing.setName(user.getName());
        }
        if (user.getMail() != null) {
            existing.setMail(user.getMail());
        }
        if (user.getPassword() != null) {
            existing.setPassword(user.getPassword());
        }
        if (user.getTime_score() != null) {
            existing.setTime_score(user.getTime_score());
        }
        if (user.getInfinite_score() != null) {
            existing.setInfinite_score(user.getInfinite_score());
        }
        if (user.getDeleted() != null) {
            existing.setDeleted(user.getDeleted());
        }
        return userRepo.save(existing);
    }

    public User delete(Long id) {
        User existing = findById(id);
        existing.setDeleted(true);
        return userRepo.save(existing);
    }

    public Object findAllByMail(User user) {
        return userRepo.findAllByMail(user.getMail());
    }
}
