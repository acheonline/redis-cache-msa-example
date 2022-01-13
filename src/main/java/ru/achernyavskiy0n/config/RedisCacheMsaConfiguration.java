package ru.achernyavskiy0n.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({PersistenceConfiguration.class, RedisConfiguration.class})
public class RedisCacheMsaConfiguration {
}
