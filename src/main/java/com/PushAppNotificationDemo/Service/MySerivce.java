package com.PushAppNotificationDemo.Service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.PushAppNotificationDemo.Model.MyNotification;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.windowsazure.messaging.FcmRegistration;
import com.windowsazure.messaging.Notification;
import com.windowsazure.messaging.NotificationHub;
import com.windowsazure.messaging.NotificationHubsException;
import com.windowsazure.messaging.NotificationOutcome;

@Service
public class MySerivce {

//	private final FirebaseMessaging firebaseMessaging;
//	
//	@Autowired
//	public MySerivce(FirebaseMessaging firebaseMessaging) {
//		super();
//		this.firebaseMessaging = firebaseMessaging;
//	}

	@Autowired
	private NotificationHub notificationHub;

	public NotificationOutcome getService(MyNotification myNotification) throws NotificationHubsException, JsonProcessingException {

		// Create Notification Hub
		// Do Registrations
		// Send Notification to Azure Notification Hub
		// Get Response
//		FcmRegistration reg1 = new FcmRegistration(myNotification.getToken1());//TODO:Reqiures token for identifying unique users
//		notificationHub.createRegistration(reg1);
//		
//		FcmRegistration reg2 = new FcmRegistration(myNotification.getToken2());//TODO:Reqiures token for identifying unique users
//		notificationHub.createRegistration(reg2);
		
//		String message = createNotificationPayload(myNotification);
//		System.out.println(message);
		
	    String data = "data\" : {\"property1\":\"" + myNotification.getData().get("property1") + "\" ,"+ "\"property2\":\"" + myNotification.getData().get("property2") +"\"}";
	    String notif="{\"notification\" : {\"title\" : \""+myNotification.getTitle() +"\" ," + "\"body\" : \""+myNotification.getBody()+ "\"}, \""+data+"}";
	    System.out.println(notif);

		Notification notification = Notification.createFcmNotification(notif);//Todo:Depending upon PNS methods will differ
		NotificationOutcome nOutcome=new NotificationOutcome("", "");
		
		nOutcome=notificationHub.sendNotification(notification, "");

		return nOutcome;

//		Notification notification=Notification
//				.builder()
//				.setTitle(myNotification.getTitle())
//				.setBody(myNotification.getBody())
//				.build();
//		
//        Message message = Message
//                .builder()
//                .setToken(myNotification.getToken())
//                .setNotification(notification)
//                .build();
//	
//		return firebaseMessaging.send(message);
	}
	
	public static String createNotificationPayload(MyNotification myNotification) throws JsonProcessingException {
		ObjectMapper objectMapper=new ObjectMapper();
		
		ObjectNode message=objectMapper.createObjectNode();
		ObjectNode notification=objectMapper.createObjectNode();
		notification.put("message", myNotification.getBody());
		notification.put("from", myNotification.getTitle());
		message.set("data", notification);
		return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(message);
	}

}
