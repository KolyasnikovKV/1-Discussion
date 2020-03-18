package ru.kolyasnikovkv.discussion1c.service;

import ru.kolyasnikovkv.discussion1c.model.OAuthUser;

import java.util.List;

/**
 * Created by tomoya.
 * Copyright (c) 2018, All Rights Reserved.
 * https://yiiu.co
 */
public interface IOAuthUserService {
    OAuthUser selectByTypeAndLogin(String type, String login);

    List<OAuthUser> selectByUserId(Integer userId);

    void addOAuthUser(Integer oauthId, String type, String login, String accessToken, String bio, String email, Integer
            userId, String refreshToken, String unionId, String openId);

    void update(OAuthUser oAuthUser);
}
