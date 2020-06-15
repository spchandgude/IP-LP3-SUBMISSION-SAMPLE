import React from 'react';
import * as ReactBootStrap from 'react-bootstrap';

function Navi(){
return(
<ReactBootStrap.Navbar bg="light" expand="lg">
<ReactBootStrap.Navbar.Brand href="/">App_HomePage</ReactBootStrap.Navbar.Brand>

<ReactBootStrap.Navbar.Toggle aria-controls="basic-navbar-nav" />
<ReactBootStrap.Navbar.Collapse id="basic-navbar-nav">
<ReactBootStrap.Nav className="mr-auto">
{/* 
<ReactBootStrap.Nav.Link href="/time">TIME</ReactBootStrap.Nav.Link>
<ReactBootStrap.Nav.Link href="/date">DATE</ReactBootStrap.Nav.Link>*/}
<ReactBootStrap.Nav.Link href="/">Home</ReactBootStrap.Nav.Link> 
</ReactBootStrap.Nav>

</ReactBootStrap.Navbar.Collapse>
</ReactBootStrap.Navbar>
);
};

export default Navi;
