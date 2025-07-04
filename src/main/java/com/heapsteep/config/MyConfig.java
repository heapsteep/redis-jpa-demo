package com.heapsteep.config;

// Uncomment the following lines if you want to use Redis instead of Hazelcast:
/*import com.hazelcast.config.MapConfig;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import java.time.Duration;

@Configuration
public class MyConfig {

    @Bean
    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
        return (builder) -> builder
                .withCacheConfiguration("cacheStore",
                        RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(5)));
    }
}*/

// Hazelcast configuration:

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public Config hazelcastConfig() {
        return new Config()
                .addMapConfig(new MapConfig()
                        .setName("cacheStore")
                        .setTimeToLiveSeconds(300)); // 5 minutes TTL
    }
}
