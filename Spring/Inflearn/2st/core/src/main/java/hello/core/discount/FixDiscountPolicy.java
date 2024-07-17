package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

/**
 * 정액 할인 정책 - 무조건 천원할인
 */
public class FixDiscountPolicy implements DiscountPolicy {

    private int discount = 1000;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discount;
        } else{
            return 0;
        }
    }
}
