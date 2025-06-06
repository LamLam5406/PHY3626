import { createRouter, createWebHistory } from 'vue-router';

// Nhập các trang (sẽ tạo ở bước sau)
import HomePage from '../pages/HomePage.vue';
import TruyenPage from '../pages/TruyenPage.vue';
import ChuongPage from '../pages/ChuongPage.vue';
import LoginPage from '../pages/LoginPage.vue';
import AdminPage from '../pages/AdminPage.vue';

const routes = [
  { path: '/', component: HomePage },
  { path: '/truyen/:id', component: TruyenPage },
  { path: '/chuong/:id', component: ChuongPage },
  { path: '/login', component: LoginPage },
  { path: '/admin', component: AdminPage },
  { path: '/chuong/:truyenId/:chuongId', component: ChuongPage },
];

export const router = createRouter({
  history: createWebHistory(),
  routes,
});
