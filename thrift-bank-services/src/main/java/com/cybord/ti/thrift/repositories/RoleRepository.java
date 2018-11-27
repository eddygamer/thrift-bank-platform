package com.cybord.ti.thrift.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.cybord.ti.thrift.entities.Role;

/**
 * @author eddyrs
 *
 */
public interface RoleRepository extends CrudRepository<Role, Integer> {
	public List<Role> findAll();
}
