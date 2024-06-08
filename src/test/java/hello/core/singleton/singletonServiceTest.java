package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class singletonServiceTest {

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService2 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

//        singletonService2 = hello.core.singleton.SingletonService@376a0d86
//        singletonService2 = hello.core.singleton.SingletonService@376a0d86
//        같은 객체가 출력된다

        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
        // same(주소값을 비교) != equal(내용을 비교)

    }
}
