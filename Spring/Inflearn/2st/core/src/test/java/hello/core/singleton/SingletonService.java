package hello.core.singleton;

public class SingletonService {
    // static == class level == only one
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }
    // 외부생성 불가하도록 private 생성자
    private SingletonService() {}
}
