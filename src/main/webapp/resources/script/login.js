//javascriptģ�黯
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
        //��¼��֤
        sign: function () {

            $('#signInBtn').one('click', function () {
                var stuID = $('#user').val();
                var password =$('#password').val();
                var url = login.URL.signInUrl(stuID, password);
                console.log('user=' + stuID);//TODO ɾ��
                console.log('password=' + password);//TODO ɾ��
               // $('this').addClass('disabled');//���ð�ť
                //ִ�е�¼���� ����ajax
                $.get(url, {}, function (result) {
                    if (result) {
                        if( result['success']){//��¼�ɹ� ��תҳ��
                            var infoUrl = login.URL.myHomepageUrl();
                            window.parent.location.href=infoUrl;//��תҳ��
                        }
                        else{
                            //todo �����İ���Ϣ��ȡ��ǰ���ֵ���
                            var info = result['error'];
                            $('#loginMessage').hide().html(
                                '<label class="label label-danger"><em>'+info+'</em></label>').show(300);
                        }

                    } else {
                        console.log('result=' + result);//TODO ɾ��
                    }
                })
            });

            $('#signOutBtn').one('click',function () {
                $.get(login.URL.signOutUrl(),function () {
                    window.parent.location.href=login.URL.sign();//��תҳ��
                });
            });

            //ע��ҳ��
            $('#registerBtn').one('click',function () {
                window.parent.location.href=login.URL.registerPageUrl();//��תҳ��
            })
        },


        register:function () {

            //���ע�ᰴť
            $('#registerBtn').one('click',function () {
                var stuID = $('#user').val();
                var password = $('#password').val();
                var passwordSure = $('#passwordSure').val();
                if(password!=passwordSure){
                    $('#registerInfo').hide().html(
                        '<label class="label label-danger"><em>�������벻һ��</em></label>').show(300);
                }else{
                    //����ע������
                    $.get(login.URL.registerUrl(stuID),function (result) {
                        if(result){
                            if(result['success']){//ע��ɹ���ת��¼ҳ��
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