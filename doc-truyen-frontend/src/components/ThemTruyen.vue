<script>
import axios from 'axios';

export default {
  // component code ở đây
}
</script>

<template>
  <div>
    <button @click="themTruyen">Thêm truyện</button>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'ThemTruyen',
  methods: {
    themTruyen() {
      axios.post('${API_BASE}/truyen', {
        ten: 'One Piece',
        tacGia: 'Oda'
      })
      .then(response => {
        console.log('Thêm truyện thành công:', response.data);
      })
      .catch(error => {
        console.error('Lỗi khi thêm truyện:', error);
      });
    }
  }
}
</script>
