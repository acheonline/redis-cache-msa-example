package ru.achernyavskiy0n.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.achernyavskiy0n.cache.CustomKeyGenerator;


@EnableCaching
@Configuration
@Import({PersistenceConfiguration.class})
public class RedisConfiguration {

    @Bean("redisCacheMsaKeyGenerator")
    public KeyGenerator keyGenerator() {
        return new CustomKeyGenerator();
    }
}
