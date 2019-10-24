import com.xx.sbc.DemoWebApplication;
import com.xx.sbc.module1.service.HelloService;
import com.xx.sbc.web1.response.HelloResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@WebAppConfiguration // 开启web应用配置
@SpringBootTest
@ContextConfiguration(classes = DemoWebApplication.class)
public class DemoApplicationTests {

    @Autowired
    private HelloService helloService;

    @Autowired
    private Environment environment;

    @Test
    public void test() {
//        System.out.println(environment.getProperty("eureka.serviceUrl.default"));
        HelloResponse response = helloService.hello(0L);
        System.out.println(response.getName());
    }
}