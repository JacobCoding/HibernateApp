package com.kuba.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String youtubelChannel;
	
	@Column(name="hobby")
	private String hobby;

	public InstructorDetail() {
	}

	public InstructorDetail(String youtubelChannel, String hobby) {
		this.youtubelChannel = youtubelChannel;
		this.hobby = hobby;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubelChannel() {
		return youtubelChannel;
	}

	public void setYoutubelChannel(String youtubelChannel) {
		this.youtubelChannel = youtubelChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubelChannel=" + youtubelChannel + ", hobby=" + hobby + "]";
	}
	
	
	
}
