package com.trip.project.controller.user;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.trip.project.dto.comment.CommentDto;
import com.trip.project.dto.user.UserDto;
import com.trip.project.dto.user.UserFileDto;
import com.trip.project.service.jwt.JwtServiceImpl;
import com.trip.project.service.user.UserService;

import io.swagger.annotations.ApiParam;
import javax.servlet.http.Cookie;

@RestController
@RequestMapping("/user")
//@CrossOrigin("*")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*", allowCredentials = "true")
public class UserController {
    
    public static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
    @Autowired
    private UserService userService;
    
    @Autowired
	private JwtServiceImpl jwtService;
	
    @PostMapping("/join")
    public int join(@RequestBody UserDto user ) throws Exception{
    	
        System.out.println(user);
        return userService.join(user);
        
        
    }
    
    @PostMapping("/login")
    public ResponseEntity<Map<String,Object>> login(@RequestBody UserDto user) throws Exception{
    	System.out.print(user);
    	Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			UserDto loginUser = userService.login(user);
			if (loginUser != null) {
				String token = jwtService.create("userid", loginUser.getUserAccount(), "access-token");// key, data, subject
				logger.debug("로그인 토큰정보 : {}", token);
				resultMap.put("access-token", token);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("로그인 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);        
    }
    @GetMapping("/info/{userId}")
	public ResponseEntity<Map<String, Object>> getInfo(
			@PathVariable("userId") @ApiParam(value = "인증할 회원의 아이디.", required = true) String userid,
			HttpServletRequest request) {
    	logger.debug("userid : {} ", userid);
    	System.out.println("나는 나는ㄴ ㅏㄴ ㅋㅋㅋㅋ");
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;

		if (jwtService.isUsable(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			try {
//				로그인 사용자 정보.
				UserDto memberDto = userService.getUserOne(userid);
				resultMap.put("userInfo", memberDto);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.error("정보조회 실패 : {}", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			logger.error("사용 불가능 토큰!!!");
			resultMap.put("message", FAIL);
			status = HttpStatus.ACCEPTED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
    
    @GetMapping("/viewMyPage/{userId}")
    public UserDto viewMypage(@PathVariable("userId") long userId) throws Exception{
    	
        return userService.viewMypage(userId);        
    }
    
    @DeleteMapping("delete/{userId}")
    public int deleteUser(@PathVariable("userId") long userId) throws Exception {
        return userService.deleteLike(userId);
    }
    
    @PostMapping("/viewMyPage/image/{userId}")
    public ResponseEntity<String> addImage(@PathVariable("userId") long userid,@RequestPart(value = "uploadedfiles", required = false) MultipartFile uploadedfiles) throws IllegalStateException, IOException {
    	if(userService.addImage(userid,uploadedfiles)) {
    		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
    	}
    	return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/login/oauth2/test")
    
    public ResponseEntity<?> loginData(HttpServletRequest req) {
    
    	System.out.println("여기까지?");
    	HttpSession session = req.getSession();
    	System.out.println(session.getAttribute("loginData"));
//    	System.out.println(session.getAttribute("test"));
//
//    	
//        String data = (String) session.getAttribute("myData");
//        System.out.println(data);
//    	
//    	Cookie[] cookies = req.getCookies();
//    	  
//    	  for(Cookie c : cookies) {
//    	  	System.out.println(c.getName());  // 쿠키 이름 가져오기
//    	  	System.out.println(c.getValue());  // 쿠키 값 가져오기
//    	  }
      	Map<String, Object> resultMap = new HashMap<>();
      	resultMap = (Map<String, Object>) session.getAttribute("loginData");

      	System.out.println(resultMap);
      	if(resultMap.size()>0)
      		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.ACCEPTED);    
      	else 
        	return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
    }
    
    @PostMapping("/modify/{userId}")
    public ResponseEntity<?> updateMemberInfo(@PathVariable("userId") int userid, @RequestPart(value = "user") UserDto user,  @RequestPart(value = "uploadedfiles", required = false) MultipartFile[] uploadedfiles) throws IllegalStateException, IOException {
     
        	System.out.println("ㅁㄴㅇㄴㅁ"+user);
        	userService.updateMemberInfo(userid, user);
//            
            userService.uploadUerImg(userid, user, uploadedfiles);
            
            return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
         
    }
    
    //사용자 image가져오기
    @GetMapping("/userimage/{userId}")
    public ResponseEntity<?> updateMemberInfo(@PathVariable("userId") int userId) {
    	System.out.println("사용자  이미지 좀 가져오자");
    	UserFileDto  userimgFile = userService.getUserImage(userId);
    	return new ResponseEntity<UserFileDto>(userimgFile, HttpStatus.OK);
    }
    
}