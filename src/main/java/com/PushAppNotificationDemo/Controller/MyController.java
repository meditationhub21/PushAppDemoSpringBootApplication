package com.PushAppNotificationDemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PushAppNotificationDemo.Model.MyNotification;
import com.PushAppNotificationDemo.Service.MySerivce;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.windowsazure.messaging.NotificationOutcome;

@RestController
@RequestMapping("/notifications")
public class MyController {
	
	@Autowired
	private MySerivce myService;
	
	@PostMapping("/publish")
	public ResponseEntity<String> postNotifications(@RequestBody MyNotification myNotification) throws Exception{
		NotificationOutcome response= myService.getService(myNotification);
		return new ResponseEntity<String>("Notification Sent with tracking id as "+response.getTrackingId(),HttpStatus.OK);
	}

	
}
