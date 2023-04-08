package com.wooqs.cgms.service;

import com.wooqs.cgms.mapper.CommunityMapper;
import com.wooqs.cgms.model.Community;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminCommunityService {

    @Autowired
    private CommunityMapper communityMapper;

    /**
     * 根据社区ID获取社区信息
     *
     * @param id 社区ID
     * @return Community对象
     */
    public Community getCommunityById(Long id) {
        return communityMapper.getById(id);
    }

    /**
     * 获取所有社区信息
     *
     * @return 社区信息列表
     */
    public List<Community> getAllCommunities() {
        return communityMapper.getAll();
    }

    /**
     * 创建新的社区信息
     *
     * @param community 社区信息
     */
    public void createCommunity(Community community) {
        communityMapper.insert(community);
    }

    /**
     * 更新社区信息
     *
     * @param community 社区信息
     */
    public void updateCommunity(Community community) {
        communityMapper.update(community);
    }

    /**
     * 根据社区ID删除社区信息
     *
     * @param id 社区ID
     */
    public void deleteCommunityById(Long id) {
        communityMapper.deleteById(id);
    }
}
