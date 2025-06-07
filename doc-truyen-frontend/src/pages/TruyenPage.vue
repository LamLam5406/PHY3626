<template>
  <div>
    <h1>📖 Truyện: {{ truyenId }}</h1>
    <ul>
      <li v-for="chuong in chuongs" :key="chuong.id">
        <router-link :to="`/chuong/${truyenId}/${chuong.id}`">{{ chuong.ten }}</router-link>
      </li>
    </ul>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useRoute } from 'vue-router';
import axios from 'axios';

const route = useRoute();
const truyenId = route.params.id;

const chuongs = ref([]);

onMounted(async () => {
  try {
    const res = await axios.get(`${API_BASE}/truyen`);
    chuongs.value = res.data;
  } catch (err) {
    console.error('Lỗi tải chương:', err);
  }
});
</script>
