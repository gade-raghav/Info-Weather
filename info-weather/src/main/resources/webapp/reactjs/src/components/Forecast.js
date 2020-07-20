import React, {Component} from 'react';
import { Card,Form,Button,Col, Table } from 'react-bootstrap';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {faCloud,faSave} from '@fortawesome/free-solid-svg-icons';
import axios from 'axios';

export default class Forecast extends Component {
    
    constructor(props){
        super(props);
        this.state = { lat:'', lon:'', weather:[], i:'0' };
        this.submitCity = this.submitCity.bind(this);
        this.latChange = this.latChange.bind(this);
        this.lonChange = this.lonChange.bind(this);
    
    }

    submitCity(event) {
        console.log("lon=",this.state.lon);
        
        axios.get('http://localhost:8080/weather/forecast/',{
            params: {
                lat: this.state.lat,
                lon: this.state.lon
            }
        })
        .then(response => response.data)
        .then((data) => {
            this.setState({weather: data})
        })
        event.preventDefault();
    }

    latChange(event){
        this.setState({
            [event.target.name]:event.target.value
        });
    }
    
    lonChange(event){
        this.setState({
            [event.target.name]:event.target.value
        });
    }
    
    render() {
        return (
            <Card className="border border-dark bg-dark text-white">
                <Card.Header><FontAwesomeIcon icon={faCloud}/> Forecast Weather</Card.Header>
                <Form onSubmit={this.submitCity} id="cityFormId">
                    <Card.Body>
                    <Form.Row>
                    <Form.Group as={Col}>
                        <Form.Label>Latitude</Form.Label>
                        <Form.Control required autoComplete="off"
                            type="text"
                            name="lat"
                            value={this.state.lat}
                            onChange={this.latChange}
                            className="bg-dark text-white"
                            placeholder="Enter lat" />
                    </Form.Group>
                    <Form.Group as={Col}>
                        <Form.Label>Longitude</Form.Label>
                            <Form.Control required autoComplete="off"
                            type="text"
                            name="lon"
                            value={this.state.lon}
                            onChange={this.lonChange}
                            className="bg-dark text-white"
                            placeholder="Enter lon" />
                    </Form.Group>
                    </Form.Row>
                    </Card.Body>
                    <Card.Footer style={{"textAlign":"right"}}>
                    <Button size="sm" variant="success" type="submit">
                        <FontAwesomeIcon icon={faSave}/>Submit
                    </Button>
                    </Card.Footer>
                    <Card.Header>Weather forecast (this week) :{this.state.weather.location}</Card.Header>
                    <Table responsive striped bordered hover variant="dark" size="sm">
                            <thead>
                                <tr>
                                    <th>Day</th>
                                    <th>Temperature</th>
                                    <th>Main</th>
                                    <th>Description</th>
                                </tr>
                            </thead>
                            <tbody>
                            {this.state.weather.length === 0 ?
                                <tr align="center">
                                    <td colSpan="6">Enter latitude and longitude to get weather details</td>
                                </tr>
                                 : <React.Fragment>
                                    <tr>
                                        <td>day 1</td>
                                        <td>
                                            {this.state.weather.temp-273}&#8451;
                                        </td>
                                        <td>
                                            {this.state.weather.main} 
                                        </td>
                                        <td>
                                            {this.state.weather.description} 
                                        </td>
                                    </tr>
                                    <tr>
                                    <td>day 2</td>
                                        <td>
                                            {this.state.weather.temp2-273}&#8451;
                                        </td>
                                        <td>
                                            {this.state.weather.main2}
                                        </td>
                                        <td>
                                            {this.state.weather.description2}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>day 3</td>
                                        <td>
                                            {this.state.weather.temp3-273}&#8451;
                                        </td>
                                        <td>
                                            {this.state.weather.main3}
                                        </td>
                                        <td>
                                            {this.state.weather.description3}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>day 4</td>
                                        <td>
                                            {this.state.weather.temp4-273}&#8451;
                                        </td>
                                        <td>
                                            {this.state.weather.main4}
                                        </td>
                                        <td>
                                            {this.state.weather.description4}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>day 5</td>
                                        <td>
                                            {this.state.weather.temp5-273}&#8451;
                                        </td>
                                        <td>
                                            {this.state.weather.main5}
                                        </td>
                                        <td>
                                            {this.state.weather.description5}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>day 6</td>
                                        <td>
                                            {this.state.weather.temp6-273}&#8451;
                                        </td>
                                        <td>
                                            {this.state.weather.main6}
                                        </td>
                                        <td>
                                            {this.state.weather.description6}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>day 7</td>
                                        <td>
                                            {this.state.weather.temp7-273}&#8451;
                                        </td>
                                        <td>
                                            {this.state.weather.main7}
                                        </td>
                                        <td>
                                            {this.state.weather.description7}
                                        </td>
                                    </tr>
                                  
                                </React.Fragment>
                                    
                        }
                        </tbody>
                    </Table>
                    
                </Form>
            </Card>

        );
    }
}