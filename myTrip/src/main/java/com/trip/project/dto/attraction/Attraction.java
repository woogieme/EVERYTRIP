package com.trip.project.dto.attraction;

import lombok.NoArgsConstructor;

public class Attraction {
	
	private int contentId;
	private int type;
	//private int contentTypeID;
	private String title;
	private String addr;
	private String tel;
	private String firstImage;
	private String firstImage2;
	private int readcount;
	private int content_type_id;
	public int getContent_type_id() {
		return content_type_id;
	}



	public void setContent_type_id(int content_type_id) {
		this.content_type_id = content_type_id;
	}



	private int sideCode;
	private int gugunCode;
//	
	private String sidoName;
	private String gugunName;
	
	private double latitude;
	private double longitude;
	
	private String homepage;
	private String overview;
	
	private double rating;//댓글 평점
	private int likeCheck; //좋아요 순
	
	
	
	public Attraction() {
		super();
	}



	public Attraction(int contentId, String title, String addr, String tel, String firstImage, String firstImage2,
			int readcount, int sideCode, int gugunCode, double latitude, double longitude, String homepage,
			String overview) {
		super();
		this.contentId = contentId;
		this.title = title;
		this.addr = addr;
		this.tel = tel;
		this.firstImage = firstImage;
		this.firstImage2 = firstImage2;
		this.readcount = readcount;
		this.sideCode = sideCode;
		this.gugunCode = gugunCode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.homepage = homepage;
		this.overview = overview;

	}

	


	public int getContentId() {
		return contentId;
	}



	public void setContentId(int contentId) {
		this.contentId = contentId;
	}



	public int getType() {
		return type;
	}



	public void setType(int type) {
		this.type = type;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getAddr() {
		return addr;
	}



	public void setAddr(String addr) {
		this.addr = addr;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public String getFirstImage() {
		return firstImage;
	}



	public void setFirstImage(String firstImage) {
		this.firstImage = firstImage;
	}



	public String getFirstImage2() {
		return firstImage2;
	}



	public void setFirstImage2(String firstImage2) {
		this.firstImage2 = firstImage2;
	}



	public int getReadcount() {
		return readcount;
	}



	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}



	public int getSideCode() {
		return sideCode;
	}



	public void setSideCode(int sideCode) {
		this.sideCode = sideCode;
	}



	public int getGugunCode() {
		return gugunCode;
	}



	public void setGugunCode(int gugunCode) {
		this.gugunCode = gugunCode;
	}



	public double getLatitude() {
		return latitude;
	}



	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}



	public double getLongitude() {
		return longitude;
	}



	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}



	public String getHomepage() {
		return homepage;
	}



	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}



	public String getOverview() {
		return overview;
	}



	public void setOverview(String overview) {
		this.overview = overview;
	}


	

	public double getRating() {
		return rating;
	}



	public void setRating(double rating) {
		this.rating = rating;
	}



	public int getLikeCheck() {
		return likeCheck;
	}



	public void setLikeCheck(int likeCheck) {
		this.likeCheck = likeCheck;
	}






	public String getSidoName() {
		return sidoName;
	}



	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}



	public String getGugunName() {
		return gugunName;
	}



	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}



	@Override
	public String toString() {
		return "Attraction [contentId=" + contentId + ", title=" + title + ", addr=" + addr + ", tel=" + tel
				+ ", firstImage=" + firstImage + ", firstImage2=" + firstImage2 + ", readcount=" + readcount
				+ ", sideCode=" + sideCode + ", gugunCode=" + gugunCode + ", latitude=" + latitude + ", longitude="
				+ longitude + ", homepage=" + homepage + ", overview=" + overview + "]\n";
	}



	

	
	//private String telname;\
	
	
	

}
