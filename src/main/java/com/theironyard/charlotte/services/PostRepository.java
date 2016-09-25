package com.theironyard.charlotte.services;

import com.theironyard.charlotte.entities.Post;
import com.theironyard.charlotte.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by mfahrner on 9/25/16.
 */
public interface PostRepository extends CrudRepository<Post, Integer> {
}
