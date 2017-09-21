package com.code1j.base;

import com.code1j.base.service.BaseServiceImpl;
import com.code1j.base.service.IBaseService;
import org.slf4j.Logger;

/**
 * @ wuhui
 * @ date  2017/9/19下午5:04
 */
public class TestServiceImpl extends BaseServiceImpl<Test>  implements ITestService{


    public static void main(String[] args) {
        ITestService testService = new TestServiceImpl();
        Logger logger = testService.getLogger();

        logger.error("sssss");

    }


}
