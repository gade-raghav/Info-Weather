import React,{Component} from 'react';
import {Navbar, Nav} from 'react-bootstrap';
import {Link} from 'react-router-dom';
export default class Navigationbar extends Component{


    render() {
        return (

            <Navbar bg="dark" variant="dark">
                <Link to={""}className="navbar-brand">
                    <img src="http://pngimg.com/uploads/sun/sun_PNG13449.png" width="25" height="25" alt="brand"/>Weather-API
                </Link>
            <Nav className="mr-auto">
            <Link to={"current"} className="nav-link">Current</Link>
            <Link to={"forecast"} className="nav-link">Forecast</Link>
            </Nav>
           </Navbar>


        );
    }
}
