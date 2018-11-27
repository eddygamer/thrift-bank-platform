package com.cybord.ti.thrift.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cybord.ti.thrift.dto.user.RoleDto;
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
	public ResponseEntity<List<RoleDto>> ping() {
		return new ResponseEntity<>(service.getAllRoles(), HttpStatus.OK);
	}
	
}
