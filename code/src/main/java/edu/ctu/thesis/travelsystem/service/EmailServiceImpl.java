package edu.ctu.thesis.travelsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ctu.thesis.travelsystem.dao.EmailDao;
import edu.ctu.thesis.travelsystem.model.Email;

@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private EmailDao emailDao;

	@Override
	@Transactional
	public void saveEmail(Email email) {
		this.emailDao.saveEmail(email);
	}

	@Override
	@Transactional
	public void deleteEmail(int id) {
		this.emailDao.deleteEmail(id);
	}

	@Override
	@Transactional
	public boolean getEmailStatus(int id) {
		return this.emailDao.getEmailStatus(id);
	}

	@Override
	@Transactional
	public List<Email> listMail() {
		return this.emailDao.listMail();
	}

	@Override
	public List<Email> listMailByStaus(boolean status) {
		return this.emailDao.listMailByStaus(status);
	}

}
