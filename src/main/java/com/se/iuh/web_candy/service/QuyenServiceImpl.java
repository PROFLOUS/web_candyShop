package com.se.iuh.web_candy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.iuh.web_candy.dao.QuyenRespository;
import com.se.iuh.web_candy.entity.Quyen;
import com.se.iuh.web_candy.entity.TaiKhoan;

@Service
public class QuyenServiceImpl implements QuyenService{
	
	private QuyenRespository quyenRespository;

    @Autowired
    public QuyenServiceImpl(QuyenRespository theQuyenRespository) {
    	quyenRespository = theQuyenRespository;
    }

	@Override
	public List<Quyen> getQuyens() {
		// TODO Auto-generated method stub
		return quyenRespository.findAll();
	}

	@Override
	public void saveQuyen(Quyen theQuyen) {
		// TODO Auto-generated method stub
		quyenRespository.save(theQuyen);
	}

	@Override
	public Quyen getQuyenById(String id) {
		// TODO Auto-generated method stub
		return quyenRespository.getById(id);
	}

	@Override
	public void deleteQuyen(String id) {
		// TODO Auto-generated method stub
		quyenRespository.deleteById(id);
	}

}
