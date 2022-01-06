package com.PushAppNotificationDemo.Model;

import java.util.List;
import java.util.Map;

public class MyNotification2 {
	
	private String title;

	private String body;
	
	private Map<String,String> data;
	
	private List<String> tags;

	public MyNotification2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyNotification2(String title, String body, Map<String, String> data, List<String> tags) {
		super();
		this.title = title;
		this.body = body;
		this.data = data;
		this.tags = tags;
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

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "MyNotification2 [title=" + title + ", body=" + body + ", data=" + data + ", tags=" + tags + "]";
	}

	
	
	

}
