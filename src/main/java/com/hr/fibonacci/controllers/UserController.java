package com.hr.fibonacci.controllers;


import com.hr.fibonacci.models.User;
import com.hr.fibonacci.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository repo;

//    List<User> userList= new ArrayList<>();

    @GetMapping("/iteration")
    public String bootstrap(Model view){
        List <User> users = new ArrayList<>();
        users.add(new User(1,"hugo","resende","hresende","hugo@hugo"));
        users.add(new User(2,"as","ass","axs","hugo@xas"));
        users.add(new User(3,"SAs","dd","xasx","axs@hugo"));
        users.add(new User(4,"dadsad","ads","xxas","axs@xasxa"));
        users.add(new User(5,"hugDDASo","xzx","dasd","xa@xasxa"));
        view.addAttribute("users",users);
        return "fibo-app/extras/bootstrap";
    }

    @GetMapping ("/register")
    public String showSignUpForm(Model model){
        model.addAttribute("user", new User());

        return "fibo-app/extras/signup_form";

    }

    @PostMapping("/process_register")
    public String processRegistration(User user){

//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String encodedPassword = encoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
        repo.save(user);

        return "fibo-app/index";
    }

    @GetMapping("/users")
    public String viewUsersList(Model view){

        List<User> listUsers = repo.findAll();

        view.addAttribute("listUsers", listUsers);

        return "fibo-app/extras/users";
    }

    @GetMapping("/user-edit/{id}")
    public ModelAndView edit(@PathVariable(name = "id") Long id){
        //to edit, use same view create with populated data
        ModelAndView mv = new ModelAndView("fibo-app/extras/signup_form");

        List<User> users = repo.findAll();

        User userFind = users.stream().filter(user -> id.equals(user.getId())).findFirst().get();

        System.out.println(userFind);
        mv.addObject("user", userFind);

        return mv;


    }

    @GetMapping("/user-delete/{id}")
    private String deleteStudent(@PathVariable(name = "id") Long id){
        System.out.println("user_id : "+id);
        User user = repo.getById(id);
        repo.delete(user);
        return "fibo-app/extras/users";
    }
}
