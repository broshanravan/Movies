package bl;

import java.util.Date;

import bl.Enums.Occupation;

public class User {
	private int UserId; 	
	private long twiterId;
	private int age;
	private String gender;
	private Occupation occupation;
	private String zipCode;
	
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public int getUserId() {
		return UserId;
	}
	
	public void setUserId(int userId) {
		UserId = userId;
	}
	
	public long getTwiterId() {
		return twiterId;
	}
	
	public void setTwiterId(long twiterId) {
		this.twiterId = twiterId;
	}	
	
	public void show(){
		System.out.println("UserId is: " + UserId);
		System.out.println("twiterId is: " + twiterId);
		System.out.println("age is: " + age);
		System.out.println("gender is: " + gender);
		System.out.println("occupation is: " + occupation);
		System.out.println("zipCode is: " + zipCode);
		
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Occupation getOccupation() {
		return occupation;
	}
	
	public void setOccupation(Occupation occupation) {
		this.occupation = occupation;
	}

	
	
	
}
