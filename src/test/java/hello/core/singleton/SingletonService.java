package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService(); //static 영역에 객체를 하나만 생성한다
    // 자기 자신의 객체를 인스턴스에 하나만 생기도록 한다

    public static SingletonService getInstance(){
        return instance; // 만든 instance 조회
        // public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회할 수 있다
    }

    private SingletonService(){ //SingletonService 클래스 외부에서 new 키워드로 해당 객체를 생성하지 못하게 private으로 선언한다
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }


}