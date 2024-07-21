package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("주문테스트")
public class OrderServiceTest {
//    private final MemberService memberService = new MemberServiceImpl();
//    private final OrderService orderService = new OrderServiceImpl();
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void 할인가격테스트() {
        Long memberId = 1L;
        Member member = new Member(memberId, "James", Grade.VIP);
        memberService.join(member);

        int itemPrice = 20000;

        Order order = orderService.createOrder(memberId, "itemA", itemPrice);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo((int)(itemPrice * 0.1));
    }



}
