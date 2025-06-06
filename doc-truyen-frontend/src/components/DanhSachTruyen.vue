<template>
  <div class="p-4">
    <h2>📚 Danh sách truyện</h2>
    <ul>
      <li v-for="truyen in danhSachTruyen" :key="truyen._id">
        {{ truyen.ten }} - Tác giả: {{ truyen.tacGia }}
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'DanhSachTruyen',
  data() {
    return {
      danhSachTruyen: [],
    };
  },
  mounted() {
    // Gọi API khi component hiển thị
    axios.get('http://localhost:3000/api/truyen')
      .then(res => {
        this.danhSachTruyen = res.data;
      })
      .catch(err => {
        console.error('Lỗi khi lấy truyện:', err);
      });
  }
}
</script>
