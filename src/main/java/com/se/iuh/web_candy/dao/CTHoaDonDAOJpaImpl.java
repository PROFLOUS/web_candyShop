package com.se.iuh.web_candy.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.iuh.web_candy.entity.ChiTietHDBanHang;

@Repository
public class CTHoaDonDAOJpaImpl implements CTHoaDonDAO {
	private EntityManager entityManager;

	
	@Autowired
	public CTHoaDonDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}


	@Override
	@Transactional
	public List<ChiTietHDBanHang> findAll() {
		Query theQuery = (Query) entityManager.createQuery("from ChiTietHDBanHang");
		List<ChiTietHDBanHang> hoadons = theQuery.getResultList();
		return hoadons;
	}


	@Override
	@Transactional
	public Optional<ChiTietHDBanHang> findById(int theId) {
		return Optional.of(entityManager.find(ChiTietHDBanHang.class, theId));
	}


	@Override
	@Transactional
	public void save(ChiTietHDBanHang theHoaDon) {
		ChiTietHDBanHang dbHoaDon = entityManager.merge(theHoaDon);
		theHoaDon.setMaHD(dbHoaDon.getMaHD());
		
	}


	@Override
	@Transactional
	public void deteleById(int theId) {
		Query<ChiTietHDBanHang> theQuery = (Query<ChiTietHDBanHang>) entityManager.createQuery("delete from ChiTietHDBanHang where maHD=:chitiethoadonId");
		theQuery.setParameter("chitiethoadonId", theQuery);
		theQuery.executeUpdate();
		
	}
	
}
