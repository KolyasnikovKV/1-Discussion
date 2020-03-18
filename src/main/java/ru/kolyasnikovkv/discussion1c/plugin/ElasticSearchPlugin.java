package ru.kolyasnikovkv.discussion1c.plugin;

import ru.kolyasnikovkv.discussion1c.mapper.TopicMapper;
import ru.kolyasnikovkv.discussion1c.model.Topic;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by tomoya.
 * Copyright (c) 2018, All Rights Reserved.
 * https://yiiu.co
 */
@Component
@Aspect
public class ElasticSearchPlugin {

    @Autowired
    private ElasticSearchService elasticSearchService;
    @Autowired
    private TopicMapper topicMapper;

    @Around("ru.kolyasnikovkv.discussion1c.hook.TopicServiceHook.search()")
    public Object search(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        if (elasticSearchService.instance() == null) return proceedingJoinPoint.proceed(args);
        return elasticSearchService.searchDocument((Integer) args[0], (Integer) args[1], (String) args[2], "title", "content");
    }

    @After("ru.kolyasnikovkv.discussion1c.hook.IndexedServiceHook.indexAllTopic()")
    public void indexAllTopic() {
        if (elasticSearchService.instance() != null) {
            List<Topic> topics = topicMapper.selectList(null);
            Map<String, Map<String, Object>> sources = topics.stream().collect(Collectors.toMap(key -> String.valueOf(key
                    .getId()), value -> {
                Map<String, Object> map = new HashMap<>();
                map.put("title", value.getTitle());
                map.put("content", value.getContent());
                return map;
            }));
            elasticSearchService.bulkDocument("topic", sources);
        }
    }

    @After("ru.kolyasnikovkv.discussion1c.hook.IndexedServiceHook.indexTopic()")
    public void indexTopic(JoinPoint joinPoint) {
        if (elasticSearchService.instance() != null) {
            Object[] args = joinPoint.getArgs();
            Map<String, Object> source = new HashMap<>();
            source.put("title", args[1]);
            source.put("content", args[2]);
            elasticSearchService.createDocument("topic", (String) args[0], source);
        }
    }

    @After("ru.kolyasnikovkv.discussion1c.hook.IndexedServiceHook.deleteTopicIndex()")
    public void deleteTopicIndex(JoinPoint joinPoint) {
        if (elasticSearchService.instance() != null) {
            elasticSearchService.deleteDocument("topic", (String) joinPoint.getArgs()[0]);
        }
    }

    @After("ru.kolyasnikovkv.discussion1c.hook.IndexedServiceHook.batchDeleteIndex()")
    public void batchDeleteIndex(JoinPoint joinPoint) {
        if (elasticSearchService.instance() != null) {
            List<Topic> topics = topicMapper.selectList(null);
            List<Integer> ids = topics.stream().map(Topic::getId).collect(Collectors.toList());
            elasticSearchService.bulkDeleteDocument("topic", ids);
        }
    }
}
