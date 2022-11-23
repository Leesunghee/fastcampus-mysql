package com.example.fastcampusmysql.application.usacase;

import com.example.fastcampusmysql.domain.member.dto.MemberDto;
import com.example.fastcampusmysql.domain.member.entity.Follow;
import com.example.fastcampusmysql.domain.member.service.FollowReadService;
import com.example.fastcampusmysql.domain.member.service.MemberReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GetFollowingMembersUsacase {

    private final MemberReadService memberReadService;
    private final FollowReadService followReadService;

    public List<MemberDto> execute(Long memberId) {
        /*
            1. fromMemberId = memberId -> Follow list
            2. 순번을 순회하면서 회원정보를 찾으면 된다.
         */
        var followings = followReadService.getFollowings(memberId);
        var followingMemberIds = followings.stream().map(Follow::getToMemberId).collect(Collectors.toList());
        return memberReadService.getMembers(followingMemberIds);
    }
}
