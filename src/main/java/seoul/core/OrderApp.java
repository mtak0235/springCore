package seoul.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import seoul.core.member.Grade;
import seoul.core.member.Member;
import seoul.core.member.MemberService;
import seoul.core.member.MemberServiceImpl;
import seoul.core.order.Order;
import seoul.core.order.OrderService;
import seoul.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl(memberRepository);
//        OrderService orderService = new OrderServiceImpl();
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
    }
}
