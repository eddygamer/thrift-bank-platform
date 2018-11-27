package com.cybord.ti.thrift.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.cybord.ti.thrift.dto.user.RoleDto;
import com.cybord.ti.thrift.entities.Role;


/**
 * @author eddyrs
 *
 */
@Mapper
public interface RoleMapper {
	RoleDto getRoleDtoFromEntity(Role entity);
	List<RoleDto> getRoleDtosFromEntities(List<Role> entities);
}
