package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@DisplayName("Configuration 확인")
public class ConfigurationSingletonTest {
    @Test
    @DisplayName("싱글톤 여부 확인")
    public void test() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository msMemberRepository = memberService.getMemberRepository();
        MemberRepository osMemberRepository = orderService.getMemberRepository();
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        Assertions.assertThat(msMemberRepository).isSameAs(osMemberRepository).isSameAs(memberRepository);
    }

    @Test
    @DisplayName("AppConfig 빈타입 확인")
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig appConfig = ac.getBean(AppConfig.class);

        Assertions.assertThat(appConfig.getClass().getName()).contains("CGLIB");
    }
}
