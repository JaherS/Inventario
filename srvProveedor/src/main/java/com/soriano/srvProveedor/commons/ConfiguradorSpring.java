package com.soriano.srvProveedor.commons;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.soriano.srvProveedor")
@PropertySource("classpath:application.properties")
public class ConfiguradorSpring {
}
