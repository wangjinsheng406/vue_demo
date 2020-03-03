new Vue({
    el:"#app",//表示当前vue对象接管了div区域
    data:{
        user: {//定义了一个user对象
            id: "",
            username: "",
            password: "",
            age: "",
            sex: "",
            email: ""
        },
        userList:[]//定义了一个存放user的list集合
    },
    methods:{//对应controller中的三个查询方法
        findAll:function () {
            var _this = this;//应用vue对象
            axios.get('/vuejs/user/find_all.do').then(function(response){
                    _this.userList = response.data;
                })
                .catch(function(err){
                    console.log(err);
                });
        },
        findById:function (userId) {
            var _this = this;
            axios.get('/vuejs/user/find_by_id.do',{params:{id:userId}}).then(function(res){
                _this.user = res.data;
                $("#myModal").modal("show");//让模态框显示
            }).catch(function (err) {
                console.log(err)
            });
        },
        update:function (user) {
            var _this = this;
            axios.post('/vuejs/user/update.do',_this.user).then(function(res){
                    _this.findAll();
                })
                .catch(function(err){
                    console.log(err);
                });
        }
    },
    created(){//vue对象创建即调用查询
        this.findAll();
    }
});