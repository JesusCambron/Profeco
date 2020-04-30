/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import pubsubservice.PubSubService;

/**
 *
 * @author pc
 */
public class Clientes extends ClientesAbstract{
    //Add subscriber with PubSubService for a topic
	public void addSubscriber(String topic, PubSubService pubSubService){
		pubSubService.addSubscriber(topic, this);
	}
	
	//Unsubscribe subscriber with PubSubService for a topic
	public void unSubscribe(String topic, PubSubService pubSubService){
		pubSubService.removeSubscriber(topic, this);
	}
 
	//Request specifically for messages related to topic from PubSubService
	public void getMessagesForSubscriberOfTopic(String topic, PubSubService pubSubService) {
		pubSubService.getMessagesForSubscriberOfTopic(topic, this);
		
	}	
}
