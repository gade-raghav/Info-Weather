import React,{Component} from "react";
import {Jumbotron} from 'react-bootstrap';

export default class Welcome extends Component {
    render() {
        return (

            <Jumbotron className="bg-dark text-white">
                <h1>Hello!</h1>
                <p>
                    This is a simple weather api which gives current and forecast weather.
                </p>
            </Jumbotron>

        );
    }
}

