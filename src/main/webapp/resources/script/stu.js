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
        search:function () {//����ҳ����ת
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

            //ԤԼ����
            $('#orderBtn').one('click',function () {
                $('this').addClass('disabled');//���ð�ť
                $.post(stu.URL.orderBookUrl(bookISBN),function (result) {
                    if(result){
                        if (result['success']) {
                            //�ɹ�ԤԼ��תҳ�� TODO
                            $('#orderInfo').hide().html(
                                '<label class="label label-success"> ԤԼ�ɹ� </label>').show(500);
                            //console.info(data['data']);
                        } else {
                            //ԤԼʧ����ʾ��Ϣ TODO
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

            //�������
            $('#borrowBtn').one('click', function () {
                $('this').addClass('disabled');//���ð�ť
                $.post(stu.URL.borrow(bookISBN), function (result) {
                    if (result) {
                        if (result['success']) {
                            //�ɹ�������תҳ�� TODO
                            $('#borrowInfo').hide().html(
                                '<label class="label label-success"> ����ɹ� </label>').show(500);
                            //console.info(data['data']);
                        } else {
                            //����ʧ����ʾ��Ϣ TODO
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