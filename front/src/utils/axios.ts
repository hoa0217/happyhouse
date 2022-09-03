import axios, { AxiosInstance } from 'axios';

const API_SERVER = 'https://happy-haapyhouse.herokuapp.com/';

const customAxios: AxiosInstance = axios.create({
  baseURL: `${API_SERVER}`, // 기본 서버 주소 입력
});

export default customAxios;
