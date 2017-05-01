package com.oh.my.news.business.write.manage;

import com.oh.my.news.model.dto.UserSnapshot;
import com.oh.my.news.model.vo.User;

import java.util.List;

/**
 * Created by shj on 2017/5/1.
 */
public interface UserWriteManage {
    void register(User user)throws Exception;

}
