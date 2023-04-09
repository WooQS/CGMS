package com.wooqs.cgms.service;

import com.wooqs.cgms.model.Log;

import java.util.List;

public interface LogService {
    //获取所有日志信息
    List<Log> getAllLogs();
    //根据ID获取日志信息
    Log getLogById(Long id);
    //添加日志信息
    void addLog(Log log);
    //根据ID删除日志信息
    void deleteLogById(Long id);
}
