/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open  the template in the editor.
 */
package mercados;

import message.Message;
import pubsubservice.PubSubService;

/**
 *
 * @author pc
 */
public class Mercado implements IMercado{

    @Override
    public void publish(Message message, PubSubService pubSubService) {
        pubSubService.addMessageToQueue(message);
    }
    
}
