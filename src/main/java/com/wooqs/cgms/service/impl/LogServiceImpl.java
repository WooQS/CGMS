package com.wooqs.cgms.service.impl;

import com.wooqs.cgms.mapper.LogMapper;
import com.wooqs.cgms.model.Log;
import com.wooqs.cgms.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    private final LogMapper logMapper;

    @Autowired
    public LogServiceImpl(LogMapper logMapper) {
        this.logMapper = logMapper;
    }
    //获取所有日志信息
    @Override
    public List<Log> getAllLogs() {
        return logMapper.getAll();
    }
    //根据ID获取日志信息
    @Override
    public Log getLogById(Long id) {
        return logMapper.getById(id);
    }
    //添加日志信息
    @Override
    public void addLog(Log log) {
        logMapper.insert(log);
    }
    //根据ID删除日志信息
    @Override
    public void deleteLogById(Long id) {
        logMapper.deleteById(id);
    }
}
