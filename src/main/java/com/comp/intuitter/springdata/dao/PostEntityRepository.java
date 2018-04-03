package com.comp.intuitter.springdata.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.comp.intuitter.springdata.entity.PostEntity;

public interface PostEntityRepository extends CrudRepository<PostEntity, String>{
	
	@Query(value="From PostEntity p where p.employee.id in (SELECT f.id from EmployeeEntity s join s.friends f where s.id = :userId) ORDER BY createDate DESC")
	List<PostEntity> findByEmployeeId(@Param("userId") String userId, Pageable pageable);

}
