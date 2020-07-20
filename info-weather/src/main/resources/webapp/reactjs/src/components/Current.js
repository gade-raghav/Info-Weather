import React, {Component} from 'react';
import { Card,Form,Button,Col,Table  } from 'react-bootstrap';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {faCloud,faSave} from '@fortawesome/free-solid-svg-icons';
import axios from 'axios';

export default class Current extends Component {
    
    constructor(props){
        super(props);
        this.state = {
            city:'',
            weather: ''
                
            };
        this.cityChange = this.cityChange.bind(this);
        this.submitCity = this.submitCity.bind(this);
    
    }

    submitCity(event) {
        console.log("City=",this.state.city);
        
        axios.get('http://localhost:8080/weather/current/',{
            params: {
                location: this.state.city
            }
        })
        .then(response => response.data)
        .then((data) => {
            this.setState({weather: data})
        })
        event.preventDefault();
    }

    cityChange(event){
        this.setState({
            [event.target.name]:event.target.value
        });
    }
    
    render() {
        return (
            <Card className="border border-dark bg-dark text-white">
                <Card.Header>
                    <FontAwesomeIcon icon={faCloud}/> Current Weather
                </Card.Header> 
                <Form onSubmit={this.submitCity} id="cityFormId"> 
                <Card.Body> 
                    <Form.Row>
                    <Form.Group as={Col}>
                        <Form.Label>City </Form.Label>
                        <Form.Control required autoComplete="off"
                            type="text" 
                            name="city"
                            value={this.state.city}
                            onChange={this.cityChange}
                            className="bg-dark text-white"
                            placeholder="Enter City" />
                    </Form.Group>
                    </Form.Row>
                    </Card.Body>
                    <Card.Footer style={{"textAlign":"right"}}>
                    <Button size="sm" variant="success" type="submit">
                        <FontAwesomeIcon icon={faSave}/>  Submit
                    </Button>
                    </Card.Footer>
                    <Table striped bordered hover variant="dark">
                            <thead>
                                <tr>
                                    <th>City</th>
                                    <th>Country</th>
                                    <th>Temperature</th>
                                    <th>Main</th>
                                    <th>Description</th>
                                </tr>
                            </thead>
                            <tbody>
                            {this.state.weather.length === 0 ?
                                <tr align="center">
                                    <td colSpan="6">Enter city to get weather details</td>
                                </tr> : 
                                    <tr>
                                        <td>
                                            {this.state.weather.city}
                                        </td>
                                        <td>
                                            {this.state.weather.country}
                                        </td>
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
                        }
                        </tbody>
                    </Table>
                </Form>
            </Card>


        );
    }
}
