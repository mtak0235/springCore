package seoul.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import seoul.core.AppConfig;


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