package com.example.fastcampusmysql.domain.member.entity;

import com.example.fastcampusmysql.util.MemberFixtureFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberTest {

    @Test
    @DisplayName("회원 닉네임 변경_테스트")
    void 회원_닉네임_변경_Test() throws Exception {
        //given
//        LongStream.range(0, 10)
//                .mapToObj(MemberFixtureFactory::create)
//                .forEach(member -> {
//                    System.out.println("member.getNickname() = " + member.getNickname());
//                });

        var member = MemberFixtureFactory.create();
        var expected = "pnu";

        //when
        member.changeNickname(expected);

        //then
        Assertions.assertEquals(expected, member.getNickname());
    }

    @Test
    @DisplayName("회원 닉네임 변경 시 10자 초과 시 예외_테스트")
    void 회원_닉네임_변경_길이_제한_Test() throws Exception {
        //given
        var member = MemberFixtureFactory.create();
        var overMaxLengthName = "pnupnupnupnu";

        //when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            member.changeNickname(overMaxLengthName);
        });

    }


}