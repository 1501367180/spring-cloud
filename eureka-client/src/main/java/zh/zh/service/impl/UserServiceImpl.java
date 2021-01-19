package zh.zh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zh.zh.entity.User;
import zh.zh.mapper.UserMapper;
import zh.zh.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public Map<String, Object> getAllUserDatas() {
        int total = userMapper.getUserSize();
        List<Map<String,Object>> rows =userMapper.getAllUserDatas();
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("total",total);
        dataMap.put("rows",rows);
        return dataMap;
    }

    @Override
    public Object addUserData(User user) {
        Boolean isAdd = userMapper.addUserData(user);
        if (isAdd){
            return 1+",添加成功";
        }else {
            return 0+",添加失败";
        }
    }

    @Override
    public Object deleteUserDataById(Integer id) {
        Boolean isDelete = userMapper.deleteUserDataById(id);
        if (isDelete){
            return 1+",删除成功";
        }else {
            return 0+",删除失败";
        }
    }

    @Override
    public Object updateUserDataById(User user) {
        Boolean isUpdate = userMapper.updateUserDataById(user);
        if (isUpdate){
            return 1+",修改成功";
        }else {
            return 0+",修改失败";
        }
    }

    @Override
    public String getUserDataById(Integer id) {
        return userMapper.getUserDataById(id);
    }
}
