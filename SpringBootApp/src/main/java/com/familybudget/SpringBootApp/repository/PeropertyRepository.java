package com.familybudget.SpringBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.familybudget.SpringBootApp.model.peroperties;


@Repository

public interface PeropertyRepository extends JpaRepository<peroperties,Long>{

	public List<peroperties> findByUsersId(long UserId);
}
