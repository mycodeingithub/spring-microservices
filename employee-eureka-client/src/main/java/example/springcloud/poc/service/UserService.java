package example.springcloud.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.springcloud.poc.entity.UserEntity;
import example.springcloud.poc.repository.UserRespository;

@Service
public class UserService {
	
	@Autowired
	private UserRespository userRespository;
	
	public boolean createUser(UserEntity userEntity) {
		userRespository.save(userEntity);
		return true;
	}
	
	public Iterable<UserEntity> getAllUser() {
		return userRespository.findAll();
	}
	
	public UserEntity get(String id) {
		return userRespository.findOne(id);
	}

}
