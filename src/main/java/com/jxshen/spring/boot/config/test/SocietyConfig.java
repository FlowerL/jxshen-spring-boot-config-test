package com.jxshen.spring.boot.config.test;

import com.jxshen.spring.boot.config.test.dto.PersonDTO;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * yaml文件List<Map>类型映射
 *
 * @author jxshen on 2018/07/23
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "society")
public class SocietyConfig {
    private String partyName;
    private List<PersonDTO> persons;
}
