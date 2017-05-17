package com.steven.redis.dao.impl;

import com.steven.redis.dao.CommonRedisDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * comRedisDao
 * Created by Steven on 2017/5/17.
 */
@Repository
public class CommonRedisDaoImpl implements CommonRedisDao {

    private final RedisTemplate<String, String> redisTemplate;
    /**
     * 日志记录
     */
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    /**
     * 前缀
     */
    private static final String KEY_PREFIX_VALUE = "info:steven:value:";
    private static final String KEY_PREFIX_SET = "info:steven:set:";
    private static final String KEY_PREFIX_LIST = "info:steven:list:";

    @Autowired
    public CommonRedisDaoImpl(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 缓存value操作
     * @param k
     * @param value
     * @param time
     * @return
     */
    @Override
    public boolean cacheValue(String k, String value, long time) {
        String key = KEY_PREFIX_VALUE + k;
        try{
            ValueOperations<String,String> valueOps = redisTemplate.opsForValue();
            valueOps.set(key, value);
            if (time > 0) redisTemplate.expire(key, time, TimeUnit.SECONDS);
            return true;
        }catch (Throwable t){
            LOGGER.error("缓存[" + key + "]失败, value[" + value + "]", t);
        }
        return false;
    }

    /**
     *  缓存value操作
     * @param key
     * @param value
     * @return
     */
    @Override
    public boolean cacheValue(String key, String value) {
        return cacheValue(key, value, -1);
    }

    /**
     *  判断缓存是否存在
     * @param key
     * @return
     */
    @Override
    public boolean containsValueKey(String key) {
        return containsKey(KEY_PREFIX_VALUE + key);
    }

    /**
     * 判断缓存是否存在
     * @param key
     * @return
     */
    @Override
    public boolean containsSetKey(String key)
    {
        return containsKey(KEY_PREFIX_VALUE + key);
    }

    /**
     * 判断缓存是否存在
     * @param key
     * @return
     */
    @Override
    public boolean containsListKey(String key) {
        return containsKey(KEY_PREFIX_LIST + key);
    }

    /**
     * 判断缓存是否存在
     * @param key
     * @return
     */
    @Override
    public boolean containsKey(String key) {
        try{
            return redisTemplate.hasKey(key);
        }catch (Throwable t){
            LOGGER.error("判断缓存存在失败key[" + key + ", Codeor[" + t + "]");
        }
        return false;
    }

    /**
     * 获取缓存
     * @param key
     * @return
     */
    @Override
    public String getValue(String key) {
        try{
            ValueOperations<String, String> valueOps = redisTemplate.opsForValue();
            return valueOps.get(KEY_PREFIX_VALUE + key);
        }catch (Throwable t){
            LOGGER.error("获取缓存失败key[" + KEY_PREFIX_VALUE + key + ", Codeor[" + t + "]");
        }
        return null;
    }

    /**
     * 移除缓存
     * @param key
     * @return
     */
    @Override
    public boolean removeValue(String key) {
        return remove(KEY_PREFIX_VALUE + key);
    }

    @Override
    public boolean removeSet(String key) {
        return remove(KEY_PREFIX_SET + key);
    }

    @Override
    public boolean removeList(String key) {
        return remove(KEY_PREFIX_LIST + key);
    }

    /**
     *  缓存set操作
     * @param k
     * @param value
     * @param time
     * @return
     */
    @Override
    public boolean cacheSet(String k, String value, long time) {
        String key = KEY_PREFIX_SET + k;
        try{
            SetOperations<String, String> valueOps = redisTemplate.opsForSet();
            valueOps.add(key, value);
            if (time > 0) redisTemplate.expire(key, time, TimeUnit.SECONDS);
            return true;
        }catch (Throwable t){
            LOGGER.error("缓存[" + key + "]失败, value[" + value + "]", t);
        }
        return false;
    }

    /**
     * 缓存set
     * @param k
     * @param v
     * @return
     */
    @Override
    public boolean cacheSet(String k, String v) {
        return cacheSet(k, v, -1);
    }

    /**
     * 缓存set
     * @param k
     * @param v
     * @param time
     * @return
     */
    @Override
    public boolean cacheSet(String k, Set<String> v, long time) {
        String key = KEY_PREFIX_SET + k;
        try {
            SetOperations<String, String> setOps = redisTemplate.opsForSet();
            setOps.add(key, v.toArray(new String[v.size()]));
            if (time > 0) redisTemplate.expire(key, time, TimeUnit.SECONDS);
            return true;
        } catch (Throwable t) {
            LOGGER.error("缓存[" + key + "]失败, value[" + v + "]", t);
        }
        return false;
    }

    /**
     * 缓存set
     * @param k
     * @param v
     * @return
     */
    @Override
    public boolean cacheSet(String k, Set<String> v) {
        return cacheSet(k, v, -1);
    }

    /**
     * 获取缓存set数据
     * @param k
     * @return
     */
    @Override
    public Set<String> getSet(String k) {
        try {
            SetOperations<String, String> setOps = redisTemplate.opsForSet();
            return setOps.members(KEY_PREFIX_SET + k);
        } catch (Throwable t) {
            LOGGER.error("获取set缓存失败key[" + KEY_PREFIX_SET + k + ", Codeor[" + t + "]");
        }
        return null;
    }

    /**
     * list缓存
     * @param k
     * @param v
     * @param time
     * @return
     */
    @Override
    public boolean cacheList(String k, String v, long time) {
        String key = KEY_PREFIX_LIST + k;
        try {
            ListOperations<String, String> listOps = redisTemplate.opsForList();
            listOps.rightPush(key, v);
            if (time > 0) redisTemplate.expire(key, time, TimeUnit.SECONDS);
            return true;
        } catch (Throwable t) {
            LOGGER.error("缓存[" + key + "]失败, value[" + v + "]", t);
        }
        return false;
    }

    /**
     * 缓存list
     * @param k
     * @param v
     * @return
     */
    @Override
    public boolean cacheList(String k, String v) {
        return cacheList(k, v, -1);
    }

    /**
     * 缓存list
     * @param k
     * @param v
     * @param time
     * @return
     */
    @Override
    public boolean cacheList(String k, List<String> v, long time) {
        String key = KEY_PREFIX_LIST + k;
        try {
            ListOperations<String, String> listOps = redisTemplate.opsForList();
            listOps.rightPushAll(key, v);
            if (time > 0) redisTemplate.expire(key, time, TimeUnit.SECONDS);
            return true;
        } catch (Throwable t) {
            LOGGER.error("缓存[" + key + "]失败, value[" + v + "]", t);
        }
        return false;
    }

    /**
     * 缓存list
     * @param k
     * @param v
     * @return
     */
    @Override
    public boolean cacheList(String k, List<String> v) {
        return cacheList(k, v, -1);
    }

    /**
     *  获取list缓存
     * @param k
     * @param start
     * @param end
     * @return
     */
    @Override
    public List<String> getList(String k, long start, long end) {
        try {
            ListOperations<String, String> listOps = redisTemplate.opsForList();
            return listOps.range(KEY_PREFIX_LIST + k, start, end);
        } catch (Throwable t) {
            LOGGER.error("获取list缓存失败key[" + KEY_PREFIX_LIST + k + ", Codeor[" + t + "]");
        }
        return null;
    }

    /**
     *  获取总条数, 可用于分页
     * @param k
     * @return
     */
    @Override
    public long getListSize(String k) {
        try {
            ListOperations<String, String> listOps = redisTemplate.opsForList();
            return listOps.size(KEY_PREFIX_LIST + k);
        } catch (Throwable t) {
            LOGGER.error("获取list长度失败key[" + KEY_PREFIX_LIST + k + "], Codeor[" + t + "]");
        }
        return 0;
    }

    /**
     * 获取总条数, 可用于分页
     * @param listOps
     * @param k
     * @return
     */
    @Override
    public long getListSize(ListOperations<String, String> listOps, String k) {
        try {
            return listOps.size(KEY_PREFIX_LIST + k);
        } catch (Throwable t) {
            LOGGER.error("获取list长度失败key[" + KEY_PREFIX_LIST + k + "], Codeor[" + t + "]");
        }
        return 0;
    }

    /**
     * 移除list缓存
     * @param k
     * @return
     */
    @Override
    public boolean removeOneOfList(String k) {
        String key = KEY_PREFIX_LIST + k;
        try {
            ListOperations<String, String> listOps = redisTemplate.opsForList();
            listOps.rightPop(key);
            return true;
        } catch (Throwable t) {
            LOGGER.error("移除list缓存失败key[" + KEY_PREFIX_LIST + k + ", Codeor[" + t + "]");
        }
        return false;
    }

    /**
     * 移除缓存
     *
     * @param key key
     * @return boolean
     */
    private boolean remove(String key) {
        try {
            redisTemplate.delete(key);
            return true;
        } catch (Throwable t) {
            LOGGER.error("获取缓存失败key[" + key + ", Codeor[" + t + "]");
        }
        return false;
    }

    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
        s.add("sss");
        s.add("ccc");
        System.out.println(s.toArray(new String[s.size()]));
    }

}
