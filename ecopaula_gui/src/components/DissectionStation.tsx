import {Table} from "react-bootstrap";

type Animal = {
    id: number;
    weight: number;
};

const DissectionStation = () => {
    return (
        <div className="Container">
            <div className="d-flex justify-content-center align-items-center w-100">
                <div className="p-4 bg-white shadow rounded text-center">
                    <p className="Lead mb-0">Station 2</p>
                    <h2 className="text-center mb-4">Dissect</h2>
                    <Table>
                        <thead>
                            <th>Reg. no.</th>
                            <th>Weight</th>
                        </thead>
                        <tbody>
                            <tr>
                                <td>animal.id</td>
                                <td>animal.weight</td>
                            </tr>
                        </tbody>
                    </Table>
                </div>
            </div>
        </div>
    );
}

export default DissectionStation;