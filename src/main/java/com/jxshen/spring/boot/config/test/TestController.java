package com.jxshen.spring.boot.config.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jxshen on 2018/07/23
 */
@RestController
public class TestController implements EnvironmentAware {

    @Autowired
    private SocietyConfig societyConfig;
    @Autowired
    private OrderConfig orderConfig;

    @RequestMapping
    public void print() {
        System.out.println(societyConfig.getPersons());
    }

    private Environment env;

    @Override
    public void setEnvironment(Environment environment) {
        env = environment;
    }
}
