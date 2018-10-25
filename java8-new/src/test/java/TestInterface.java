import com.java8.entity.Persion;
import com.java8.interfaces.PredicateLambda;
import org.junit.Test;

/**
 * @author misterWei
 * @create 2018年10月24号:21点41分
 * @mailbox mynameisweiyan@gmail.com
 */
public class TestInterface {

    @Test
    public void testInterface(){
        Persion persion = new Persion();
        //使用接口中的 方法
        Integer integer = persion.returnInt(50, 30);
        System.out.println(integer);
        String interface中的staticMethod = PredicateLambda.returnString("interface中的staticMethod");
        System.out.println(interface中的staticMethod);
    }
}
