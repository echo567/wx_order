package cn.junhui.wx_order;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 军辉
 * 2019-04-01 16:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

    //一定要写当前类的类名
    //private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);
    //或者使用注解 @Slf4j

    @Test
    public void testLevel() {
        log.debug("debug...");
        log.info("info...");
        log.error("error...");

        String name = "123";
        String password = "pass";
        log.info("name:{},password:{}", name, password);
    }
}
