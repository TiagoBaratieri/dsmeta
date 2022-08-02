package com.baratieri.dsmeta.services;

import com.baratieri.dsmeta.entities.Sale;
import com.baratieri.dsmeta.repositories.SalesRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    @Value("${twilio.sid}")
    private String twilioSid;

    @Value("${twilio.key}")
    private String twilioKey;

    @Value("${twilio.phone.from}")
    private String twilioPhoneFrom;

    @Value("${twilio.phone.to}")
    private String twilioPhoneTo;

    @Autowired
    private SalesRepository repository;

    public void sendSms(Long id) {

        Sale sale = repository.findById(id).get();

        String date = sale.getDate().getMonthValue() + "/" + sale.getDate().getYear();
        Double amount = sale.getAmount();

        String msg = String.format("Vendedor " + sale.getSellerName() + " foi o destaque em " + date
                + " com um total de R$ " + String.format("%.2f", amount));

        Twilio.init(twilioSid, twilioKey);

        PhoneNumber to = new PhoneNumber(twilioPhoneTo);
        PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

        Message message = Message.creator(to, from, msg).create();

        System.out.println(message.getSid());
    }
}