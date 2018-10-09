package com.xlily6x.client;

import com.xlily6x.client.util.MainUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.util.Map;

/**
 * @program: xlily6x-server-client
 * @description: test
 * @author: xiaowenlong
 * @create: 2018-09-28
 **/
public class XTest {

    private static Log logger = LogFactory.getLog(XTest.class);
    @Test
    public void test(){
        Map<String,String> m = MainUtil.resolveArgs(new String[]{"--server.host=10.205.35.35","--server.port=61025"});
        logger.info(m);
    }
}
