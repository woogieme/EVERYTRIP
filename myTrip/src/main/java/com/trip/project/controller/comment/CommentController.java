package com.trip.project.controller.comment;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.trip.project.dto.comment.CommentDto;
import com.trip.project.service.comment.CommentService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private CommentService service;
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	//댓글 가져오기
	@ApiOperation(value = "댓글 목록", notes = "새로운 댓글 정보(파일포함)를 가져온다.", response = List.class)
	@GetMapping("/{contentId}")
	public ResponseEntity<?>getComment(@PathVariable("contentId") int contentId){
		List<CommentDto> list = service.selectList(contentId);;
		return new ResponseEntity<List<CommentDto>>(list, HttpStatus.OK);
	}
	
	
	//댓글쓰기
	@ApiOperation(value = "댓글 작성", notes = "새로운 댓글 정보와 파일을 저장한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping("/{userId}")
	public ResponseEntity<String> writeComment(@PathVariable("userId") long userId, @RequestPart(value = "comment") CommentDto comment,  @RequestPart(value = "uploadedfiles", required = false) MultipartFile[] uploadedfiles) throws IllegalStateException, IOException {	
		
		comment.setUserId(userId);
		System.out.println("댓글쓰기: "+comment);
		if ( service.insert(comment, uploadedfiles)) 
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	
	}
	
	
	
	
}