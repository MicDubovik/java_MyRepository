package ru.job4j.repo;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.model.Role;

import java.util.List;

/**
 * Created by Katy on 06.06.2017.
 */
public interface RoleRepository extends CrudRepository<Role,Long>{

    List<Role> findAll();
}
