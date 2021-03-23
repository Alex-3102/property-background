package com.example.demo.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {

    private static final long WEEK_SECONDS = 60 * 60 * 24 * 7;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void set(String key, Object value) {
        if (value instanceof String || value instanceof Number) {
            redisTemplate.opsForValue().set(key, String.valueOf(value), WEEK_SECONDS, TimeUnit.SECONDS);
        } else {
            redisTemplate.opsForValue().set(key, JSON.toJSONString(value), WEEK_SECONDS, TimeUnit.SECONDS);
        }
    }

    @Override
    public void set(String key, Object value, long expireTime) {
        if (value instanceof String || value instanceof Number) {
            redisTemplate.opsForValue().set(key, String.valueOf(value), expireTime, TimeUnit.SECONDS);
        } else {
            redisTemplate.opsForValue().set(key, JSON.toJSONString(value), expireTime, TimeUnit.SECONDS);
        }
    }

    @Override
    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public <T> T get(String key, Class<T> clazz) {
        String sValue = get(key);
        if (sValue == null) {
            try {
                Method method = clazz.getMethod("valueOf", new Class[]{String.class});
                return (T) method.invoke(null, new Object[]{"0"});
            } catch (Exception e) {
                return null;
            }
        }
        return JSON.parseObject(sValue, clazz);
    }

    @Override
    public List<String> getList(String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    @Override
    public List<String> getListByRange(String key, long l, long r) {
        return redisTemplate.opsForList().range(key, l, r);
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public <T> List<T> getList(String key, Class<T> clazz) {
        List<String> jsonList = getList(key);
        List<T> correntList = new ArrayList<>();
        if (jsonList != null) {
            for (String json: jsonList) {
                correntList.add(JSON.parseObject(json, clazz));
            }
            return correntList;
        }
        return null;
    }

    @Override
    public <T> List<T> getListByRange(String key, Class<T> clazz, long l, long r) {
        List<String> jsonList = getList(key);
        List<T> correntList = new ArrayList<>();
        if (jsonList != null) {
            for (String json: jsonList) {
                correntList.add(JSON.parseObject(json, clazz));
            }
            return correntList;
        }
        return null;
    }

    @Override
    public long getListSize(String key) {
        return redisTemplate.opsForList().size(key);
    }

    @Override
    public long addList(String key, Object object) {
        if (object instanceof String || object instanceof Number) {
            redisTemplate.opsForList().leftPush(key, String.valueOf(object));
        } else {
            redisTemplate.opsForList().leftPush(key, JSON.toJSONString(object));
        }

        return redisTemplate.opsForList().size(key);
    }

    @Override
    public long listRemove(String key,  Object object) {
        boolean flag = false;
        String objectString = JSON.toJSONString(object);
        List<String> list = getList(key);
        for(String s: list){
            if(s.equals(objectString)){
                flag = true;
            }
        }
        if(!flag){
            return -1L;
        }
        return redisTemplate.opsForList().remove(key, 0, objectString);
    }

    @Override
    public long lpush(String key, Object value) {
        final String sValue = JSON.toJSONString(value);
        long result = redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                long count = redisConnection.lPush(serializer.serialize(key), serializer.serialize(sValue));
                return count;
            }
        });
        return result;
    }

    @Override
    public void listClear(String key) {
        while(redisTemplate.opsForList().size(key) != 0){
            redisTemplate.opsForList().leftPop(key);
        }
    }

    @Override
    public boolean expire(String key, long expireTime) {
        try {
            if (expireTime > 0) {
                redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public long lpush(String key, Object value, long expireTime) {
        long result = lpush(key, value);
        expire(key, expireTime);
        return result;
    }

    @Override
    public long rpush(String key, Object value) {
        final String sValue = JSON.toJSONString(value);
        long result = redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                long count = redisConnection.rPush(serializer.serialize(key), serializer.serialize(sValue));
                return count;
            }
        });
        return result;
    }

    @Override
    public long rpush(String key, Object value, long expireTime) {
        long result = rpush(key, value);
        expire(key, expireTime);
        return result;
    }

    @Override
    public String lpop(String key) {
        String result = redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                byte[] res = redisConnection.lPop(serializer.serialize(key));
                return serializer.deserialize(res);
            }
        });
        return result;
    }

    @Override
    public Set<String> sGet(String key) {
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean sHasKey(String key, Object value) {
        try {
            return redisTemplate.opsForSet().isMember(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public long sSet(String key, String... values) {
        try {
            return redisTemplate.opsForSet().add(key, values);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public long sSetAndTime(String key, long time, String... values) {
        try {
            Long count = redisTemplate.opsForSet().add(key, values);
            if (time > 0) {
                expire(key, time);
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public long sGetSetSize(String key) {
        try {
            return redisTemplate.opsForSet().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public long setRemove(String key, Object... values) {
        try {
            Long count = redisTemplate.opsForSet().remove(key, values);
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public boolean setBit(String key, long offset, Boolean value) {
        return redisTemplate.opsForValue().setBit(key, offset, value);
    }

    @Override
    public boolean getBit(String key, long offset) {
        return redisTemplate.opsForValue().getBit(key, offset);
    }

    @Override
    public long bitCount(String key) {
        return redisTemplate.execute((RedisCallback<Long>) con -> con.bitCount(key.getBytes()));
    }
}
