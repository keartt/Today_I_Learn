package hello.core.member;

public class TestByJava {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();

        Member member = new Member(1L, "홍길동", Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        System.out.println(member == findMember);
        System.out.println(member.getGrade().getClass().getName());
        System.out.println(member.getName().getClass().getName());

    }
}
