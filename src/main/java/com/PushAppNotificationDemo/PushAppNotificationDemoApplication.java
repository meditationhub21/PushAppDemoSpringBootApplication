package com.PushAppNotificationDemo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.client.RestTemplate;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.windowsazure.messaging.NotificationHub;

@SpringBootApplication
public class PushAppNotificationDemoApplication {
	
	private static final String accessSignature="Endpoint=sb://ShashankNotificationHub.servicebus.windows.net/;"
			+ "SharedAccessKeyName=DefaultFullSharedAccessSignature;SharedAccessKey=GY6I6kGkyby4zkAr8jyRo1ZEIFwa0OklZSLpov5mn14=";
	private static final String hubpath="MyNotificationHub";

	public static void main(String[] args) {
		SpringApplication.run(PushAppNotificationDemoApplication.class, args);
	}
	
//	@Bean
//	FirebaseMessaging firebaseMessaging() throws IOException {
//	    GoogleCredentials googleCredentials = GoogleCredentials
//	            .fromStream(new ClassPathResource("firebase-service-account.json").getInputStream());
//	    FirebaseOptions firebaseOptions = FirebaseOptions
//	            .builder()
//	            .setCredentials(googleCredentials)
//	            .build();
//	    FirebaseApp app = FirebaseApp.initializeApp(firebaseOptions, "MyPushAppNotificationDemo");
//	    return FirebaseMessaging.getInstance(app);
//	}
	
	@Bean
	public NotificationHub getNotificationHub(){
		return new NotificationHub(accessSignature,hubpath);
	}

}
