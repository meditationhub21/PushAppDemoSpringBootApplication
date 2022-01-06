package com.PushAppNotificationDemo.Model;

import java.util.Map;

public class MyNotification {
	
	private String title;

	private String body;
	
	private Map<String,String> data;

	public MyNotification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyNotification(String title, String body, Map<String, String> data) {
		super();
		this.title = title;
		this.body = body;
		this.data = data;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Map<String, String> getData() {
		return data;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "MyNotification [title=" + title + ", body=" + body + ", data=" + data + "]";
	}
	
	

}
