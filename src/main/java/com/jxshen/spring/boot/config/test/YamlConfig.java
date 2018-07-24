package com.jxshen.spring.boot.config.test;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * 加载自定义yaml文件配置类<br>
 * SpringBoot的@PropertySource只能加载.properties文件<br>
 * SpringBoot的@ConfigurationProperties在1.2.0版本后去掉了locations的属性，也不能引入yaml文件<br>
 * 可以通过YamlPropertiesFactoryBean和YamlMapFactoryBean两个类实现YAML配置文件的加载。前者将文件加载为Properties，后者为Map<br>
 * 也可以通过YamlPropertySourceLoader做到
 *
 * @author jxshen on 2018/07/24
 */
@Configuration
public class YamlConfig {

    @Bean
    public PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("config/society.yml"),
                new ClassPathResource("config/order.yml"));
        propertySourcesPlaceholderConfigurer.setProperties(yaml.getObject());
        return propertySourcesPlaceholderConfigurer;
    }
}
