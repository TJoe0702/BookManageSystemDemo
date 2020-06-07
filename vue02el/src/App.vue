<template>
  <div id="app">
      <router-view></router-view>
  </div>
</template>

<style>
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }

  .el-aside {
    color: #333;
  }
</style>

<script>
  export default {
    data() {
      const item = {
        date: '2016-05-02',
        name: 'lovely浪哥',
        address: '中南大学新校区升华学生公寓'
      };
      return {
        tableData: Array(20).fill(item)
      }
    }
  };
</script>