import { useState } from 'react';
import { Form, Button, InputGroup } from 'react-bootstrap';
import axios from 'axios';

const RegisterAnimalForm = () => {
    // Define state variables for form inputs
    const [date, setDate] = useState('');
    const [weight, setWeight] = useState('');
    const [origin, setOrigin] = useState('');

    // Handle form submission
    const handleSubmit = async (e: { preventDefault: () => void; }) => {
        e.preventDefault();

        // Create the data object to send
        const animalData = {
            registrationDate: date,
            weight: parseFloat(weight),
            origin: origin
        };

        try {
            // Send a POST request to the backend API
            const response = await axios.post('http://localhost:8080/animals', animalData);
            console.log('Animal registered successfully:', response.data);

            // Reset form fields after successful submission
            setDate('');
            setWeight('');
            setOrigin('');
            alert("Animal registered successfully!");
        } catch (error) {
            console.error('Error registering animal:', error);
            alert("Failed to register animal. Please try again.");
        }
    };

    return (
        <div className="d-flex justify-content-center align-items-center w-100">
            <div className="p-4 bg-white shadow rounded" style={{ width: '400px' }}>
                <h2 className="text-center mb-4">Register Animal</h2>
                <Form onSubmit={handleSubmit}>
                    <InputGroup className="mb-3">
                        <InputGroup.Text>
                            <i className="bi bi-calendar-fill"></i>
                        </InputGroup.Text>
                        <Form.Control
                            type="date"
                            placeholder="Date"
                            value={date}
                            onChange={(e) => setDate(e.target.value)}
                            required
                        />
                    </InputGroup>
                    <InputGroup className="mb-3">
                        <InputGroup.Text>
                            <i className="bi bi-graph-up"></i>
                        </InputGroup.Text>
                        <Form.Control
                            type="number"
                            placeholder="Weight (kg)"
                            value={weight}
                            onChange={(e) => setWeight(e.target.value)}
                            required
                        />
                    </InputGroup>
                    <InputGroup className="mb-3">
                        <InputGroup.Text>
                            <i className="bi bi-geo-alt-fill"></i>
                        </InputGroup.Text>
                        <Form.Select
                            value={origin}
                            onChange={(e) => setOrigin(e.target.value)}
                            required
                        >
                            <option value="">Select Origin</option>
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
    );
};

export default RegisterAnimalForm;
