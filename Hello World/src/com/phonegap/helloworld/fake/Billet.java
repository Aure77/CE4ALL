package com.phonegap.helloworld.fake;

public class Billet {
	public enum Type {
		BARRE_CODE,
		QR_CODE;
	}
	
	private int id;
	private String title;
	private String validity;
	private String text;
	private float price;
	private Type type;
	private String imageUrl;
	
	public Billet() {
	}

	public Billet(int id, String title, String validity, String text, float price, Type type, String imageUrl) {
		super();
		this.id = id;
		this.title = title;
		this.validity = validity;
		this.text = text;
		this.price = price;
		this.type = type;
		this.imageUrl = imageUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Billet [id=" + id + ", title=" + title + ", validity="
				+ validity + ", text=" + text + ", price=" + price + ", type="
				+ type + ", imageUrl=" + imageUrl + "]";
	}	
}
