package com.xworkz.instagram;

import com.xworkz.instagram.dao.InstagramDAO;
import com.xworkz.instagram.dao.InstagramDAOImpl;
import com.xworkz.instagram.dto.InstagramDTO;
import com.xworkz.instagram.service.InstagramService;
import com.xworkz.instagram.service.InstagramServiceImpl;

public class InstagramTester {

	public static void main(String[] args) {
		
		InstagramDTO dto = new InstagramDTO(700,3.8, 12, 400, true);
		
		InstagramService serviceImpl = new InstagramServiceImpl();
		serviceImpl.validateInstagramDTO(dto);
		
		
		serviceImpl.validateInstagramDetails();
	}

}
