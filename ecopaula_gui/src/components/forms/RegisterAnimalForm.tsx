import React from 'react';
import {Form, Button, InputGroup } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

const RegisterAnimalForm = () => {
    return (
        <div className="d-flex justify-content-center align-items-center w-100">
            <div className="p-4 bg-white shadow rounded" style={{width: '400px'}}>
                <h2 className="text-center mb-4">Register Animal</h2>
                <Form>
                    <InputGroup className="mb-3">
                        <InputGroup.Text>
                            <i className="bi bi-calendar-fill"></i>
                        </InputGroup.Text>
                        <Form.Control type="date" placeholder="Date"/>
                    </InputGroup>
                    <InputGroup className="mb-3">
                        <InputGroup.Text>
                            <i className="bi bi-graph-up"></i>
                        </InputGroup.Text>
                        <Form.Control type="number" placeholder="Weight (kg)"/>
                    </InputGroup>
                    <InputGroup className="mb-3">
                        <InputGroup.Text>
                            <i className="bi bi-geo-alt-fill"></i>
                        </InputGroup.Text>
                        <Form.Select>
                            <option>Select Origin</option>
                            <option value="farm1">Farm 1</option>
                            <option value="farm2">Farm 2</option>
                            <option value="farm3">Farm 3</option>
                        </Form.Select>
                    </InputGroup>
                    <Button variant="success" type="submit" className="w-100">
                        Register animal
                    </Button>
                </Form>
            </div>
        </div>
    )
}

export default RegisterAnimalForm;