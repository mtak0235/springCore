package seoul.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import seoul.core.member.Grade;
import seoul.core.member.Member;
import seoul.core.member.MemberService;
import seoul.core.member.MemberServiceImpl;
import seoul.core.order.OrderService;

public class MemberApp {
    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl(memberRepository);
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
        ApplicationContext ap = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ap.getBean("memberService", MemberService.class);
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = " + findMember.getName());
        System.out.println("memberA = " + memberA.getName());
    }
}
