package com.bysj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author framework
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class BYSJApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(BYSJApplication.class, args);
        System.out.println("server started!!!");
    }
}