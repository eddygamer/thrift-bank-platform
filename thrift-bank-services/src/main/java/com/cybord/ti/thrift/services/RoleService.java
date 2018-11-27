package com.cybord.ti.thrift.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybord.ti.thrift.dto.user.RoleDto;
import com.cybord.ti.thrift.mappers.RoleMapper;
import com.cybord.ti.thrift.repositories.RoleRepository;


/**
 * 
 * @author eddyrs
 *
 */
@Service
public class RoleService {
	
	@Autowired
	private RoleRepository repository;
	
	@Autowired
	private RoleMapper mapper;
	
	public List<RoleDto> getAllRoles(){
		return mapper.getRoleDtosFromEntities(repository.findAll());
	}
	
}
