import { useState } from 'react';
import { Form, Button, InputGroup } from 'react-bootstrap';
import axios from 'axios';
import { useOrigins } from "../../OriginsContext.tsx";

const RegisterAnimalForm = () => {
    // Define state variables for form inputs
    const [date, setDate] = useState('');
    const [weight, setWeight] = useState('');
    const [origin, setOrigin] = useState<number | ''>('');  // Change origin state to number
    const { origins } = useOrigins();

    // Handle form submission
    const handleSubmit = async (e: { preventDefault: () => void; }) => {
        e.preventDefault();

        // Create the data object to send, with origin as an object
        const animalData = {
            registrationDate: date,
            weight: parseFloat(weight),
            origin: { id: origin }  // Pass origin as an object with an id property
        };

        try {
            // Send a POST request to the backend API
            const response = await axios.post('http://localhost:8085/station1/register', animalData);
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
        <div className="container">
            <div className="d-flex justify-content-center align-items-center w-100">
                <div className="p-4 bg-white shadow rounded text-center" style={{width: '400px'}}>
                    <p className="Lead mb-0">Station 1</p>
                    <h2 className="mb-4">Register Animal</h2>
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
                                onChange={(e) => setOrigin(parseInt(e.target.value))}  // Parse selected value as integer
                                required
                            >
                                <option value="" disabled>Select Origin</option>
                                {origins.map((origin) => (
                                    <option key={origin.id} value={origin.id}>{origin.name_of_farm}</option>
                                ))}
                            </Form.Select>
                        </InputGroup>
                        <Button variant="success" type="submit" className="w-100">
                            Register animal
                        </Button>
                    </Form>
                </div>
            </div>
        </div>
    );
};

export default RegisterAnimalForm;
