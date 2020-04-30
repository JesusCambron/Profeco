/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import clientes.Clientes;
import clientes.ClientesAbstract;
import mercados.IMercado;
import mercados.Mercado;
import message.Message;
import pubsubservice.PubSubService;

/**
 *
 * @author pc
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Instantiate publishers, subscribers and PubSubService 
                IMercado sorianaPublisher = new Mercado();
                IMercado vigiTacosPublisher = new Mercado();
		
		ClientesAbstract sorianaSubscriber = new Clientes();
		ClientesAbstract subsAllSupermarket = new Clientes();
		ClientesAbstract vigiTacosSubscriber = new Clientes();
		
		PubSubService pubSubService = new PubSubService();
		
		//Declare Messages and Publish Messages to PubSubService
		Message sorianaMsg1 = new Message("Soriana", "Pan Bimbo 25$");
		Message sorianaMsg2 = new Message("Soriana", "Cubre bocas 250$");
		Message sorianaMsg3 = new Message("Soriana", "Cereal 30$");
		
		sorianaPublisher.publish(sorianaMsg1, pubSubService);
		sorianaPublisher.publish(sorianaMsg2, pubSubService);
		sorianaPublisher.publish(sorianaMsg3, pubSubService);
		
		Message vigiTacosMsg1 = new Message("VigiTacos", "Tacos de gato promo");
		Message vigiTacosMsg2 = new Message("VigiTacos", "Tacos de chicharron");
		
		vigiTacosPublisher.publish(vigiTacosMsg1, pubSubService);
		vigiTacosPublisher.publish(vigiTacosMsg2, pubSubService);
		
		//Declare Subscribers 
		sorianaSubscriber.addSubscriber("Soriana",pubSubService);		//Java subscriber only subscribes to Java topics
		vigiTacosSubscriber.addSubscriber("VigiTacos",pubSubService);   //Python subscriber only subscribes to Python topics
		subsAllSupermarket.addSubscriber("Soriana", pubSubService);	//all subscriber, subscribes to both Java and Python
		subsAllSupermarket.addSubscriber("Vigitacos", pubSubService);
		
		//Trying unSubscribing a subscriber
		//pythonSubscriber.unSubscribe("Python", pubSubService);
		
		//Broadcast message to all subscribers. After broadcast, messageQueue will be empty in PubSubService
		pubSubService.broadcast();
		
		//Print messages of each subscriber to see which messages they got
		System.out.println("Messages of Soriana Subscriber are: ");
		sorianaSubscriber.printMessages();
		
		System.out.println("\nMessages of VigiTacos Subscriber are: ");
		vigiTacosSubscriber.printMessages();
		
		System.out.println("\nMessages of AllSupermarket Subscriber are: ");
		subsAllSupermarket.printMessages();
		
//		//After broadcast the messagesQueue will be empty, so publishing new messages to server
//		System.out.println("\nPublishing 2 more Java Messages...");
//		Message javaMsg4 = new Message("Java", "JSP and Servlets");
//		Message javaMsg5 = new Message("Java", "Struts framework");
//		
//		sorianaPublisher.publish(javaMsg4, pubSubService);
//		sorianaPublisher.publish(javaMsg5, pubSubService);
//		
//		sorianaSubscriber.getMessagesForSubscriberOfTopic("Java", pubSubService);
//		System.out.println("\nMessages of Java Subscriber now are: ");
//		sorianaSubscriber.printMessages();		
    }
    
}
