import { useState, useEffect } from 'react';
import { Container, Form, InputGroup, Table, Button } from 'react-bootstrap';
import axios from 'axios';
import { useOrigins } from "../OriginsContext.tsx";

type Origin = {
  id: number;
  name_of_farm: string;
};

type Animal = {
  id: number;
  registrationDate: Date;
  weight: number;
  origin: Origin;
  name_of_farm?: string;
};


const RegistrationOverview = () => {
  const [animals, setAnimals] = useState<Animal[]>([]);
  const [filterDate, setFilterDate] = useState('');
  const [filterOrigin, setFilterOrigin] = useState('');
  const { origins } = useOrigins();

  // Fetch animals from the backend API
  useEffect(() => {
      const fetchAnimals = async () => {
        try {
          const response = await axios.get('http://localhost:8080/animals');

          const parsedAnimals: Animal[] = response.data.map((animal: { registrationDate: string | number | Date; }) => ({
            ...animal,
            registrationDate: new Date(animal.registrationDate),
          }));

          setAnimals(parsedAnimals);
        } catch (error) {
          console.error("Error fetching animals:", error);
        }
      };

      fetchAnimals();
    }, []);


    const formatDate = (date : Date) => {
    const day = String(date.getDate()).padStart(2, '0');
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const year = date.getFullYear();
    return `${day}.${month}.${year}`;
  }

  const formatInputDate = (inputDate: string) => {
    const [year, month, day] = inputDate.split('-');
    return `${day}.${month}.${year}`;
  };

  // Filtered animals based on date and origin
  const filteredAnimals = animals.filter((animal) => {
    const formattedDate = formatDate(animal.registrationDate);
    return (
        (!filterDate || formattedDate === formatInputDate(filterDate)) &&
        (!filterOrigin || animal.origin.id.toString() === filterOrigin)
    );
  }).sort((a, b) => b.registrationDate.getTime() - a.registrationDate.getTime());

  // Clear filters
  const clearFilters = () => {
    setFilterDate('');
    setFilterOrigin('');
  };

  return (
      <Container className="mt-5 w-100" style={{ maxWidth: '800px' }}>
        <h4>Filter Animals</h4>
        <Form className="mb-3">
          <InputGroup className="mb-3">
            <Form.Control type="date" value={filterDate} onChange={(e) => setFilterDate(e.target.value)}
            />
          </InputGroup>
          <InputGroup className="mb-3">
            <Form.Select value={filterOrigin} onChange={(e) => setFilterOrigin(e.target.value)}>
              <option value="" disabled>Select Origin</option>
              {origins.map((origin) => (
                  <option key={origin.id} value={origin.id}>{origin.name_of_farm}</option>
              ))}
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
            <th>Reg. no.</th>
            <th>Reg. date</th>
            <th>Weight (kg)</th>
            <th>Origin</th>
          </tr>
          </thead>
          <tbody>
          {filteredAnimals.map((animal, index) => (
              <tr key={index}>
                <td>{animal.id}</td>
                <td>{formatDate(animal.registrationDate)}</td>
                <td>{animal.weight}</td>
                <td>{animal.origin.name_of_farm}</td>
              </tr>
          ))}
          </tbody>
        </Table>
      </Container>
  );
};

export default RegistrationOverview;
