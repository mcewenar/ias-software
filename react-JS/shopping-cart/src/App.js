import './App.css';
import { useEffect, useState } from 'react';
import { Route, BrowserRouter, Routes } from 'react-router-dom';
import CssBaseline from "@mui/material/CssBaseline";
import MenuProducts from './components/pages/menu_products_page';
import ApplicationBar from './components/app_bar';
import ProductosJson from './components/json-test/products.json';

function App() {
  const [product, setProduct] = useState(0);
  const [cart, setCart] = ([]);
  //Execute each that re-render web page.
  /*useEffect(() => {
    effect
    return () => {
      cleanup
    }
  }, [loquequieresquerenderice])*/
  let productos = ProductosJson;
  //productsApi.getAllProducts();
  return (
    <>
      <BrowserRouter>
        <CssBaseline />
        <ApplicationBar />
        {ProductosJson.map(producto => 
            <MenuProducts name={producto.name} price={producto.price} amount={producto.amount} 
            description={producto.description} />)}
            <button>Get Shopping-cart</button>
      <Routes>
          <Route path="/">
          </Route>
          <Route path="/persons">
          </Route>
      </Routes>
      </BrowserRouter>
    </>
    
  );  
}
export default App;
