package com.gujiedmc.cloud.hystrix;

import com.gujiedmc.cloud.hoxton.common.entity.UserEntity;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gujiedmc
 * @date 2021-04-05
 */
public class UserRemoteService {

    public static final UserRemoteService USER_REMOTE_SERVICE = new UserRemoteService();

    public static final String SERVICE_NAME = "user";
    public static final HystrixCommandGroupKey USER_GROUP = HystrixCommandGroupKey.Factory.asKey(SERVICE_NAME);

    public UserEntity getUserInfo(Long userId) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);
        userEntity.setUsername("gujiedmc");
        userEntity.setPassword("123456");
        userEntity.setAge(28);
        return userEntity;
    }

    public List<UserEntity> getUserInfoBatch(Long[] userId) {
        return Arrays.stream(userId)
                .map(this::getUserInfo)
                .collect(Collectors.toList());
    }

    public UserEntity getDefaultUserInfo(Long userId) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);
        userEntity.setUsername("default");
        userEntity.setPassword("default");
        userEntity.setAge(0);
        return userEntity;
    }

    public List<UserEntity> getDefaultUserInfoBatch(Long[] userId) {
        return Arrays.stream(userId)
                .map(this::getDefaultUserInfo)
                .collect(Collectors.toList());
    }
}
