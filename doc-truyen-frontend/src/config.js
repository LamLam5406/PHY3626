// src/config.js
const API_BASE = import.meta.env.DEV
  ? 'http://localhost:3000/api'  // khi phát triển (npm run dev)
  : 'https://doc-truyen-backend.onrender.com/api'  // khi deploy

export default API_BASE;
