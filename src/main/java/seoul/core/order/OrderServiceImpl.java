package seoul.core.order;

import seoul.core.discount.DiscountPolicy;
import seoul.core.discount.FixDiscountPolicy;
import seoul.core.discount.RateDiscountPolicy;
import seoul.core.member.Member;
import seoul.core.member.MemberRepository;
import seoul.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
//    private final MemberRepository  memberRepository= new MemoryMemberRepository();
    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private final DiscountPolicy discountPolicy;
    private final MemberRepository memberRepository;

    public OrderServiceImpl(DiscountPolicy discountPolicy, MemberRepository memberRepository) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }

    @Override

    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
