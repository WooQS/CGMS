package com.wooqs.cgms.controller;

import com.wooqs.cgms.model.Community;
import com.wooqs.cgms.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/communities")
public class CommunityController {

    private CommunityService communityService;

    // 使用构造器注入依赖的CommunityService实例
    @Autowired
    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }

    // 通过ID获取Community对象
    @GetMapping("/{id}")
    public ResponseEntity<Community> getById(@PathVariable Long id) {
        Community community = communityService.getById(id);
        if (community != null) {
            return new ResponseEntity<>(community, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 获取所有Community对象
    @GetMapping
    public List<Community> getAll() {
        return communityService.getAll();
    }

    // 保存Community对象
    @PostMapping
    public ResponseEntity<Community> save(@RequestBody Community community) {
        communityService.save(community);
        return new ResponseEntity<>(community, HttpStatus.CREATED);
    }

    // 更新Community对象
    @PutMapping("/{id}")
    public ResponseEntity<Community> update(@PathVariable Long id, @RequestBody Community community) {
        Community existingCommunity = communityService.getById(id);
        if (existingCommunity != null) {
            existingCommunity.setName(community.getName());
            communityService.update(existingCommunity);
            return new ResponseEntity<>(existingCommunity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 删除Community对象
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        Community existingCommunity = communityService.getById(id);
        if (existingCommunity != null) {
            communityService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
