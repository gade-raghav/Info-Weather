import React from 'react';
import './App.css';
import {Container, Row,Col} from 'react-bootstrap';
import Navigationbar from "./components/Navigationbar";
import Welcome from "./components/Welcome";
import Footer from "./components/Footer";
import Current from "./components/Current";
import Forecast from "./components/Forecast";
import {BrowserRouter as Router , Switch , Route} from 'react-router-dom';
function App() {
  const marginTop = {
    marginTop:"20px"
  }


  return (
  <Router>
   <Navigationbar/>
   <Container>
     <Row>
       <Col lg={12} style={marginTop}>
         <Switch>
           <Route path="/" exact component={Welcome}/>
           <Route path="/current" exact component={Current}/>
           <Route path="/forecast" exact component={Forecast}/>
         </Switch>
    </Col>
     </Row>

   </Container>
   <Footer/>
  </Router>
  );
}

export default App;
