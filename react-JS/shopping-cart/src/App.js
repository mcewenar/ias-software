import './App.css';
import Menu from './components/menu_products';
import Tab_headers from './components/table_header';
import ProductosJson from './components/json/products.json';

function App() {
  //const [state, setstate] = useState(0);
  let productos = ProductosJson;
  
  return (
    <>
      <Tab_headers/>
      {productos.map(producto => 
        <Menu name={producto.name} price={producto.price} amount={producto.amount} 
        description={producto.description} />)}
    </>
  );
}
export default App;
