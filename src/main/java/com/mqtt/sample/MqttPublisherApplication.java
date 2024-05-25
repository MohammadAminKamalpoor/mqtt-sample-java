package com.mqtt.sample;

import com.mqtt.sample.Service.MqttPublisher;
import com.mqtt.sample.model.User;
import com.mqtt.sample.utils.JacksonUtils;

public class MqttPublisherApplication {

    private static final String topic = "devices";

    public static void main(String[] args) {
        publish();
    }

    private static void publish() {
        User user = new User("test", "test", "admin", "amin@gmail.com");

        // Create MQTT message
        // String message = "Hello World!"; // simple message for test
        // Serialize to JSON
        String json = JacksonUtils.writeValueAsString(user);
        String messageType = "user";
        String message = messageType + "#" + json;

        MqttPublisher.publish(message, topic);
    }

}
