package ru.kolyasnikovkv.discussion1c.hook;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by tomoya.
 * Copyright (c) 2018, All Rights Reserved.
 * https://yiiu.co
 */
public class IndexedServiceHook {

    @Pointcut("execution(public * ru.kolyasnikovkv.discussion1c.service.IIndexedService.indexAllTopic(..))")
    public void indexAllTopic() {
    }

    @Pointcut("execution(public * ru.kolyasnikovkv.discussion1c.service.IIndexedService.indexTopic(..))")
    public void indexTopic() {
    }

    @Pointcut("execution(public * ru.kolyasnikovkv.discussion1c.service.IIndexedService.deleteTopicIndex(..))")
    public void deleteTopicIndex() {
    }

    @Pointcut("execution(public * ru.kolyasnikovkv.discussion1c.service.IIndexedService.batchDeleteIndex(..))")
    public void batchDeleteIndex() {
    }

}
