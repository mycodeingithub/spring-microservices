package example.spring.security.poc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import example.spring.security.poc.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	public List<Role> findRoleByName(String name);
}