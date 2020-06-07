<template>
    <div>
        <el-table
                :data="tableData"
                border
                style="width: 70%">
            <el-table-column
                    fixed
                    prop="id"
                    label="编号"
                    width="150">
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="书名"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="author"
                    label="作者"
                    width="120">
            </el-table-column>
            <el-table-column
                    fixed="right"
                    label="操作"
                    width="100">
                <template slot-scope="scope">
                    <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
                    <el-button @click="deleteBook(scope.row)" type="text" size="small">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination
                background
                layout="prev, pager, next"
                :page-size="pageSize"
                :total="total"
                @current-change="page">
<!--            page方法，点击不同页面，显示不同页面内容-->
        </el-pagination>
    </div>

</template>

<script>
    export default {
        methods: {
            deleteBook(row){
                const _this = this
                axios.delete('http://localhost:8181/book/deleteById/'+ row.id).then(function (resp) {
                    _this.$alert('《'+row.id+'》删除成功！', '提示', {
                        confirmButtonText: '确定',
                        callback: action => {
                            window.location.reload()
                        }
                    })
                })
            },
            edit(row) {   //row表示当前对象
                this.$router.push({
                    path:'/BookUpdate',
                    query:{
                    id:row.id}
                })

            },
            page(currentPage){
                const _this = this
                axios.get('http://localhost:8181/book/findAll/'+currentPage+'/6').then(function (resp) {
                    _this.tableData = resp.data.content
                    _this.pageSize = resp.data.size
                    _this.total = resp.data.totalElements
                })
            }
        },
        created() {
            const _this = this
            axios.get('http://localhost:8181/book/findAll/1/6').then(function (resp) {
                _this.tableData = resp.data.content
                _this.pageSize = resp.data.size
                _this.total = resp.data.totalElements
            })
        },

        data() {
            return {
                total: null,
                tableData: null
            }
        }
    }
</script>