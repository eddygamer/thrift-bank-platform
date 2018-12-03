package com.cybord.ti.thrift.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cybord.ti.thrift.dto.RoleDto;
import com.cybord.ti.thrift.error.ThriftBankServiceException;
import com.cybord.ti.thrift.services.RoleService;

/**
 * @author eddyrs
 *
 */
@RestController
@RequestMapping("/api")
public class RoleController {

	@Autowired
	private RoleService service;

	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public ResponseEntity<List<RoleDto>> getRoles() {
		return new ResponseEntity<>(service.getAllRoles(), HttpStatus.OK);
	}

	@RequestMapping(value = "/roles/{roleName}", method = RequestMethod.GET)
	public ResponseEntity<RoleDto> getRoleByName(@PathVariable(value = "roleName") String roleName)
			throws ThriftBankServiceException {
		return new ResponseEntity<>(service.getRoleByName(roleName), HttpStatus.OK);
	}

	@RequestMapping(value = "/roles", method = RequestMethod.POST)
	public ResponseEntity<RoleDto> createRole(@Valid @RequestBody RoleDto roleDto) throws ThriftBankServiceException {
		return new ResponseEntity<>(service.createRole(roleDto), HttpStatus.OK);
	}

	@RequestMapping(value = "/roles/{id}", method = RequestMethod.PUT)
	public ResponseEntity<RoleDto> updateRole(@PathVariable(value = "id") Integer id, @Valid @RequestBody RoleDto roleDto)
			throws ThriftBankServiceException {
		return new ResponseEntity<>(service.updateRole(id, roleDto), HttpStatus.OK);
	}

	@RequestMapping(value = "/roles/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<RoleDto> deleteRole(@PathVariable(value = "id") Integer id)
			throws ThriftBankServiceException {
		return new ResponseEntity<>(service.deleteRole(id), HttpStatus.OK);
	}
	
}
