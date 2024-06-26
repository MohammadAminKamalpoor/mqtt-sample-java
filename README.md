# Getting Started with MQTT and Java

This project is a simple application to show how to start your first MQTT Application.

## Prerequisite

* Maven
* Install a MQTT Broker, for example [TBMQ](https://thingsboard.io/docs/mqtt-broker/install/installation-options/)

## Build and run the application

**Build the project with Apache Maven:**

This project is a simple Java application that runs a publisher and subscriber using
the [Eclipse Paho library](https://eclipse.org/paho/).

```
$ mvn clean package
```

## run the application

**1- Run the MQTT broker**

**2- Run [MqttPublisherApplication.java](src%2Fmain%2Fjava%2Fcom%2Fmqtt%2Fsample%2FMqttPublisherApplication.java) to
publish new message**

**3- Run the [MqttSubscriberApplication.java](src%2Fmain%2Fjava%2Fcom%2Fmqtt%2Fsample%2FMqttSubscriberApplication.java)
to received and print all the messages published on the defined topic.**

