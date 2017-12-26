package example.springcloud.poc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import example.springcloud.poc.entity.UserEntity;

@Repository
public interface UserRespository extends CrudRepository<UserEntity, String>{

}
