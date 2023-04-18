package com.wooqs.cgms.service.impl;

import com.wooqs.cgms.mapper.CommunityMapper;
import com.wooqs.cgms.model.Community;
import com.wooqs.cgms.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityServiceImpl implements CommunityService {

    private final CommunityMapper communityMapper;

    @Autowired
    public CommunityServiceImpl(CommunityMapper communityMapper) {
        this.communityMapper = communityMapper;
    }
    //根据ID获取社区信息
    @Override
    public Community getById(Long id) {
        return communityMapper.getById(id);
    }

    //根据ID获取社区信息
    @Override
    public List<Community> getByAdminId(Long AdminId) {
        return communityMapper.getByAdminId(AdminId);
    }

    //根据社区名称搜索社区信息
    @Override
    public List<Community> search(String name) {
        return communityMapper.search(name);
    }

    //获取所有社区信息列表
    @Override
    public List<Community> getAll() {
        return communityMapper.getAll();
    }
    //保存社区信息
    @Override
    public void save(Community community) {
        communityMapper.insert(community);
    }
    //更新社区信息
    @Override
    public void update(Community community) {
        communityMapper.update(community);
    }
    //根据ID删除社区信息
    @Override
    public void deleteById(Long id) {
        communityMapper.deleteById(id);
    }
}
