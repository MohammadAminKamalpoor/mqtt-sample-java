package com.mqtt.sample.Service;

import org.eclipse.paho.client.mqttv3.*;

public class MqttSubscriber {

    // Broker details (replace with your actual broker address and port)
    private static final String brokerAddress = "tcp://130.185.74.15:11883";

    // Topic to subscribe to (use "#" for wildcard)
    private static final String topic = "devices"; // Subscribes to "devices" and all subtopics

    // MQTT client ID
    private static final String clientId = "subscriber";

    private static final String username = "subscriber";

    private static final String password = "subscriber";

    // QoS level (Quality of Service)
    private static final int qos = 2; // At least once delivery

    public static void subscribe() {

        // Create connection options (optional, customize as needed)
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(username); // Username for authentication (if required)
        options.setPassword(password.toCharArray()); // Password for authentication (if required)
        options.setCleanSession(false); // Start with a clean session

        // Create an MQTT client
        MqttClient client;
        try {
            client = new MqttClient(brokerAddress, clientId);

            // Connect to the broker
            client.connect(options);

            // Callback to handle received messages
            MqttCallback callback = new MqttCallback() {

                public void connectionLost(Throwable cause) {
                    System.out.println("connectionLost: " + cause.getMessage());
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) {
                    // Call another method with the message data
                    MessageProcessor.process(message, topic);
                }

                public void deliveryComplete(IMqttDeliveryToken token) {
                    System.out.println("deliveryComplete---------" + token.isComplete());
                }
            };

            // Subscribe to the topic
            client.subscribe(topic, qos);
            System.out.println("Successfully subscribed to topic: " + topic);

            // Set callback for message arrival
            client.setCallback(callback);
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }
    }

}
