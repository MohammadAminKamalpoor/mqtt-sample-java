package com.mqtt.sample.Service;

import com.mqtt.sample.model.Order;
import com.mqtt.sample.model.User;
import com.mqtt.sample.utils.JacksonUtils;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.Map;

public class MessageProcessor {

    static void process(MqttMessage mqttMessage, String topic) {
        String message = new String(mqttMessage.getPayload());

        System.out.println("Message received on topic : " + topic);
        System.out.println("Message received with id : " + mqttMessage.getId());
        System.out.println("Message received with qos : " + mqttMessage.getQos());
        System.out.println("Message payload : " + getMessage(message));
    }

    private static Object getMessage(String message) {
        Object data = new Object();
        String[] parts = message.split("#");

        String messageType = parts[0];
        String jsonData = parts[1];

        // Process the deserialized object (cast if needed)
        if (messageType.equals("user")) {
            System.out.println("message with type user received");
            data = getData(jsonData, User.class);
            // impl user logic
        } else if (messageType.equals("order")) {
            System.out.println("message with type order received");
            data = getData(jsonData, Order.class);
            // impl order logic
        } else {
            // Attempt to print key-value pairs if the object has a Map-like structure
            Object o = getData(jsonData, Object.class);
            if (o instanceof Map) {
                Map<String, Object> map = (Map<String, Object>) o;
                System.out.println("message with type object received");
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    System.out.println("\t" + entry.getKey() + ": " + entry.getValue());
                }
            }
        }
        return data;
    }

    private static Object getData(String data, Class<?> clazz) {
        // Deserialize based on class type
        return JacksonUtils.readValue(data, clazz);
    }
}
