package zh.zh.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import zh.zh.entity.User;
import zh.zh.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;

import static zh.zh.utils.zhUtils.*;

@Controller
//@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(HttpServletResponse response){
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
        response.setHeader("token",uuid);
        return "login";
    }

    @RequestMapping("/user")
    public String user(){
        return "user";
    }

    /*查询用户列表*/
    @ResponseBody
    @RequestMapping("/getAllUserDatas")
    public Map<String, Object> getAllUserDatas(){
        return userService.getAllUserDatas();
    }
    
    /*添加用户页面*/
    @ResponseBody
    @RequestMapping(value="/addUserData",method = RequestMethod.GET)
    public Object addUserData(User user){
        return userService.addUserData(user);
    }

    /*更新用户页面*/
    @ResponseBody
    @RequestMapping(value="/updateUserDataById",method = RequestMethod.GET)
    public Object updateUserDataById(User user){
        return userService.updateUserDataById(user);
    }
    
    /*删除用户*/
    @ResponseBody
    @RequestMapping(value="/deleteUserDataById",method = RequestMethod.GET)
    public Object deleteUserDataById(@RequestParam("id") Integer id){
        return userService.deleteUserDataById(id);
    }


    @RequestMapping("/download")
  public HttpServletResponse download(HttpServletResponse response) {
       String path = "G:\\Idea\\spring-cloud\\eureka-client\\src\\main\\resources\\static\\user/建筑用电数据.xls";
            try {
                   // path是指欲下载的文件的路径。
                   File file = new File(path);
                   // 取得文件名。
                   String filename = file.getName();
                   System.out.println(filename);
                   // 取得文件的后缀名。
                   String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

                   // 以流的形式下载文件。
                   InputStream fis = new BufferedInputStream(new FileInputStream(path));
                   byte[] buffer = new byte[fis.available()];
                   System.out.println("buffer:::"+buffer);
                   fis.read(buffer);
                   fis.close();
                   // 清空response
                   response.reset();
                   // 设置response的Header

                   response.addHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(filename, "utf-8")/* + new String(filename.getBytes("ISO8859-1"))*/);
                   response.addHeader("Content-Length", "" + file.length());
                   System.out.println("response.getOutputStream：："+response.getOutputStream());
                   OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
                   response.setContentType("application/octet-stream;charset=UTF-8");
                   toClient.write(buffer);
                   toClient.flush();
                   toClient.close();
                 } catch (IOException ex) {
                   ex.printStackTrace();
                 }
             return response;
    }
    @ResponseBody
    @RequestMapping("/getIp")
    public String getIp(HttpServletRequest request){
        return getIpAddr(request);
    }

}
