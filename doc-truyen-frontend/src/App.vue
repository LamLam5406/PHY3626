<template>
  <div>
    <h1>🌐 Web đọc truyện</h1>
    <DanhSachTruyen />
  </div>
  <nav>
    <router-link to="/">Trang chủ</router-link> |
    <router-link to="/login">Đăng nhập</router-link> |
    <router-link to="/admin">Admin</router-link>
  </nav>

  <router-view />
</template>

<script>
import DanhSachTruyen from './components/DanhSachTruyen.vue';

export default {
  components: {
    DanhSachTruyen
  }
}
</script>

<style>
nav {
  background: #f2f2f2;
  padding: 1rem;
}
a {
  margin: 0 1rem;
  text-decoration: none;
}
</style>