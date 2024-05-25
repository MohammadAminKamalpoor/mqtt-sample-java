package com.mqtt.sample.Service;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * The Publisher doesn't support topic with any wildcard characters (#+)
 **/

public class MqttPublisher {

    // Broker details (replace with your actual broker address and port)
    private static final String brokerAddress = "tcp://130.185.74.15:11883";

    // MQTT client ID
    private static final String clientId = "publisher";

    private static final String username = "publisher";

    private static final String password = "publisher";

    // QoS level (Quality of Service)
    private static final int qos = 2; // At least once delivery

    public static void publish(String message, String topic) {

        // Create connection options (optional, customize as needed)
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(username); // Username for authentication (if required)
        options.setPassword(password.toCharArray()); // Password for authentication (if required)
        options.setCleanSession(true); // Start with a clean session

        try {
            // Create an MQTT client
            MqttClient client = new MqttClient(brokerAddress, clientId);

            // Connect to the broker

            client.connect(options);

            // Create an MQTT message
            MqttMessage mqttMessage = new MqttMessage(message.getBytes());
            mqttMessage.setQos(qos);

            // Publish the message
            client.publish(topic, mqttMessage);

            // Disconnect from the broker
            client.disconnect();
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Message published to topic: " + topic);
    }

}