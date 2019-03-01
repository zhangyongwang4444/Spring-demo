package hello;


// 定义处理Web请求的结果 对象
// 结果返回对象


//  Spring 会自动调用这个类的 getter 方法 ，去获得成员变量的值，然后构造一个 json 的返回结果
public class Greeting {
    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public int test() {
        int a = 1;
        int b = 2;
        return a + b;
    }
}



