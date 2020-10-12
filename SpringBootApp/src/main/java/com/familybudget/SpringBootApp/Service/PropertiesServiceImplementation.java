package com.familybudget.SpringBootApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.familybudget.SpringBootApp.model.peroperties;
import com.familybudget.SpringBootApp.repository.PeropertyRepository;

@Service

public class PropertiesServiceImplementation implements PropertiesService {
	
	@Autowired
	PeropertyRepository prerepo;

	@Override
	public List<peroperties> list() {
		// TODO Auto-generated method stub
		return prerepo.findAll();
	}

	@Override
	public peroperties save(peroperties per) {
		// TODO Auto-generated method stub
		return prerepo.save(per);
	}

	@Override
	public peroperties update(long id, peroperties per) {
		// TODO Auto-generated method stub
		peroperties pers=findByID(id);
		pers.setProperty(per.getProperty());
		pers.setProperty_pl(per.getProperty_pl());
		pers.setProperty_value(per.getProperty_value());
		pers.setPr_remarks(per.getPr_remarks());		
		prerepo.save(pers);
		return pers;
	}

	@Override
	public peroperties findByID(long id) {
		// TODO Auto-generated method stub
		return prerepo.findById(id).get();
	}

	@Override
	public void deleteByID(long id) {
		// TODO Aut
		peroperties per= findByID(id);
		
		prerepo.delete(per);
		
	}

	@Override
	public List<peroperties> findByUsersId(long UserId) {
		// TODO Auto-generated method stub
		System.out.println("pe"+UserId);
		List<peroperties> per=prerepo.findByUsersId(UserId);
		return per;
	}

/*	@Override
	public peroperties findBylogin_user_name(String Username) {
		// TODO Auto-generated method stub
		System.out.println("pe"+Username);
		peroperties per=prerepo.findBylogin_user_name(Username);
		System.out.println("per"+per);
		return per;
	}*/

}
