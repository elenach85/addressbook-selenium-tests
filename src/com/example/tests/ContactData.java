package com.example.tests;

public class ContactData {
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
		this.last_name = last_name;
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
}