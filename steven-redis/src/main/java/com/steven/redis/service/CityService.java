package com.steven.redis.service;

import com.steven.redis.entity.CityInfo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * Created by Steven on 2017/5/17.
 */
@Component
@Cacheable(cacheNames="CityService")
public class CityService {
    @Cacheable
    public CityInfo getCity(int id, String city) {
        return new CityInfo(id, city);
    }
}
