
import React, { useState, useEffect} from 'react';
import {Container, Form, InputGroup, Table, Button} from 'react-bootstrap';
import axios from 'axios';

const RegistrationOVerview = () => {
  const [animals, setAnimals] = useState([
    { regNumber: '001', date: '2024-10-29', weight: 150, origin: 'Farm 1' },
    { regNumber: '002', date: '2024-10-30', weight: 200, origin: 'Farm 2' },
    { regNumber: '003', date: '2024-10-29', weight: 180, origin: 'Farm 3' },
  ]);

  useEffect(() => {
    const fetchAnimals = async () => {
      try {
        const response = await axios.get('http://localhost:9090/animals');
        setAnimals(response.data);
      } catch (error) {
        console.error(error);
      }
    };

    fetchAnimals();
  }, [])

  const [filterDate, setFilterDate] = useState('');
  const [filterOrigin, setFilterOrigin] = useState('');

  const clearFilters = () => {
    setFilterDate('');
    setFilterOrigin('');
  };

  const filteredAnimals = animals.filter((animal) => {
    return (
      (!filterDate || animal.date === filterDate) &&
      (!filterOrigin || animal.origin === filterOrigin)
    );
  });

  return (
    <Container className="mt-5 w-100" style={{ maxWidth: '800px' }}>
      <h4>Filter Animals</h4>
      <Form className="mb-3">
        <InputGroup className="mb-3">
          <Form.Control
              type="date"
              placeholder="Filter by Date"
              value={filterDate}
              onChange={(e) => setFilterDate(e.target.value)}
          />
        </InputGroup>
        <InputGroup className="mb-3">
          <Form.Select
              value={filterOrigin}
              onChange={(e) => setFilterOrigin(e.target.value)}
          >
            <option value="">Select Origin</option>
            <option value="Farm 1">Farm 1</option>
            <option value="Farm 2">Farm 2</option>
            <option value="Farm 3">Farm 3</option>
          </Form.Select>
        </InputGroup>
        <div className="d-flex justify-content-end">
          <Button variant="outline-success" onClick={clearFilters} className="mb-3">
            <i className="bi bi-x-circle"></i> Clear Filters
          </Button>
        </div>
      </Form>

      <Table striped bordered hover className="mt-4">
        <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Registration No.</th>
          <th scope="col">Date of Registration</th>
            <th scope="col">Weight (kg)</th>
            <th scope="col">Origin</th>
          </tr>
        </thead>
        <tbody>
          {filteredAnimals.map((animal, index) => (
            <tr key={index}>
              <th scope="row">{index + 1}</th>
              <td>{animal.regNumber}</td>
              <td>{animal.date}</td>
              <td>{animal.weight}</td>
              <td>{animal.origin}</td>
            </tr>
          ))}
        </tbody>
      </Table>
    </Container>
  );
};

export default RegistrationOVerview;