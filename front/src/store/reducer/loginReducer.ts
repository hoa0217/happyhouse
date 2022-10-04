import { createSlice } from '@reduxjs/toolkit';

export interface stateProps {
  token?: string;
}

const initialState: stateProps = {
  token: '',
};

export const loginSlice = createSlice({
  name: 'login',
  initialState,
  reducers: {
    setToken: (state, action) => {
      state.token = action.payload.token;
    },
    clearToken: (state) => {
      state.token = '';
    },
  },
});

export const { setToken, clearToken } = loginSlice.actions;

export default loginSlice.reducer;
