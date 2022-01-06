package com.PushAppNotificationDemo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PushAppNotificationDemo.Model.MyNotification;
import com.PushAppNotificationDemo.Model.MyNotification2;
import com.windowsazure.messaging.Notification;
import com.windowsazure.messaging.NotificationHub;
import com.windowsazure.messaging.NotificationHubsException;
import com.windowsazure.messaging.NotificationOutcome;

@Service
public class MyService {
	
	@Autowired
	private NotificationHub notificationHub;


	public NotificationOutcome getService(MyNotification myNotification) throws Exception {
		    String data = "data\" : {\"property1\":\"" + myNotification.getData().get("property1") + "\" ,"+ "\"property2\":\"" + myNotification.getData().get("property2") +"\"}";
		    String notif="{\"notification\" : {\"title\" : \""+myNotification.getTitle() +"\" ," + "\"body\" : \""+myNotification.getBody()+ "\"}, \""+data+"}";
		    System.out.println(notif);

			Notification notification = Notification.createFcmNotification(notif);//Todo:Depending upon PNS methods will differ
			NotificationOutcome nOutcome=new NotificationOutcome("", "");
				
			
			nOutcome=notificationHub.sendNotification(notification, "");

			return nOutcome;
	}

	public List<NotificationOutcome> getServiceToSpecificUser(MyNotification2 myNotification2) throws Exception {
		   String data = "data\" : {\"property1\":\"" + myNotification2.getData().get("property1") + "\" ,"+ "\"property2\":\"" + myNotification2.getData().get("property2") +"\"}";
		    String notif="{\"notification\" : {\"title\" : \""+myNotification2.getTitle() +"\" ," + "\"body\" : \""+myNotification2.getBody()+ "\"}, \""+data+"}";
		    System.out.println(notif);

			Notification notification = Notification.createFcmNotification(notif);//Todo:Depending upon PNS methods will differ
			
			
			List<NotificationOutcome> myList=new ArrayList<>();
				
			for(String x:myNotification2.getTags()) {
				NotificationOutcome nOutcome=new NotificationOutcome("", "");
				nOutcome=notificationHub.sendNotification(notification,x);
				myList.add(nOutcome);
			}
			

			return myList;
	}

}
