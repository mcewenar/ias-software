import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';

export default function MenuProducts(props) {
    return(
        <div className="products">
            <table>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th>amount</th>
                    <th>description</th>
                </tr>
                <tr>
                    <td>{props.name}</td>
                    <td>{props.price}</td>
                    <td>{props.amount}</td>
                    <td>{props.description}</td>
                    <td><button>+</button></td>
                    <td><button>-</button></td>
                    <button>Delete</button>
                </tr>
            </table>
        </div>
    );
}