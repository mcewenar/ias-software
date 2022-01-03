import './App.css';
import { BrowserRouter, Route } from 'react-router-dom';
import { useState } from 'react';
import { useQuery } from 'react-query';
import ApplicationBar from './components/app-bar';

//Imports components Material UI:
import AddShoppingCartIcon from '@mui/material'
function App() {
  return (
    <BrowserRouter>
      <ApplicationBar />
    </BrowserRouter>
    
  )
}

export default App;
