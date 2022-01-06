package com.PushAppNotificationDemo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PushAppNotificationDemo.Model.MyNotification;
import com.PushAppNotificationDemo.Model.MyNotification2;
import com.PushAppNotificationDemo.Service.MyService;
import com.windowsazure.messaging.CollectionResult;
import com.windowsazure.messaging.NotificationHub;
import com.windowsazure.messaging.NotificationOutcome;
import com.windowsazure.messaging.Registration;

@RestController
@RequestMapping("/notifications")
public class MyController {
	
	@Autowired
	private MyService myService;
	
	@Autowired
	private NotificationHub nHub;
	
	@PostMapping("/publishToAll")
	public ResponseEntity<String> postNotificationsToAll(@RequestBody MyNotification myNotification) throws Exception{
		NotificationOutcome response= myService.getService(myNotification);
		return new ResponseEntity<String>("Notification Sent with tracking id as "+response.getTrackingId(),HttpStatus.OK);
	}
	
	@PostMapping("/publish")
	public ResponseEntity<String> psotNotificationToSpecificUser(@RequestBody MyNotification2 myNotification) throws Exception{
		List<NotificationOutcome> response=myService.getServiceToSpecificUser(myNotification);
		List<String> myList=new ArrayList<String>();
		for(NotificationOutcome nOutcome:response) {
			String str=nOutcome.getTrackingId();
			myList.add(str);
		}
		return new ResponseEntity<String>("Notification Sent with tracking id as "+myList,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public String getAllRegistrations() throws Exception {
		CollectionResult myCollection=nHub.getRegistrations();
		List<Registration> myList=myCollection.getRegistrations();
		for(Registration r:myList) {
			System.out.println(r.toString());
		}
		return "Thank You!!!";
	}

}
