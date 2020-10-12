package com.familybudget.SpringBootApp.Service;

import java.util.List;

import com.familybudget.SpringBootApp.model.peroperties;
import com.familybudget.SpringBootApp.model.user;


public interface PropertiesService {
	
	List<peroperties> list();
	
	peroperties save(peroperties per);
	
	peroperties update(long id,peroperties per);
	
	peroperties findByID(long id);
	
	void deleteByID(long id);
	
	public List<peroperties> findByUsersId(long UserId);

}
