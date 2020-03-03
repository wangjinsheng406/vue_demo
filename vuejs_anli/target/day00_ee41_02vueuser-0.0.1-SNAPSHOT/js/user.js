new Vue({
    el:"#app",
    data:{
        user: {
            id: "",
            username: "",
            password: "",
            age: "",
            sex: "",
            email: ""
        },
        userList:[]
    },
    methods:{
        findAll:function () {
            var _this = this;
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
    created(){
        this.findAll();
    }
});