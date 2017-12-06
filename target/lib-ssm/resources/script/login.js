//javascript模块化
var login ={

    URL: {
        sign:function () {
            return '/lib/login';
        },

        signInUrl: function (stuID, password) {
            return '/lib/'+stuID + '/' + password + '/loginIn';
        },

        signOutUrl:function(){
            return '/lib/signOut'
        },

        myHomepageUrl: function () {
            return '/lib/stu/myHomepage';
        },
        
        registerPageUrl:function () {
            return '/lib/registerPage'
        },

        registerUrl:function (stuID) {
            return '/lib/'+stuID+'/register';
        }

    },

    init:{
        //登录验证
        sign: function () {

            $('#signInBtn').one('click', function () {
                var stuID = $('#user').val();
                var password =$('#password').val();
                var url = login.URL.signInUrl(stuID, password);
                console.log('user=' + stuID);//TODO 删除
                console.log('password=' + password);//TODO 删除
               // $('this').addClass('disabled');//禁用按钮
                //执行登录请求 返回ajax
                $.get(url, {}, function (result) {
                    if (result) {
                        if( result['success']){//登录成功 跳转页面
                            var infoUrl = login.URL.myHomepageUrl();
                            window.parent.location.href=infoUrl;//跳转页面
                        }
                        else{
                            //todo 错误文案信息抽取到前端字典里
                            var info = result['error'];
                            $('#loginMessage').hide().html(
                                '<label class="label label-danger"><em>'+info+'</em></label>').show(300);
                        }

                    } else {
                        console.log('result=' + result);//TODO 删除
                    }
                })
            });

            $('#signOutBtn').one('click',function () {
                $.get(login.URL.signOutUrl(),function () {
                    window.parent.location.href=login.URL.sign();//跳转页面
                });
            });

            //注册页面
            $('#registerBtn').one('click',function () {
                window.parent.location.href=login.URL.registerPageUrl();//跳转页面
            })
        },


        register:function () {

            //点击注册按钮
            $('#registerBtn').one('click',function () {
                var stuID = $('#user').val();
                var password = $('#password').val();
                var passwordSure = $('#passwordSure').val();
                if(password!=passwordSure){
                    $('#registerInfo').hide().html(
                        '<label class="label label-danger"><em>两次密码不一致</em></label>').show(300);
                }else{
                    //发送注册请求
                    $.get(login.URL.registerUrl(stuID),function (result) {
                        if(result){
                            if(result['success']){//注册成功跳转登录页面
                                window.parent.location.href=login.URL.sign();
                            }else{
                                var info = result['error'];
                                $('#registerInfo').hide().html(
                                    '<label class="label label-danger"><em>'+info+'</em></label>'
                                ).show(300)
                            }
                        }
                    })
                }
            })
        },
    }
}