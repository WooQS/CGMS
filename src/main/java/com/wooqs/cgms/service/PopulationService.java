package com.wooqs.cgms.service;

import com.wooqs.cgms.model.Population;

import java.util.List;

public interface PopulationService {
    // 获取所有人口信息
    List<Population> getAllPopulations();
    // 根据ID获取人口信息
    Population getPopulationById(Long id);
    // 根据社区ID获取人口信息
    List<Population> getPopulationByCommunityId(Long id);

    // 根据姓名获取人口信息
    List<Population> search(String name, Long communityId);
    // 添加人口信息
    void addPopulation(Population population);
    // 更新人口信息
    void updatePopulation(Population population);
    // 根据ID删除人口信息
    void deletePopulationById(Long id);
}
