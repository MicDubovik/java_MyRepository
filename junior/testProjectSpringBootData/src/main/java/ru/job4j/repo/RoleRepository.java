package ru.job4j.repo;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.model.Role;

import java.util.List;


public interface RoleRepository extends CrudRepository<Role,Long>{

    List<Role> findAll();
}
