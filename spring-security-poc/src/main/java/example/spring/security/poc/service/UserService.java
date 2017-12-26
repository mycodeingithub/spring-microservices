package example.spring.security.poc.service;

import example.spring.security.poc.entity.User;

public interface UserService {

	void save(User user);

	User findByUsername(String username);

}
