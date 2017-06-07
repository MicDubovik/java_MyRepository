package ru.job4j.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import ru.job4j.model.Role;
import ru.job4j.model.User;
import ru.job4j.repo.RoleRepository;
import ru.job4j.repo.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@RestController
public class WebController {
    @Autowired
    UserRepository repository;

    @Autowired
    RoleRepository roleRepository;

    @PersistenceContext
    public EntityManager entityManager;



    @RequestMapping("/save")
    public String fill() {
        Role role1 = roleRepository.save(new Role("admin"));
        Role role2 = roleRepository.save(new Role("user"));
        Role role3 = roleRepository.save(new Role("guest"));


        repository.save(new User("Michael", "michyy", "0101", "michyy@mail.ru", "Belarus", "Minsk", role1, 1L));
        repository.save(new User("Ivan", "vano", "2222", "vano@mail.ru", "Belarus", "Minsk", role2,2l));
        repository.save(new User("Petr", "pet", "1111", "pet@mail.ru", "Russia", "Moscow", role3,3l));


        return "save ok !";
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String createuser(@RequestParam ("name")String name,
                             @RequestParam ("login")String login,
                             @RequestParam ("password")String password,
                             @RequestParam ("email")String email,
                             @RequestParam ("country")String country,
                             @RequestParam ("city")String city ,
                             @RequestParam ("number")Long num) {
        Role role = roleRepository.save(new Role("user"));

        User user = new User(name,login,password,email,country,city,role,num);

        repository.save(user);



        return "firstPage";
    }

    @RequestMapping(value = "/addNum")
    public String createuser(@RequestParam ("number")Long number,
                             @RequestParam ("name")String name) {


        repository.addNumber(number,name);

        return "update ok!";
    }






    @RequestMapping("/findall")
    public String findAll() {
        String result = "<html>";

        for (User cust : repository.findAll()) {
            result += "<div>" + cust.toString() + "</div>";
        }

        return result + "</html>";
    }

    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id) {
        String result = "";
        result = repository.findOne(id).toString();
        return result;
    }

    @RequestMapping("/findbyname")
    public String fetchDataByLastName(@RequestParam("name") String name) {
        String result = "<html>";

        for (User cust : repository.findByNameIgnoreCase(name)) {
            result += "<div>" + cust.toString() + "</div>";
        }

        return result + "</html>";
    }



}

