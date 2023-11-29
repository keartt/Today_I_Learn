import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

import { Nav, Navbar, Container, NavDropdown } from 'react-bootstrap';


function App() {
  return (
    <div className="App">
      <Navbar expand="lg" className="bg-body-tertiary">
        <Container>
          <Navbar.Brand href="#home">거지같은 쇼핑몰</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link href="#home">홈으로</Nav.Link>
              <Nav.Link href="#link">앞으로</Nav.Link>
              <NavDropdown title="드롭다운" id="basic-nav-dropdown">
                <NavDropdown.Item href="#action/3.1">
                  버튼1
                </NavDropdown.Item>
                <NavDropdown.Item href="#action/3.2">
                  버튼2
                </NavDropdown.Item>
                <NavDropdown.Item href="#action/3.3">
                  버튼3
                </NavDropdown.Item>
                <NavDropdown.Divider />{/* 나누기 */}
                <NavDropdown.Item href="#action/3.4">
                  버튼4
                </NavDropdown.Item>
              </NavDropdown>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>

      <div className='main-bg'></div>

      <div className='container'>
        <div className='row'>
          <div className='col-md-4'>
            <img src='https://codingapple1.github.io/shop/shoes1.jpg' width='80%'></img>
            <h4>상품명</h4>
            <p>상품설명</p>
          </div>
          <div className='col-md-4'>
            <img src='https://codingapple1.github.io/shop/shoes2.jpg' width='80%'></img>
            <h4>상품명</h4>
            <p>상품설명</p>
          </div>
          <div className='col-md-4'>
            <img src='https://codingapple1.github.io/shop/shoes3.jpg' width='80%'></img>
            <h4>상품명</h4>
            <p>상품설명</p>
          </div>
        </div>
      </div>
    </div>
  );
}

export default App;
