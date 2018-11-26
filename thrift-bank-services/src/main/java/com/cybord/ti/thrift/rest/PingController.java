package com.cybord.ti.thrift.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author eddyrs
 *
 */
@RestController
@RequestMapping("/api")
public class PingController {
	
	@RequestMapping("/ping")
	public ResponseEntity<String> ping() {
		return new ResponseEntity<>("Hola Eddy!!", HttpStatus.OK);

	}
}
