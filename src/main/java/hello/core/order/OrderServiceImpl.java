package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository(); //레파지토리에서 회원 검색해야됨
    private DiscountPolicy discountPolicy;// 정액 할인 정책 --> 이거 지금 연결점이 없음 여기부터 다시 시작해야됨
    // 현재 상황 : createOrder에서 쓰려고 하는 discountPolicy 객체와 연결된 discount클래스가 없다 -> AppConfig로 연결해야됨

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
