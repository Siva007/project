package com.tcs.model;

import java.sql.Blob;

public class Image {
	Blob image;
	
	int length;
	
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	

}
