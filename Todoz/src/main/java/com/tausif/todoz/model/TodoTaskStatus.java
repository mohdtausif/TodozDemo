package com.tausif.todoz.model;

public enum TodoTaskStatus {
	NEW("NEW"), INPROGRESS("INPROGRESS"), COMPLETED("COMPLETED");
	private String value;
	private TodoTaskStatus(String value)
	{
		this.value=value;
	}
	
	@Override
	public String toString() 
	{
		return value;
	}
}
