package com.PushAppNotificationDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.windowsazure.messaging.NotificationHub;

@SpringBootApplication
public class PushAppNotificationDemo1Application {
	
	private static final String accessSignature="Endpoint=sb://ShashankNotificationHub.servicebus.windows.net/;SharedAccessKeyName=DefaultFullSharedAccessSignature;SharedAccessKey=8NnFv2wQGdjTOFffmopl9BsYfE1ngIjApVQkOb4Jk+s=";
	private static final String hubpath="MyNotificationHub2";

	public static void main(String[] args) {
		SpringApplication.run(PushAppNotificationDemo1Application.class, args);
	}
	
	@Bean
	public NotificationHub getNotificationHub(){
		return new NotificationHub(accessSignature,hubpath);
	}

}
