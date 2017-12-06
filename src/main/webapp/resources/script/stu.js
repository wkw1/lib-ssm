var stu={

    URL:{
        searchUrl:function (type,key) {
            return '/lib/stu/'+type+'/' +key+'/result';
        },
        borrow :function (ISBN) {
            return  '/lib/stu/'+ISBN+'/borrow';
        },
        returnBookUrl:function(borrowID){
            return '/lib/stu/'+borrowID+'/return';
        },
        orderBookUrl:function (ISBN) {
            return '/lib/stu/'+ISBN+'/order'
        },
        cancelOrderUrl:function (ID,ISBN) {
            return '/lib/stu/'+ID+'/'+ISBN+'/cancelOrder';
        }
    },
    
    init:{
        search:function () {//搜索页面跳转
            $('#searchBtn').one('click',function () {
                var searchType = $('#searchType option:selected').text();
                var searchKey = $('#searchKey').val();
                window.open(stu.URL.searchUrl(searchType,searchKey));
                //window.location.href=;
            });
        }
    },

    book: {

        order:function (param) {
            var bookISBN = param['bookISBN'];

            //预约操作
            $('#orderBtn').one('click',function () {
                $('this').addClass('disabled');//禁用按钮
                $.post(stu.URL.orderBookUrl(bookISBN),function (result) {
                    if(result){
                        if (result['success']) {
                            //成功预约跳转页面 TODO
                            $('#orderInfo').hide().html(
                                '<label class="label label-success"> 预约成功 </label>').show(500);
                            //console.info(data['data']);
                        } else {
                            //预约失败提示信息 TODO
                            var statInfo = result['error'];
                            $('#orderInfo').hide().html(
                                '<label class="label label-danger">' + statInfo + '</label>').show(300);
                        }
                    }
                })
            })
        },
        
        cancelOrder:function (ID,ISBN) {
            $.post(stu.URL.cancelOrderUrl(ID,ISBN));
        },


        borrow: function (param) {
            var bookISBN = param['bookISBN'];

            //借书操作
            $('#borrowBtn').one('click', function () {
                $('this').addClass('disabled');//禁用按钮
                $.post(stu.URL.borrow(bookISBN), function (result) {
                    if (result) {
                        if (result['success']) {
                            //成功借阅跳转页面 TODO
                            $('#borrowInfo').hide().html(
                                '<label class="label label-success"> 借书成功 </label>').show(500);
                            //console.info(data['data']);
                        } else {
                            //借阅失败提示信息 TODO
                            var statInfo = result['error'];
                            $('#borrowInfo').hide().html(
                                '<label class="label label-danger">' + statInfo + '</label>').show(300);
                        }
                    }
                });
            });
        },

        returnBook: function (borrowID) {
            $.post(stu.URL.returnBookUrl(borrowID),function () {
                
            });
        }
    }
}