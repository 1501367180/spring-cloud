package zh.zh.service;

import java.util.Map;


import org.springframework.stereotype.Service;
import zh.zh.entity.User;

public interface UserService {

    public Map<String, Object> getAllUserDatas();

    public Object addUserData(User user);

    public Object deleteUserDataById(Integer id);

    public Object updateUserDataById(User user);

    public String getUserDataById(Integer id);
}
