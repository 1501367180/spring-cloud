
function login() {
    let username = $("#username").val();
    let password = $("#password").val();
    console.log(username);
    console.log(password)
    $.ajax({
        url:"/auth-service/login",
        data:{
            auth_user_username:username,
            auth_user_password:password,
        },
        type:"post",
        success(data){
            console.log(data);
            //json字符串转为json对象
            var datas = JSON.parse(data);
            console.log(datas.errcode)
            if (datas.errcode==1){
                window.location.href = "/zh/user/user"
            }else if (datas.errcode==0){
                alert("账号或密码错误！")
            }
        }
    })
}