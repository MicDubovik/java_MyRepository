package ru.job4j.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByName(String name);
	List<User> findById(Long id);

	List<User> findByNameIgnoreCase(String name);


	@Modifying
	@Query("update User  set number = :number where name = :name")
	@Transactional
	void addNumber(@Param("number")Long number,@Param("name") String name);


}
