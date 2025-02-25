package br.com.matheusjuan.eventlinker.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.matheusjuan.eventlinker.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    public User findByEmail(String email);
}
