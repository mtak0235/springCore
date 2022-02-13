package seoul.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import seoul.core.AppConfig;
import seoul.core.member.Grade;
import seoul.core.member.Member;
import seoul.core.member.MemberService;


class MemberServiceTest {

    //    MemberService memberService = new MemberServiceImpl(memberRepository);
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    @Test
    void join() {
        Member member = new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        Assertions.assertThat(member).isEqualTo(findMember);
    }

    @Test
    void findMember() {
    }
}