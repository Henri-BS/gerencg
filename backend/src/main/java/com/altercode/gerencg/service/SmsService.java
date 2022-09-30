package com.altercode.gerencg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.altercode.gerencg.entity.Product;
import com.altercode.gerencg.repository.ProductRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

	@Autowired
	private ProductRepository productRepository;

	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;

	public void sendSms(Long id) {
		
		Product product = productRepository.findById(id).get();
		
		String date = product.getValidate().getMonthValue() + "/" + product.getValidate().getYear();
		
		String msg = "O produto '" + product.getDescription() 
		+ "' terá sua data de validade exprida em: " + date 
		+ ". \nEste produto possui " + product.getQuantity() + " unidades em estoque!";
		
		Twilio.init(twilioSid, twilioKey);

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

		Message message = Message.creator(to, from, msg).create();
		System.out.println(message.getSid());
	}
}