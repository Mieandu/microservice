package demo;

import com.mieandu.contentservice.ContentServiceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author mandu
 * @version 1.0
 * @date 2019/2/20 14:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ContentServiceApplication.class)
@WebAppConfiguration
@DirtiesContext
public class ModuleApplicationTests {

   /* @Autowired
    private Sink sink;*/

    @Test
    public void contextLoads() {
        //assertNotNull(this.sink.input());
    }

}