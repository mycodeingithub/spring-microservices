package example.spring.security.poc.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import example.spring.security.poc.entity.User;
import example.spring.security.poc.repository.RoleRepository;
import example.spring.security.poc.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(new HashSet<>(roleRepository.findRoleByName("ROLE_USER")));
		userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		 return userRepository.findByUsername(username);
	}
	
	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("admin"));
	}

}
