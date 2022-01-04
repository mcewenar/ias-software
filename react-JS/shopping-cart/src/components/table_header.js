import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';

export default function Tab_headers(props) {
    return(
        <div className="products">
            <table>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th>amount</th>
                    <th>description</th>
                </tr>
            </table>
        </div>
    );
}
