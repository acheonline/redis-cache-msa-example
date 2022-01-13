package ru.achernyavskiy0n.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.achernyavskiy0n.model.Numbers;
import ru.achernyavskiy0n.repository.RedisCacheMsaRepository;

import java.util.List;

@Service
@CacheConfig(cacheNames = {"numbers"}, keyGenerator = "redisCacheMsaKeyGenerator")
public class RedisCacheMsaService {

    @Autowired
    private RedisCacheMsaRepository simpleRepository;

    @Cacheable(key = "#id", unless = "#result == null")
    public Numbers getValueById(Long id) {
        return this.simpleRepository.findById(id).orElse(null);
    }


    @Cacheable
    public List<Numbers> getAll() {
        return simpleRepository.findAll();
    }

    @CacheEvict(key="#val.id")
    public Numbers add(Numbers val) {
        return this.simpleRepository.save(val);
    }
}
