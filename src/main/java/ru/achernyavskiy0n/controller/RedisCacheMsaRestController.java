package ru.achernyavskiy0n.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.achernyavskiy0n.model.Numbers;
import ru.achernyavskiy0n.service.RedisCacheMsaService;

import java.util.List;

@RestController
@RequestMapping("value")
public class RedisCacheMsaRestController {

    @Autowired
    private RedisCacheMsaService service;

    @GetMapping("/{id}")
    public ResponseEntity<Numbers> getValueById(@PathVariable("id") String id) {
        Long _id = Long.valueOf(id);
        Numbers value = this.service.getValueById(_id);
        return ResponseEntity.ok(value);
    }

    @GetMapping("/")
    public ResponseEntity<List<Numbers>> getAllValues() {
        List<Numbers> values = this.service.getAll();
        return ResponseEntity.ok(values);
    }

    @PostMapping("/")
    public ResponseEntity<Numbers> addValue(@RequestBody Numbers val) {
        Numbers created = this.service.add(val);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
