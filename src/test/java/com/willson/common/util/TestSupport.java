package com.willson.common.util;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试辅助类
 * Created by Administrator on 2017/3/19 0019.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class TestSupport extends AbstractJUnit4SpringContextTests {
    protected long startTime;
    protected long endTime;

    /**
     * 记录 开始运行时间
     *
     * @return
     */
    protected long start() {
        this.startTime = System.currentTimeMillis();
        return startTime;
    }

    /**
     * 记录 结束运行时间
     *
     * @return
     */
    protected long end() {
        this.endTime = System.currentTimeMillis();
        this.log();
        return endTime;
    }

    /**
     * 输出记录
     */
    protected void log() {
        String text = "\n开始时间 : " + this.startTime + "\n结束时间 : " + this.endTime + "\n执行时间 : " + (this.endTime - this.startTime);
        logger.info(text);
    }
}
