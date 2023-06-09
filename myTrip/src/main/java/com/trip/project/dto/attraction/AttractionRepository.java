package com.trip.project.dto.attraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AttractionRepository {
	
	
	public List<Attraction> attractionListByType(int type);
	public List<Attraction> attractionListByAddr(@Param("sido")int sido, @Param("gugun")int gugun);
	public List<Attraction> attractionListByAddr_type(@Param("sido")int sido, @Param("gugun")int gugun, @Param("type")int type);
	public List<Attraction> attractionListByAddr_Title(@Param("sido")int sido,  @Param("gugun")int gugun, @Param("searchData")String string);
	public List<Attraction> attractionListByAddr_Type_Title(@Param("sido")int sido,  @Param("gugun")int gugun, @Param("type")int type, @Param("searchData")String string);
	public List<Attraction> attractionListByTitle(String searchData);
	public List<Attraction> attractionListByTitle_Type(@Param("type")int type,  @Param("searchData")String string);
	
//	public List<Attraction> attractionListByaddrAndTitle(@Param("sido")int sido, @Param("gugun")int gugun, @Param("searchData")String searchData);
	
	RouteDistanceDto isRoute(Integer point);



	public int attrictionListCnt_type(int type);
	public int attrictionListCnt_addr(@Param("sido")int sido,  @Param("gugun")int gugun);
	public int attrictionListCnt_addr_type(@Param("sido")int sido,  @Param("gugun")int gugun, @Param("type")Integer type);
	public int attrictionListCnt_addr_title(@Param("sido")int sido,  @Param("gugun")int gugun, @Param("searchData")String searchData);
	public int attrictionListCnt_addr_title_type(@Param("sido")int sido,  @Param("gugun")int gugun, @Param("searchData")String searchData, @Param("type")Integer type);
	public int attrictionListCnt_title(String searchData);
	public int attrictionListCnt_title_type(@Param("searchData")String searchData, @Param("type")Integer type);

	public List<Attraction> attractionListPage_type(@Param("type")int type, @Param("start")int start, @Param("listsize")int listsize);
	public List<Attraction> attractionListPage_addr(@Param("sido")int sido,  @Param("gugun")int gugun, @Param("start")int start, @Param("listsize")int listsize);
	public List<Attraction> attractionListPage_addr_type(@Param("sido")int sido,  @Param("gugun")int gugun, @Param("type")Integer type, @Param("start")int start, @Param("listsize")int listsize);
	public List<Attraction> attractionListPage_addr_title(@Param("sido")int sido,  @Param("gugun")int gugun, @Param("searchData")String searchData, @Param("start")int start, @Param("listsize")int listsize);
	public List<Attraction> attractionListPage_addr_title_type(@Param("sido")int sido,  @Param("gugun")int gugun, @Param("searchData")String searchData, @Param("type")Integer type, @Param("start")int start, @Param("listsize")int listsize);
	public List<Attraction> attractionListPage_title(@Param("searchData")String searchData, @Param("start")int start, @Param("listsize")int listsize);
	public List<Attraction> attractionListPage_title_type(@Param("searchData")String searchData, @Param("type")Integer type, @Param("start")int start, @Param("listsize")int listsize);
	
	
	public int likeCount(int contentId);
	
	public Attraction selectOne(int contentId);
	
	//public List<AttractionNear> nearList(@Param("min_lat")double min_lat, @Param("max_lat")double max_lat, @Param("min_lng")double min_lng, @Param("max_lng")double max_lng);
	public List<AttractionNear> nearList(Map<String, Double> map);
	public ArrayList<Integer> getTopLike();

	public List<SidoGugunCodeDto> getSido();
	public List<SidoGugunCodeDto> getGugunInSido(String sido);
	public Map<String,Object> getAddrName(@Param("sido")int sido, @Param("gugun")int gugun);
	public Map<String, Object> getRandomSido();
	public Map<String, Object> getRandomGugun(int sido_code);
	public List<Map<String, Object>> getAllGugun(int sido_code);
	public List<Attraction> getRandomAttraction(@Param("sidoCode")int sidoCode, @Param("gugunCode")int gugunCode);
	public int findSido(int gugun_code);
	public List<Attraction> getDetailAttraction(@Param("sidoCode")int sidoCode, @Param("gugunCode")int gugunCode, @Param("content_type_id")int content_type_id);

	

}