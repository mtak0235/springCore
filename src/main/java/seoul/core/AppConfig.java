package seoul.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import seoul.core.discount.DiscountPolicy;
import seoul.core.discount.FixDiscountPolicy;
import seoul.core.discount.RateDiscountPolicy;
import seoul.core.member.MemberRepository;
import seoul.core.member.MemberService;
import seoul.core.member.MemberServiceImpl;
import seoul.core.member.MemoryMemberRepository;
import seoul.core.order.OrderService;
import seoul.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(DiscountPolicy(), memberRepository());
    }

    @Bean
    public DiscountPolicy DiscountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
