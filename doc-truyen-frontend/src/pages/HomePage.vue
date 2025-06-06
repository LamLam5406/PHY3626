<template>
  <div>
    <h1>📚 Danh sách truyện</h1>
    <ul>
      <li v-for="truyen in truyens" :key="truyen.id">
        <router-link :to="`/truyen/${truyen.id}`">{{ truyen.ten }}</router-link> 
        – Tác giả: {{ truyen.tacGia }}
      </li>
    </ul>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';

const truyens = ref([]);

onMounted(async () => {
  try {
    const res = await axios.get('http://localhost:3000/api/truyen');
    truyens.value = res.data;
  } catch (err) {
    console.error('Lỗi tải truyện:', err);
  }
});
</script>
