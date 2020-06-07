<template>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="图书名称" prop="name">
            <el-input v-model="ruleForm.name"></el-input>
        </el-form-item>
        <el-form-item label="作者" prop="author">
            <el-input v-model="ruleForm.author"></el-input>
        </el-form-item>
<!--        <el-form-item label="活动区域" prop="region">-->
<!--            <el-select v-model="ruleForm.region" placeholder="请选择活动区域">-->
<!--                <el-option label="区域一" value="shanghai"></el-option>-->
<!--                <el-option label="区域二" value="beijing"></el-option>-->
<!--            </el-select>-->
<!--        </el-form-item>-->

        <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
    </el-form>
</template>


<script>
    export default {
        data() {
            return {
                //绑定数据
                ruleForm: {
                    name: '',
                    author: '',
                },
                // 表单验证，绑定校验规则
                rules: {
                    name: [
                        { required: true, message: '图书名不能为空', trigger: 'blur' },
                        { min: 1, max: 5, message: '长度在 1 到 5 个字符', trigger: 'blur' }
                    ],
                    author: [
                        { required: true, message: '作者不能为空', trigger: 'blur' },
                        { min: 2, max: 5, message: '长度在 2 到 5 个字符', trigger: 'blur' }
                    ]

                }
            };
        },
        methods: {
            submitForm(formName) {
                const _this = this
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        // alert('submit!');
                        axios.post('http://localhost:8181/book/save',this.ruleForm).then(function (resp) {
                            if(resp.data=='success'){
                                _this.$alert('《'+_this.ruleForm.name+'》添加成功！', '提示', {
                                    confirmButtonText: '确定',
                                    callback: action => {
                                        _this.$router.push('/BookManage')    //跳转到指定页面
                                    }
                                })
                            }
                        })
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>