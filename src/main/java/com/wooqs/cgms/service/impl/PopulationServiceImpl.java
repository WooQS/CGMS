package com.wooqs.cgms.service.impl;

import com.wooqs.cgms.mapper.PopulationMapper;
import com.wooqs.cgms.model.Population;
import com.wooqs.cgms.service.PopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PopulationServiceImpl implements PopulationService {

    private final PopulationMapper populationMapper;

    @Autowired
    public PopulationServiceImpl(PopulationMapper populationMapper) {
        this.populationMapper = populationMapper;
    }
    // 获取所有人口信息
    @Override
    public List<Population> getAllPopulations() {
        return populationMapper.getAll();
    }
    // 根据ID获取人口信息
    @Override
    public Population getPopulationById(Long id) {
        return populationMapper.getById(id);
    }
    // 实现根据社区 ID 获取同一个社区的用户的方法
    @Override
    public List<Population> getPopulationByCommunityId(Long communityId) {
        return populationMapper.getByCommunityId(communityId);
    }
    // 添加人口信息
    @Override
    public void addPopulation(Population population) {
        populationMapper.insert(population);
    }
    // 更新人口信息
    @Override
    public void updatePopulation(Population population) {
        populationMapper.update(population);
    }
    // 根据ID删除人口信息
    @Override
    public void deletePopulationById(Long id) {
        populationMapper.deleteById(id);
    }
}
