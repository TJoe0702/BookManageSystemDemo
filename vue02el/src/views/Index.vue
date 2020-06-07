<template>
        <el-container style="height: 500px; border: 1px solid #eee">
            <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
                <!--        静态页面-->
                <!--        <el-menu :default-openeds="['1','2']">-->

                <!--          <el-submenu index="1">-->
                <!--            <template slot="title"><i class="el-icon-message"></i>导航一</template>-->
                <!--              <el-menu-item index="1-1">选项1</el-menu-item>-->
                <!--            <el-submenu index="1-2">-->
                <!--              <template slot="title">选项2</template>-->
                <!--              <el-menu-item index="1-2-1">选项2-1</el-menu-item>-->
                <!--            </el-submenu>-->
                <!--          </el-submenu>-->

                <!--        </el-menu>-->

                <!--        动态加载页面-->
                <el-menu router :default-openeds="['0','1']">
                    <el-submenu v-for="(item1,index) in $router.options.routes":index = "index + ''" v-if="item1.show">
                        <template slot="title"><i class="el-icon-setting"></i>{{item1.name}}</template>
                        <el-menu-item v-for="(item2,index2) in item1.children":index = "item2.path"
                                      :class="$route.path==item2.path?'is-active':''">{{item2.name}}</el-menu-item>
                    </el-submenu>
                </el-menu>
            </el-aside>

            <el-container>
                <el-header style="text-align: right; font-size: 12px">
                    <el-dropdown>
                        <i class="el-icon-setting" style="margin-right: 15px"></i>
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item>查看</el-dropdown-item>
                            <el-dropdown-item>新增</el-dropdown-item>
                            <el-dropdown-item>删除</el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                    <span>涂俊</span>
                </el-header>

                <el-main>
                    <router-view></router-view>
                </el-main>
            </el-container>
        </el-container>
</template>

<script>
    export default {
        name: "Index"
    }
</script>

<style scoped>

</style>