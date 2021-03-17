package com.nagarro.java.AdvanceJava.Assignment5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.java.AdvanceJava.Assignment5.dao.HrDao;
import com.nagarro.java.AdvanceJava.Assignment5.entity.HrRecord;
import com.nagarro.java.AdvanceJava.Assignment5.servicesInterface.HrServiceInterface;
import com.nagarro.java.AdvanceJava.Assignment5.util.EncryptDecrypt;

@Service
public class HrServiceImpl implements HrServiceInterface {

	@Autowired
	private HrDao hrDao;

	@Override
	public boolean authenticateHr(String username, String password) {
		HrRecord user = hrDao.getHrRecord(username);
		try {
			return user != null && EncryptDecrypt.decrypt(user.getPassword()).equals(password);
		} catch (Exception e) {
			System.out.println("Failed to get User details");
		}
		return false;
	}

	@Override
	public void saveHr(String username, String password) {
		HrRecord user = new HrRecord();
		user.setUsername(username);
		try {
			user.setPassword(EncryptDecrypt.encrypt(password));
		} catch (Exception e) {
			System.out.println("Failed to encrypt Password");
		}
		hrDao.saveHrRecord(user);
	}
}
