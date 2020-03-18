package ru.kolyasnikovkv.discussion1c.hook;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by tomoya.
 * Copyright (c) 2018, All Rights Reserved.
 * https://yiiu.co
 */
public class TopicServiceHook {

    @Pointcut("execution(public * ru.kolyasnikovkv.discussion1c.service.ITopicService.search(..))")
    public void search() {
    }

    @Pointcut("execution(public * ru.kolyasnikovkv.discussion1c.service.ITopicService.selectAuthorOtherTopic(..))")
    public void selectAuthorOtherTopic() {
    }

    @Pointcut("execution(public * ru.kolyasnikovkv.discussion1c.service.ITopicService.selectByUserId(..))")
    public void selectByUserId() {
    }

    @Pointcut("execution(public * ru.kolyasnikovkv.discussion1c.service.ITopicService.insert(..))")
    public void insert() {
    }

    @Pointcut("execution(public * ru.kolyasnikovkv.discussion1c.service.ITopicService.selectById(..))")
    public void selectById() {
    }

    @Pointcut("execution(public * ru.kolyasnikovkv.discussion1c.service.ITopicService.selectByTitle(..))")
    public void selectByTitle() {
    }

    @Pointcut("execution(public * ru.kolyasnikovkv.discussion1c.service.ITopicService.update(..))")
    public void update() {
    }

    @Pointcut("execution(public * ru.kolyasnikovkv.discussion1c.service.ITopicService.delete(..))")
    public void delete() {
    }

    @Pointcut("execution(public * ru.kolyasnikovkv.discussion1c.service.ITopicService.deleteByUserId(..))")
    public void deleteByUserId() {
    }

    @Pointcut("execution(public * ru.kolyasnikovkv.discussion1c.service.ITopicService.vote(..))")
    public void vote() {
    }

    @Pointcut("execution(public * ru.kolyasnikovkv.discussion1c.service.ITopicService.updateViewCount(..))")
    public void updateViewCount() {
    }

}
