package com.example.fastcampusmysql.controller;

import com.example.fastcampusmysql.application.usacase.CreateFollowMemberUsacase;
import com.example.fastcampusmysql.application.usacase.GetFollowingMembersUsacase;
import com.example.fastcampusmysql.domain.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/follow")
public class FollowController {

    private final CreateFollowMemberUsacase createFollowMemberUsacase;

    private final GetFollowingMembersUsacase getFollowingMembersUsacase;

    @PostMapping("/{fromId}/{toId}")
    public void register(@PathVariable Long fromId, @PathVariable Long toId) {
        createFollowMemberUsacase.create(fromId, toId);
    }

    @GetMapping("/members/{fromId}")
    public List<MemberDto> register(@PathVariable Long fromId) {
        return getFollowingMembersUsacase.execute(fromId);
    }
}
