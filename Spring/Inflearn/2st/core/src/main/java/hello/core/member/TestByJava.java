package hello.core.member;

import hello.core.AppConfig;

public class TestByJava {
    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl();
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L, "홍길동", Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        System.out.println(member == findMember);
        System.out.println(member.getGrade());
        System.out.println(member.getName());
    }
}
