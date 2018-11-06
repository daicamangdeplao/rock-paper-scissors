package com.luv2code.entity;

public class Action {

	private Integer type;

	public Action() {
	}

	public Action(Integer type) {
		super();
		this.type = type;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public int compares(Action action) {
		return Math.abs(this.type - action.getType());
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null)
			return false;

		if (!(obj instanceof Action))
			return false;

		if (obj == this)
			return true;

		return this.getType() == ((Action) obj).getType();
	}

	@Override
	public int hashCode() {
		return this.type;
	}

}
