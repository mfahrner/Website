package com.theironyard.charlotte.controllers;

import com.theironyard.charlotte.entities.Post;
import com.theironyard.charlotte.entities.User;
import com.theironyard.charlotte.services.PostRepository;
import com.theironyard.charlotte.services.UserRepository;
import com.theironyard.charlotte.utilities.PasswordStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by mfahrner on 9/23/16.
 */
@Controller
public class WebsiteController {

    @Autowired
    UserRepository users;

    @Autowired
    PostRepository posts;

    @RequestMapping (path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        List<Post> postList = (List)posts.findAll();
        model.addAttribute("name", session.getAttribute("name"));
        model.addAttribute("posts", postList);
        return "home";
    }

    @RequestMapping (path = "/blog", method = RequestMethod.GET)
    public String blog(Model model, HttpSession session) {
        List<Post> postList = (List)posts.findAll();
        model.addAttribute("name", session.getAttribute("name"));
        model.addAttribute("posts", postList);
        return "blog";
    }

    @RequestMapping (path = "/resume", method = RequestMethod.GET)
    public String resume(Model model, HttpSession session) {
        List<Post> postList = (List)posts.findAll();
        model.addAttribute("name", session.getAttribute("name"));
        model.addAttribute("posts", postList);
        return "resume";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public void login(String name, String password, HttpSession session, HttpServletResponse response) throws Exception {
        User user = users.findByName(name);
        if (!PasswordStorage.verifyPassword(password, user.getPassword())) {
            throw new Exception("Wrong password");
        }
        session.setAttribute("name", name);
        response.sendRedirect("/");
    }

    @RequestMapping(path = "/blog", method = RequestMethod.POST)
    public void blogPost(String date, String text, HttpSession session, HttpServletResponse response) throws Exception {
        Post post = new Post(date, text);
        posts.save(post);
        response.sendRedirect("/");
    }

    @PostConstruct
    public void init() throws PasswordStorage.CannotPerformOperationException {
        if (users.count() == 0) {
            User mike = new User("mike", PasswordStorage.createHash("1234"));
            users.save(mike);
        }
    }
}
