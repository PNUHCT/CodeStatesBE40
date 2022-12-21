package com.codestates.member.dto;

import com.codestates.stamp.Stamp;
import lombok.AllArgsConstructor;
import lombok.Getter;

// 수정
public class MemberDto {
    @AllArgsConstructor
    @Getter
    public static class Response {
        private long memberId;
        private String email;
        private Stamp stamp;

        public int getStamp() {
            return stamp.getStampCount();
        }
    }
}
