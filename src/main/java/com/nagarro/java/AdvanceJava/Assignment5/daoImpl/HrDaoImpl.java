package com.nagarro.java.AdvanceJava.Assignment5.daoImpl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import com.nagarro.java.AdvanceJava.Assignment5.config.HIbernateConfig;
import com.nagarro.java.AdvanceJava.Assignment5.dao.HrDao;
import com.nagarro.java.AdvanceJava.Assignment5.entity.HrRecord;

public class HrDaoImpl implements HrDao {

	@Override
	public void saveHrRecord(HrRecord record) {
		Session session = HIbernateConfig.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(record);
		session.getTransaction().commit();
	}

	@Override
	public HrRecord getHrRecord(String username) {
		HrRecord hr = null;
		try {
			Session session = HIbernateConfig.getSessionFactory().openSession();
			hr = new HrRecord();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<HrRecord> criteria = builder.createQuery(HrRecord.class);
			Root<HrRecord> root = criteria.from(HrRecord.class);
			criteria.select(root);
			criteria.where(builder.equal(root.get("username"), username));
			hr = session.createQuery(criteria).uniqueResult();
		} catch (Exception e) {
			System.out.println("Enable to get HR details");
		}

		return hr;
	}

}
