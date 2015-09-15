package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	public String first_name;
	public String last_name;
	public String address_1;
	public String home_tel;
	public String mobile_tel;
	public String work_tel;
	public String email;
	public String email2;
	public String birth_day;
	public String birth_month;
	public String birth_year;
	public String group_name;
	public String address_2;
	public String phone_2;

	public ContactData(String first_name, String last_name, String address_1, String home_tel, String mobile_tel,
			String work_tel, String email,String email2, String birth_day, String birth_month, String birth_year, String group_name,
			String address_2, String phone_2) {
		this.first_name = first_name;
		this.last_name=last_name;
		this.address_1 = address_1;
		this.home_tel = home_tel;
		this.mobile_tel = mobile_tel;
		this.work_tel = work_tel;
		this.email = email;
		this.birth_day = birth_day;
		this.birth_month = birth_month;
		this.birth_year = birth_year;
		this.group_name = group_name;
		this.address_2 = address_2;
		this.phone_2 = phone_2;
	}
	public ContactData(){
		
	}

	
	
	
//	@Override
	//public String toString() {
		//return "ContactData [first_name=" + first_name + ", last_name=" + last_name + ", home_tel=" + home_tel
			//	+ ", email=" + email + "]";
	//}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((home_tel == null) ? 0 : home_tel.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		return result;
	}
	@Override
	public String toString() {
		return "ContactData [first_name=" + first_name + ", last_name=" + last_name + ", address_1=" + address_1
				+ ", home_tel=" + home_tel + ", mobile_tel=" + mobile_tel + ", work_tel=" + work_tel + ", email="
				+ email + ", email2=" + email2 + ", birth_day=" + birth_day + ", birth_month=" + birth_month
				+ ", birth_year=" + birth_year + ", group_name=" + group_name + ", address_2=" + address_2
				+ ", phone_2=" + phone_2 + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.trim().equals(other.email.trim()))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.trim().equals(other.first_name.trim()))
			return false;
		if (home_tel == null) {
			if (other.home_tel != null)
				return false;
		} else if (!home_tel.trim().equals(other.home_tel.trim()))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.trim().equals(other.last_name.trim()))
			return false;
		return true;
	}
	@Override
	public int compareTo(ContactData other) {
	return this.last_name.toLowerCase().compareTo(other.last_name.toLowerCase());
	}
	
	
}