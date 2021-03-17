package com.nagarro.java.AdvanceJava.Assignment5.dao;

import com.nagarro.java.AdvanceJava.Assignment5.entity.HrRecord;

public interface HrDao {

	public void saveHrRecord(HrRecord record);

	public HrRecord getHrRecord(String username);
}
