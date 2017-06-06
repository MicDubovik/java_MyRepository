package ru.job4j.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.job4j.model.Role;
import ru.job4j.model.User;
import ru.job4j.repo.RoleRepository;
import ru.job4j.repo.UserRepository;


@RestController
public class WebController {
    @Autowired
    UserRepository repository;

    @Autowired
    RoleRepository roleRepository;

    @RequestMapping("/save")
    public String process() {
        repository.save(new User("Michael", "michyy","0101","michyy@mail.ru","Belarus","Minsk",new Role("1")));
        repository.save(new User("Ivan", "vano","2222","vano@mail.ru","Belarus","Minsk",new Role("2")));
        repository.save(new User("Petr", "pet","1111","pet@mail.ru","Russia","Moscow",new Role("2")));
        roleRepository.save(new Role("admin"));
        roleRepository.save(new Role("user"));

        return "save ok !";
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

