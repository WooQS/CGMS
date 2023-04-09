package com.wooqs.cgms.service;

import com.wooqs.cgms.model.Community;

import java.util.List;

public interface CommunityService {
    //根据ID获取社区信息
    Community getById(Long id);
    //获取所有社区信息列表
    List<Community> getAll();
    //保存社区信息
    void save(Community community);
    //更新社区信息
    void update(Community community);
    //根据ID删除社区信息
    void deleteById(Long id);
}
