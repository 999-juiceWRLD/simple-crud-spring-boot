package com.service.implementation.service;
import com.service.implementation.entity.PatchUser;
import com.service.implementation.entity.User;
import com.service.implementation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository usrRepo;

    public List<User> findAllUsers() {
        return usrRepo.findAll();
    }

    public void deleteUserId(Long id) {
        usrRepo.deleteById(id);
    }

    public void deleteAllUsers() {
        usrRepo.deleteAll();
    }

    public User findUserByName(String name) {
        return usrRepo.findUserByFirstName(name);
    }

    public void saveUser(User user) {
        usrRepo.save(user);
    }

    public User getUserById(Long id) {
        return usrRepo.findUserById(id);
    }

    public void updateUser(Long id, PatchUser patchUser) {
        User user = usrRepo.findUserById(id);

        // update values
        if (patchUser.getFirstName() != null) {
            user.setFirstName(patchUser.getFirstName());
        }
        if (patchUser.getLastName() != null) {
            user.setLastName(patchUser.getLastName());
        }
        if (patchUser.getEmailAddress() != null) {
            user.setEmailAddress(patchUser.getEmailAddress());
        }
        
        usrRepo.save(user);
    }
}
