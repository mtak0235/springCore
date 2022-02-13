package seoul.core.discount;

import seoul.core.member.Grade;
import seoul.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {
    private int discountRate = 10;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountRate / 100;
        }
        return 0;
    }
}
