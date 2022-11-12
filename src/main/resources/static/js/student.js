let app =new Vue({
    el:"#app",
    data(){
        return{
            students:[],
            updateFlag:false,
            updateStudent:[],
            inputName:'',
            optionsGrade: [{
                value: '2018',
                label: '2018'
            }, {
                value: '2019',
                label: '2019'
            }, {
                value: '2020',
                label: '2020'
            }, {
                value: '2021',
                label: '2021'
            }, {
                value: '2022',
                label: '2022'
            },{
                value: "",
                label: "不限"
            }],
            optionsGender:[{
                value:"男",
                label:"男"
            },{
                value: "女",
                label: "女"
            },{
                value: "",
                label: "不限"
            }],
            optionPosition:[{
                value:"班长",
                label:"班长"
            },{
                value:"团支部书记",
                label:"团支部书记"
            },{
                value:"学习委员",
                label:"学习委员"
            },{
                value:"",
                label:"不限"
            }],
            valuePosition:'',
            valueGrade:'',
            valueGender:''
        }
    },
    mounted(){
        //页面加载完成后
        let _this=this;
        axios({
            method:"get",
            url:"http://localhost:8080/selectAll"
        }).then(function (resp){
            _this.students=resp.data;
        })
    },
    methods:{
        search:function(){
            let _this=this;
            axios({
                method:"get",
                url:`http://localhost:8080/selectByConditions?username=${_this.inputName}&grade=${_this.valueGrade}&gender=${_this.valueGender}&position=${_this.valuePosition}`
            }).then(function (resp){
                _this.students=resp.data;
            })
        },
        add:function (){
            window.open("http://localhost:8080/addMenber.html","_self")
        }
        ,
        refresh:function (){
            let _this=this;
            axios({
                method:"get",
                url:"http://localhost:8080/selectAll"
            }).then(function (resp){
                _this.students=resp.data;
            })
        },
        editStudent:function (row){
            this.updateFlag=true;
            const sid=row.sid;
            console.log(sid);
            let _this=this;
            axios({
                method:"get",
                url:`http://localhost:8080/selectById?sid=${sid}`
            }).then(function (resp){
                _this.updateStudent=resp.data;
            })
        },
        confirmUpdate:function (){
            let params = new URLSearchParams();
            let url='http://localhost:8080/updateStudent';
            params.append('sid',this.updateStudent.sid);
            params.append('username',this.updateStudent.username);
            params.append('password',this.updateStudent.password);
            params.append('gender',this.updateStudent.gender);
            params.append('grade',this.updateStudent.grade);
            params.append('major',this.updateStudent.major);
            params.append('position',this.updateStudent.position);
            params.append('age',this.updateStudent.age);
            params.append('phone',this.updateStudent.phone);
            let _this=this;
            axios.post(url,params,{headers:{
                    'C':'application/x-www-form-urlencoded'
                }}
            ).then(function (resp){
                let flag=0;
                flag=resp.data;
                console.log(flag);
                if(1==flag){
                    _this.$message({
                        message: '修改成功',
                        type: 'success'
                    });
                    _this.updateFlag = false;
                    _this.refresh();
                }else{
                    this.$message.error('错了哦，这是一条错误消息');
                    alert("服务器繁忙")
                }
            })
        },
        deleteStudent:function (row){
            this.$confirm('此操作将永久删除该学生, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                let _this=this;
                const sid=row.sid;
                axios({
                    method:"get",
                    url:`http://localhost:8080/deleteStudent?sid=${sid}`
                }).then(function (resp){
                    let flag=0;
                    flag=resp.data;
                    if(flag==1){
                        _this.$message({
                            type: 'success',
                            message: '删除成功!'
                        });
                        _this.refresh();
                    }
                })
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消删除'
                });
            });
        }

    }
})