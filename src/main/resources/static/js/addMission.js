let app = new Vue({
    el:"#app",
    data(){
        return{
            activeIndex:3,
            form: {
                name: '',
                grade:'',
                major:'',
                position:'',
                context: '',
                studentName:''
            },
            student:[],
        }
    },
    methods: {
        searchWho(){
            let _this=this;
            axios({
                method:"get",
                url:`http://localhost:8080/selectByConditions?grade=${_this.form.grade}
                        &major=${_this.form.major}&position=${_this.form.position}`
            }).then(function (resp){
                _this.student=resp.data;
                console.log(_this.student[0].username);
                _this.form.studentName=_this.student[0].username;
            })
            console.log(this.form.context);
            console.log(this.student);
            console.log(this.student[0]);
            console.log(this);
        },
        onSubmit() {
            let params = new URLSearchParams();
            let url='http://localhost:8080/addMission';
            params.append('mtitle',this.form.name);
            params.append('fk_sid',this.student[0].sid);
            params.append('context',this.form.context);
            let _this=this;
            axios.post(url,params,{headers:{
                    'C':'application/x-www-form-urlencoded'
                }}
            ).then(function (resp){
                _this.flag=resp.data;
                if(_this.flag==1){
                    _this.$message({
                        type: 'success',
                        message: '发布成功!'
                    });
                }else{
                    alert("服务器繁忙")
                }
            })
        }
    }
})