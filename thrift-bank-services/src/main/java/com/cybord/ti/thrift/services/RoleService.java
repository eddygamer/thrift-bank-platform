package com.cybord.ti.thrift.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cybord.ti.thrift.dto.RoleDto;
import com.cybord.ti.thrift.entities.Role;
import com.cybord.ti.thrift.error.ThriftBankServiceException;
import com.cybord.ti.thrift.mappers.RoleMapper;
import com.cybord.ti.thrift.repositories.RoleRepository;
import com.cybord.ti.thrift.tools.DtoValidator;

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

	@Autowired
	private DtoValidator dtoValidator;

	public List<RoleDto> getAllRoles() {
		return mapper.getRoleDtosFromEntities(repository.findAll());
	}

	public RoleDto createRole(RoleDto roleDto) throws ThriftBankServiceException {
		try {
			dtoValidator.createValidator(roleDto);
			return mapper.getRoleDtoFromEntity(repository.save(mapper.getRoleEntityFromDto(roleDto)));
		} catch (DataAccessException e) {
			throw new ThriftBankServiceException("Error creating Role", e.getMessage(), HttpStatus.CONFLICT.value());
		}
	}
	
	public RoleDto updateRole(int id, RoleDto roleDto) throws ThriftBankServiceException {
		try {
			dtoValidator.updateValidator(roleDto);
			Optional<Role> role = repository.findById(id);
			if (role.isPresent()) {
				role.get().setName(roleDto.getName());
				return mapper.getRoleDtoFromEntity(repository.save(role.get()));
			} else {
				throw new ThriftBankServiceException("Error updating Role",
						String.format("The id %d is not found", id), HttpStatus.CONFLICT.value());
			}
		} catch (DataAccessException e) {
			throw new ThriftBankServiceException("Error updating Role", e.getMessage(), HttpStatus.CONFLICT.value());
		}
	}

}
