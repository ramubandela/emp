package com.cellent.employee.kafka.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

	
	@KafkaListener(topics = "sms", 
            groupId ="group-id" )
    public void consume(String message) 
    {
		System.out.println(message+" received.......");
    }
	
	@KafkaListener(topics = "sms2", 
            groupId ="group-id" )
    public void consume2(String message) 
    {//https://github.com/ramubandela/employee.git  E:\employee\employee
		System.out.println(message+" received2.......");
    }
	@KafkaListener(topics = "squared", 
            groupId ="group-id1" )
    public void consume3(String message) 
    {
		System.out.println(message+" squared.......");
    }
}
