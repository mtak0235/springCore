package seoul.core.discount;

import seoul.core.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);

}
