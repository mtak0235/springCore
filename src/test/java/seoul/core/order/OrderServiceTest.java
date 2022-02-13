package seoul.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import seoul.core.AppConfig;
import seoul.core.member.Grade;
import seoul.core.member.Member;
import seoul.core.member.MemberService;
import seoul.core.member.MemberServiceImpl;

class OrderServiceTest {

    //    MemberService memberService = new MemberServiceImpl(memberRepository);
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
//    OrderService orderService = new OrderServiceImpl();
    OrderService orderService = appConfig.orderService();
    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}