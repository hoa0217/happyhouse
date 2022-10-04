import { configureStore, getDefaultMiddleware } from '@reduxjs/toolkit';
import { combineReducers } from 'redux';
import loginReducer from './reducer/loginReducer';
import storageSession from 'redux-persist/lib/storage/session';
import { persistReducer } from 'redux-persist';

const reducers = combineReducers({
  login: loginReducer,
});

const persistConfig = {
  key: 'root',
  storage: storageSession,
};

const persistedReducer = persistReducer(persistConfig, reducers);

export const store = configureStore({
  reducer: persistedReducer,
  middleware: getDefaultMiddleware({
    serializableCheck: false,
  }),
});
