var vue= new Vue({
    el: '#app',

    data: {
        user: {
            id: '',
            username: '',
            password: '',
            age: '',
            set: '',
            email: ''
        },
        userList: []
    },
    methods: {
        findAll: function () {
            //问题细节,在处理参数的时候需要注意,
            // axios是一个方法也代表当前
            // ,要想使用vue的数据需要定义代表vue对象,
            axios.get("/user/findAll.action")
            //响应之后的参数处理
                .then(function (response) {


                    vue.userList=response.data;
                    //将数据显示到前端控制台
                    console.log(response);

                    //错误的处理方式
                }).catch(function (error) {
                    alert("数据有误,请刷新页面");
                    console.log(error);

                 location.reload();
                //最终执行的
            }).then(function (value) {
                console.log(value);
            });
        },
        findById: function (id) {
           axios.get("/user/byId.action",{params:{id:id}}).then(function (response) {
                 vue.user=response.data;
                 $("#myModal").modal("show");
           }).catch(function (error) {
                     console.log(error);
           }).then(function (final) {
               console.log(final);
           });
        },
        index:function (id) {

        },
        update:function () {
            var user=vue.user;


            axios.post("/user/updateUser.action",{user})
            .then(function (response) {
               vue.findAll();
                console.log(response);
            })
                .catch(function (error) {
                    console.log(error);
                });
        }
    },
    created: function () {
        this.findAll();
    }



});