import { Navbar, Nav, Button } from "react-bootstrap";
import { Link } from "react-router-dom";

const NavBar = () => {
    return (
        <div className="container" style={{ maxWidth: '900px' }}>
            <Navbar expand="md" className="p-3">
                <Navbar.Brand as={Link} to="/">
                    <img
                        src="/public/ecopaula_logo.png"
                        width="110"
                        height="90"
                        className="d-inline-block align-top"
                        alt="EcoPaula Logo"
                    />{' '}
                </Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav"/>
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="ms-auto align-items-center">
                        <Nav.Link as={Link} to="/">Overview</Nav.Link>
                        <Nav.Link as={Link} to="/register">
                            <Button variant="outline-success">Register Animal</Button>
                        </Nav.Link>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
        </div>
    );
};

export default NavBar;
