package zh.zh.provider;

public class UserProvider {
    public String getAllUserDatas(){
        String btn = "CONCAT(\"<div><button class=\\\"btn btn-primary\\\" onclick=\\\"update(\",1,\")\\\">修改</button></div>\") as button";
        String sql ="select *,"+btn+" from user";
        System.out.println(sql);
        return sql;
    }
    public String getUserSize(){
        String sql ="select count(0) from user";
        return sql;
    }
    public String getUserDataById(){
        String sql ="select * from user where id =#{id}";
        return sql;
    }
    public String addUserData(){
        String sql ="insert into user(name,gender,age,address,qq,email) values (#{name},#{gender},#{age},#{address},#{qq},#{email})";
        return sql;
    }
    public String updateUserDataById(){
        String sql ="update user set gender=#{gender},age=#{age},address=#{address},qq=#{qq},email=#{email} where name=#{name}";
        return sql;
    }
    public String deleteUserDataById(){
        String sql ="delete from user where id=#{id}";
        return sql;
    }
}
