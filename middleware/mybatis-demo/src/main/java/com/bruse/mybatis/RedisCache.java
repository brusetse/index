package com.bruse.mybatis;

import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RedisCache implements Cache {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final String id; // cache instance id
    private RedisTemplate template;
    private static final long EXPIRE_TIME_IN_MINUTES = 30; // redis过期时间

    public RedisCache(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    /**
     * Put query result to redis
     *
     * @param key
     * @param value
     */
    @Override
    public void putObject(Object key, Object value) {
        RedisTemplate template = getRedisTemplate();
        ValueOperations operations = template.opsForValue();
        operations.set(key, value, EXPIRE_TIME_IN_MINUTES, TimeUnit.MINUTES);
        System.out.println("Put query result to redis");
    }

    /**
     * Get cached query result from redis
     *
     * @param key
     * @return
     */
    @Override
    public Object getObject(Object key) {
        RedisTemplate template = getRedisTemplate();
        ValueOperations operations = template.opsForValue();
        Object value = operations.get(key);
        System.out.println("Get cached query result from redis");
        return value;
    }

    /**
     * Remove cached query result from redis
     *
     * @param key
     * @return
     */
    @Override
    public Object removeObject(Object key) {
        RedisTemplate template = getRedisTemplate();
        template.delete(key);
        System.out.println("Remove cached query result from redis");
        return null;
    }

    /**
     * Clears this cache instance
     */
    @Override
    public void clear() {
        RedisTemplate template = getRedisTemplate();
        template.execute((RedisCallback) connection -> {
            connection.flushDb();
            return null;
        });
        System.out.println("Clear all the cached query result from redis");
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return lock;
    }

    private RedisTemplate getRedisTemplate() {
        if (template == null) {
            template = ApplicationContextHolder.getBean("redisTemplate");
        }
        return template;
    }
}
