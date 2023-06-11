import React from "react";
import { createRoot } from 'react-dom/client';
import { Route,Link, HashRouter as Router, Routes } from "react-router-dom";
import Home from "./components/Home";
import NotFound from "./components/NotFound";
import { Container, Navbar, Nav, Button } from "react-bootstrap";
import Login from "./components/Login/Login";
import { logout } from "./services/auth";
import Tasks from "./components/tasks/Tasks";
import EditTask from "./components/tasks/EditTask";
class App extends React.Component {
  render() {
      return (
        <div>
          <Router>
            <Navbar bg="dark" variant="dark" expand>
              <Navbar.Brand as={Link} to="/">
                Scrum
              </Navbar.Brand>
              <Nav className="mr-auto">
                <Nav.Link as={Link} to="/tasks">
                  Tasks
                </Nav.Link>
              </Nav>
              {window.localStorage['jwt'] ? 
                  <Button onClick = {()=>logout()}>Log out</Button> :
                  <Nav.Link as={Link} to="/login">Log in</Nav.Link>
              }
            </Navbar>
            <Container style={{marginTop:25}}>
              <Routes>
                <Route path="/" element={<Home/>} />
                <Route path="/tasks" element={<Tasks/>} />
                <Route path="/tasks/edit/:id" element={<EditTask/>} />
                <Route path="/login" element={<Login/>}/>
                <Route path="*" element={<NotFound/>} />
              </Routes>
            </Container>
          </Router>
        </div>
      );
  }
}
const rootElement = document.getElementById('root');
const root = createRoot(rootElement);
root.render(
    <App/>,
);