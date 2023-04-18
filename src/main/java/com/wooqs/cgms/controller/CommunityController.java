package com.wooqs.cgms.controller;

import com.wooqs.cgms.model.Community;
import com.wooqs.cgms.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    @GetMapping("/id/{id}")
    public ResponseEntity<Community> getById(@PathVariable Long id) {
        Community community = communityService.getById(id);
        if (community != null) {
            return new ResponseEntity<>(community, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 通过AdminID获取Community对象
    @GetMapping("/admin/{id}")
    public ResponseEntity<List<Community>> getByAdminId(@PathVariable String id) {
        List<Community> community = communityService.getByAdminId(Long.parseLong(id));
        if (community != null) {
            return new ResponseEntity<>(community, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 通过社区名称获取Community对象
    @GetMapping("/{name}")
    public ResponseEntity<List<Community>> search(@PathVariable String name) {
        List<Community> community = communityService.search(name);
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
        try{communityService.save(community);}
        catch(Exception MySQLIntegrityConstraintViolationException){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(community, HttpStatus.OK);
    }

    // 更新Community对象
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Community community) {
        community.setCommunityId(id);
        community.setUpdateTime(LocalDateTime.now());
        try{communityService.update(community);}
        catch(Exception MySQLIntegrityConstraintViolationException){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 删除Community对象
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        Community existingCommunity = communityService.getById(id);
        if (existingCommunity != null) {
            try{
                communityService.deleteById(id);
            }catch (Exception MySQLIntegrityConstraintViolationException){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
