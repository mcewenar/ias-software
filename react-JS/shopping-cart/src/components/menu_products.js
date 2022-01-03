import TableRow from '@mui/material/TableRow';

export default function Menu(props) {
    return(
        <div className="products">
            <table>
                <tr>
                    <td>{props.name}</td>
                    <td>{props.price}</td>
                    <td>{props.amount}</td>
                    <td>{props.description}</td>
                </tr>
            </table>
        </div>
            
    )
}