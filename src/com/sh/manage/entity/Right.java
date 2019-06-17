package com.sh.manage.entity;

import java.io.Serializable;

public class Right implements Serializable {
	
	private int rightId;
	private String rightName;
	
	public Right() {
		super();
	}

	public int getRightId() {
		return rightId;
	}

	public void setRightId(int rightId) {
		this.rightId = rightId;
	}

	public String getRightName() {
		return rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName;
	}

}
