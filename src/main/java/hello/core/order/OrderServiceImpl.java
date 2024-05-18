package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository; //레파지토리에서 회원 검색해야됨
    private final DiscountPolicy discountPolicy;// 정액 할인 정책
    // => 이렇게 코드를 만들면 어떤 클래스를 사용하여 MemberRepository, DiscountPolicy 객체가 만들어지는지 알 수 없기 때문에
    //    OrderServiceImpl 클래스는 추상화 역할만 가지고 있다는 것을 알 수 있다


    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
