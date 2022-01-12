package org.comstudy.Ex05;

import java.util.Vector;

// bin
public class SaramDTO {
	private int idx;
	private String name;
	private String email;
	private String phone;
	
	public SaramDTO() {
		this(0,"","","");
	}

	public SaramDTO(int idx, String name, String email, String phone) {
		this.idx = idx;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "SaramDTO [" + idx + ", " + name + ", " + email + ", " + phone + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idx;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaramDTO other = (SaramDTO) obj;
		if (idx != other.idx)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	

	public Vector toVector() {
		Vector vector = new Vector();
		vector.add(idx);
		vector.add(name);
		vector.add(email);
		vector.add(phone);
		return vector;
	}
	
	
	

}
