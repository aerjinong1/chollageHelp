package com.collage.wxz.mapper;

import com.collage.wxz.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /**
     *
     * @param user
     * @return 受影响行数
     */
    Integer insert(User user);

    User findByStudentId(int studentId);

    Integer login(User user);


}
