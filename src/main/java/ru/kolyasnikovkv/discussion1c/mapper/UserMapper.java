package ru.kolyasnikovkv.discussion1c.mapper;

import ru.kolyasnikovkv.discussion1c.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * Created by tomoya.
 * Copyright (c) 2018, All Rights Reserved.
 * https://yiiu.co
 */
public interface UserMapper extends BaseMapper<User> {
    int countToday();
}
