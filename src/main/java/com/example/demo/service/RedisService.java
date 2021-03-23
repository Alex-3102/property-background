package com.example.demo.service;

import java.util.List;
import java.util.Set;

public interface RedisService {

    /**
     * 储存数据，默认过期时间一周
     * @param key 键
     * @param value 值
     */
    void set(String key, Object value);

    /**
     * 存储数据
     * @param key 键
     * @param value 值
     * @param expireTime 过期时间
     */
    void set(String key, Object value, long expireTime);

    /**
     * 判断是否存在key
     * @param key 键
     * @return
     */
    boolean exists(final String key);

    /**
     * 获取对应的数据
     * @param key 键
     * @return
     */
    String get(String key);

    /**
     * 获取对应的对象
     * @param key 键
     * @param clazz 目标对象类型
     * @param <T>
     * @return
     */
    <T> T get(String key, Class<T> clazz);

    /**
     * 获取 list 对应 value
     * @param key 键
     * @return
     */
    List<String> getList(String key);

    /**
     * 获取 list 对应 value
     * @param key 键
     * @param l 左范围
     * @param r 右范围
     * @return
     */
    List<String> getListByRange(String key, long l, long r);

    /**
     * 删除对应的value
     * @param key 键
     */
    void delete(String key);

    /**
     * 获取 list 对应 value
     * @param key 键
     * @param clazz 目标对象类型
     * @param <T>
     * @return
     */
    <T> List<T> getList(String key, Class<T> clazz);

    /**
     * 获取 list 对应范围的 value
     * @param key 键
     * @param clazz 目标对象类型
     * @param l 左范围
     * @param r 右范围
     * @param <T>
     * @return
     */
    <T> List<T> getListByRange(String key, Class<T> clazz, long l, long r);

    /**
     * 获取list的大小
     * @param key 键
     * @return
     */
    long getListSize(String key);

    /**
     * 将某个对象加入特定的list里面
     * @param key 键
     * @param object 对象
     * @return
     * */
    long addList(String key, Object object);


    /**
     * 将从特定的list里面移除
     * @param key 键
     * @param object 对象
     * @return
     * */
    long listRemove(String key, Object object);

    /**
     * 根据 key 从队头加入元素
     * @param key 键
     * @param value 值
     * @return
     */
    long lpush(final String key, Object value);

    /**
     * 根据 key 清空整个list
     * @param key 键
     * @return
     */
    void listClear(String key);

    /**
     * 指定缓存失效时间
     * @param key 键
     * @param expireTime 过期时间
     * @return
     */
    boolean expire(String key, long expireTime);

    /**
     * 根据 key 从队头加入元素，并设置过期时间
     * @param key 键
     * @param value 值
     * @param expireTime 过期时间
     * @return
     */
    long lpush(final String key, Object value, long expireTime);

    /**
     * 根据 key 从队尾加入元素
     * @param key 键
     * @param value 值
     * @return
     */
    long rpush(final String key, Object value);

    /**
     * 根据 key 从队尾加入元素，并设置过期时间
     * @param key 键
     * @param value 值
     * @param expireTime 过期时间
     * @return
     */
    long rpush(final String key, Object value, long expireTime);

    /**
     * 依据 key 出队
     * @param key 键
     * @return 值
     */
    String lpop(final String key);

    /**
     * 依据key获取Set的值
     * @param key 键
     * @return
     */
    Set<String> sGet(String key);

    /**
     * 判断value是否在set里面
     * @param key 键
     * @param value 值
     * @return true 存在 false 不存在
     */
    boolean sHasKey(String key, Object value);

    /**
     * 将数据放入set缓存
     * @param key 键
     * @param values 值
     * @return 成功个数
     */
    long sSet(String key, String... values);

    /**
     * 将set数据放入缓存
     * @param key    键
     * @param time   时间(秒)
     * @param values 值 可以是多个
     * @return 成功个数
     */
    long sSetAndTime(String key, long time, String... values);

    /**
     * 获取set缓存的长度
     *
     * @param key 键
     * @return
     */
    long sGetSetSize(String key);

    /**
     * 移除值为value的
     *
     * @param key    键
     * @param values 值 可以是多个
     * @return 移除的个数
     */
    long setRemove(String key, Object... values);

    /**
     * 存储位图第offset的值为value
     * @param key
     * @param offset
     * @param value
     * @return
     */
    boolean setBit(String key, long offset, Boolean value);

    /**
     * 获取位图第offset的值
     * @param key
     * @param offset
     * @return
     */
    boolean getBit(String key, long offset);

    /**
     * 获取位图上的数量
     * @param key
     * @return
     */
    long bitCount(String key);



}
