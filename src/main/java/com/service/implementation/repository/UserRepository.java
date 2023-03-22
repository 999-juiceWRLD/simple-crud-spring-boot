package com.service.implementation.repository;

import com.service.implementation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll(); // lists all the patients

    void deleteById(Long id); // deletes patients by id
    void deleteAll();
    long count(); // return how many patients are there
    User save(User user); // saves the patient into the database
    User findUserByFirstName(String userName);
    User findUserById(Long id);

}
