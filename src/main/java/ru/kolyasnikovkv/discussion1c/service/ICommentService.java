package ru.kolyasnikovkv.discussion1c.service;

import ru.kolyasnikovkv.discussion1c.model.Comment;
import ru.kolyasnikovkv.discussion1c.model.Topic;
import ru.kolyasnikovkv.discussion1c.model.User;
import ru.kolyasnikovkv.discussion1c.model.vo.CommentsByTopic;
import ru.kolyasnikovkv.discussion1c.util.MyPage;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by tomoya.
 * Copyright (c) 2018, All Rights Reserved.
 * https://yiiu.co
 */
public interface ICommentService {
    // 根据话题id查询评论
    List<CommentsByTopic> selectByTopicId(Integer topicId);

    // 删除话题时删除相关的评论
    void deleteByTopicId(Integer topicId);

    // 根据用户id删除评论记录
    void deleteByUserId(Integer userId);

    // 保存评论
    Comment insert(Comment comment, Topic topic, User user, HttpSession session);

    Comment selectById(Integer id);

    // 更新评论
    void update(Comment comment);

    // 对评论点赞
    int vote(Comment comment, User user, HttpSession session);

    // 删除评论
    void delete(Comment comment, HttpSession session);

    // 查询用户的评论
    MyPage<Map<String, Object>> selectByUserId(Integer userId, Integer pageNo, Integer pageSize);

    MyPage<Map<String, Object>> selectAllForAdmin(Integer pageNo, String startDate, String endDate, String username);

    // 查询今天新增的话题数
    int countToday();
}
