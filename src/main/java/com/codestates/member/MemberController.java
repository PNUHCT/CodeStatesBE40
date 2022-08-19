package com.codestates.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/members")
public class MemberController {
    private final Map<Long, Map<String, Object>> members = new HashMap<>();

    @PostConstruct
    public void init() {
        Map<String, Object> member1 = new HashMap<>();
        long memberId = 1L;
        member1.put("memberId", memberId);
        member1.put("email", "hgd@gmail.com");
        member1.put("name", "홍길동");
        member1.put("phone", "010-1234-5678");

        members.put(memberId, member1);
    }

    //---------------- 여기서 부터 아래에 코드를 구현하세요! -------------------//
    // 1. 회원 정보 수정을 위한 핸들러 메서드 구현
    // 메서드에서 멤버 아이디를 고정시키는 방법
    @PatchMapping
    public ResponseEntity updatePhone(@RequestParam("phone") String phone){
        members.get(1L).put("phone", phone);
        return new ResponseEntity<>(members,HttpStatus.OK);
    }

    // URL 자체에 멤버 아이디 넣어주는 방법 1
    @PatchMapping ("/{memberId}")
    public ResponseEntity updatePhone(@PathVariable("memberId") long memberId, @RequestParam("phone") String phone){
        members.get(memberId).put("phone", phone);
        return new ResponseEntity<>(members,HttpStatus.OK);
    }

//    // URL 자체에 멤버 아이디 넣어주는 방법 2
//    @PatchMapping ("/{memberId}")
//    public ResponseEntity updatePhone(@PathVariable("memberId") long memberId, @RequestParam("phone") String phone){
//        Map<String, Object> memberA = members.get(memberId);
//        memberA.put("phone", phone);
//        return new ResponseEntity<>(members,HttpStatus.OK);
//    }

    // 2. 회원 정보 삭제를 위한 핸들러 메서드 구현 (ver clear)
    @DeleteMapping
    public ResponseEntity deleteMember() {
        members.clear();
        return new ResponseEntity<>(members, HttpStatus.NO_CONTENT);
    }

    // 3. 회원 정보 삭제를 위한 핸들러 메서드 구현 (ver remove)
    @DeleteMapping
    public ResponseEntity deleteMember(@RequestParam("memberId") long memberId) {
        members.remove(memberId);
        return new ResponseEntity<>(members, HttpStatus.NO_CONTENT);
    }
}