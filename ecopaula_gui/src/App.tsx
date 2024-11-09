import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import NavBar from "./components/NavBar";
import { OriginsProvider } from './OriginsContext';
import RegistrationOverview from "./components/RegistrationOverview.tsx";
import RegisterAnimalForm from "./components/forms/RegisterAnimalForm.tsx";

const pageStyle = {
    background: 'linear-gradient(135deg, #fdfbf7, #ece2d0)',
    minHeight: '100vh',
    padding: '2rem'
};

function App() {

    return (
        <OriginsProvider>
            <Router>
                <div style={pageStyle}>
                    <NavBar />
                    <Routes>
                        <Route path="/register" element={<RegisterAnimalForm />} />
                        <Route path="/" element={<RegistrationOverview />} />
                    </Routes>
                </div>
            </Router>
        </OriginsProvider>

    );
}

export default App
