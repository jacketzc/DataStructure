import org.junit.Test;
import test.Quote;

/**
 * 测试非学习内容
 */
public class Demo2 {


    private void transfer(Quote quote) {
        quote = new Quote();
    }
    @Test
    public void test1() {
        Quote quote = new Quote(20);
        transfer(quote);
        System.out.println(quote.getI());
    }
}
