package com.redhat.training;

public class TodoItem {

	private String item;
	private String status;
	
	public TodoItem(String item,String status)
	{
		this.item=item;
		this.status=status;
	}
	public TodoItem()
	{

	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}
