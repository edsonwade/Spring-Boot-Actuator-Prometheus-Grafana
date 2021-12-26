package com.apllication.app.service;

import com.apllication.app.entities.User;
import com.apllication.app.repository.UserRepo;
import com.apllication.app.service.exception.DataBaseException;
import com.apllication.app.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    /**
     * @return list of  all users
     */
    public List<User> findAll() {
        return userRepo.findAll();
    }

    /**
     * find the user by id
     * lança a  exceção se o obejeco usuario não existir
     *
     * @param id
     */
    public User findById(Long id) {
        Optional<User> obj = userRepo.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    /**
     * inseri um novo usuario
     *
     * @param obj
     * @return
     */
    public User insert(User obj) {
        return userRepo.save(obj);
    }

    public void delete(Long id) {
        try {
            userRepo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }

    }

    public User update(Long id, User obj) {
        try {
            User entity = userRepo.getOne(id);
            updateData(entity, obj);
            return userRepo.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }

    }''

    /**
     * atualize os  dados do usuário
     *
     * @param entity
     * @param obj
     */
    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}
