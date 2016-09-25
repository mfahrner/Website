package com.theironyard.charlotte.services;

import com.theironyard.charlotte.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by mfahrner on 9/24/16.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByName(String name);
}
