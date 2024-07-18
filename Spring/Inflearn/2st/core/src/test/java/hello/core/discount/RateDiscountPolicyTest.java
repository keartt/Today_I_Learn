package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("비율 할인테스트")
class RateDiscountPolicyTest {
    DiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 는 10% 할인")
    void 브이아이피_확인() {
        Member member = new Member(1L, "홍길동", Grade.VIP);
        int discount = rateDiscountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP 아니면 할인 NO")
    void noVIP() {
        Member member = new Member(1L, "홍길동", Grade.BASIC);
        int discount = rateDiscountPolicy.discount(member, 10000);
        assertThat(discount).isEqualTo(0);
    }
}