package com.blog.dao;

import com.blog.entity.Blogger;
import org.apache.ibatis.annotations.Param;

/**
 * 博主
 */
public interface BloggerDao {
    /**根据登录名查询博主对象*/
    public Blogger getByUserName(@Param("userName")String userName);

    /**更新博主对象*/
    public Integer update(Blogger blogger);

    /**查询博主对象*/
    public Blogger find();
}
