import './App.css';
import { useEffect, useState } from 'react';
import { Route } from 'react-router-dom';
import Menu from './components/menu_products';
import Tab_headers from './components/table_header';
import ProductosJson from './components/json-test/products.json';
import { Switch } from '@mui/material';

function App() {
  //const [state, setstate] = useState(0);
  //Execute each that re-render web page.
  /*useEffect(() => {
    effect
    return () => {
      cleanup
    }
  }, [loquequieresquerenderice])*/
  let productos = ProductosJson;
  
  return (
    <>
      <Switch>
        <Route path="/">
          <Tab_headers/>
          {productos.map(producto => 
            <Menu name={producto.name} price={producto.price} amount={producto.amount} 
            description={producto.description} />)}
            <button>Get Shopping-cart</button>
        </Route>
        <Route path="/persons">
          <Tab_headers/>
          {productos.map(producto => 
            <Menu name={producto.name} price={producto.price} amount={producto.amount} 
            description={producto.description} />)}
            <button>Get Shopping-cart</button>
        </Route>


      </Switch>
      
    </>
  );
}
export default App;
