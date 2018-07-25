package com.ssm.ashrayanepal.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="hostdetail")
public class HostDetails {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
	private Long hostId;
	@OneToOne(cascade=CascadeType.MERGE)
	private User user;
	private String hostName;
	
	private String address;
	private String familyType;
	private Long availableRoom;
	private String  photo;
	private String  identification;
	
	
	
	public Long getHostId() {
		return hostId;
	}
	public void setHostId(Long hostId) {
		this.hostId = hostId;
	}

	
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFamilyType() {
		return familyType;
	}
	public void setFamilyType(String familyType) {
		this.familyType = familyType;
	}
	
	public Long getAvailableRoom() {
		return availableRoom;
	}
	public void setAvailableRoom(Long availableRoom) {
		this.availableRoom = availableRoom;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	}
	
		
	

	

