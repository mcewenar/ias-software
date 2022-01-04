export default function Tab_persons(props) {
    {productos.map(producto => 
        <Menu name={producto.name} price={producto.price} amount={producto.amount} 
        description={producto.description} />)}
        <button>Get Shopping-cart</button>


}
