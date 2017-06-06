package ru.job4j.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ru.job4j.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

	List<User> findByName(String name);
	List<User> findAllById(Long id);

	List<User> findByNameIgnoreCase(String name);
}
