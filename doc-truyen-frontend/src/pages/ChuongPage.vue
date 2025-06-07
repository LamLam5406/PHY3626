<template>
  <div>
    <h1>📘 {{ chuong?.ten }}</h1>
    <p style="white-space: pre-line;">{{ chuong?.noiDung }}</p>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useRoute } from 'vue-router';
import axios from 'axios';

const route = useRoute();
const truyenId = route.params.truyenId;
const chuongId = route.params.chuongId;

const chuong = ref(null);

onMounted(async () => {
  try {
    const res = await axios.get(`${API_BASE}/truyen`);
    chuong.value = res.data.find(c => c.id == chuongId);
  } catch (err) {
    console.error('Lỗi tải nội dung chương:', err);
  }
});
</script>
