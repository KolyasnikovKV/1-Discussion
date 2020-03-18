package ru.kolyasnikovkv.discussion1c.hook;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by tomoya.
 * Copyright (c) 2018, All Rights Reserved.
 * https://yiiu.co
 */
public class UserServiceHook {

    @Pointcut("execution(public * ru.kolyasnikovkv.discussion1c.service.IUserService.selectByUsername(..))")
    public void selectByUsername() {
    }

    @Pointcut("execution(public * ru.kolyasnikovkv.discussion1c.service.IUserService.addUser(..))")
    public void addUser() {
    }

    @Pointcut("execution(public * ru.kolyasnikovkv.discussion1c.service.IUserService.addUserWithMobile(..))")
    public void addUserWithMobile() {
    }

    @Pointcut("execution(public * ru.kolyasnikovkv.discussion1c.service.IUserService.selectByToken(..))")
    public void selectByToken() {
    }

    @Pointcut("execution(public * ru.kolyasnikovkv.discussion1c.service.IUserService.selectByMobile(..))")
    public void selectByMobile() {
    }

    @Pointcut("execution(public * ru.kolyasnikovkv.discussion1c.service.IUserService.selectByEmail(..))")
    public void selectByEmail() {
    }

    @Pointcut("execution(public * ru.kolyasnikovkv.discussion1c.service.IUserService.selectById(..))")
    public void selectById() {
    }

    @Pointcut("execution(public * ru.kolyasnikovkv.discussion1c.service.IUserService.selectTop(..))")
    public void selectTop() {
    }

    @Pointcut("execution(public * ru.kolyasnikovkv.discussion1c.service.IUserService.update(..))")
    public void update() {
    }

    @Pointcut("execution(public * ru.kolyasnikovkv.discussion1c.service.IUserService.delRedisUser(..))")
    public void delRedisUser() {
    }

}
