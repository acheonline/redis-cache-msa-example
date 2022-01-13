package ru.achernyavskiy0n.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.achernyavskiy0n.model.Numbers;

public interface RedisCacheMsaRepository extends JpaRepository<Numbers, Long> {
}
