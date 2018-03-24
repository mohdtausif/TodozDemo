package com.tausif.todoz.model;

public enum EntityStatus {
	ACTIVE("ACTIVE"), DELETED("DELETED"), ARCHIVED("ARCHIVED");
	private String value;
	private EntityStatus(String value)
	{
		this.value=value;
	}
	
	@Override
	public String toString() 
	{
		return value;
	}
}
