import React, { Component } from 'react';
import axios from 'axios';
import './App.css';

class CarForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      cars: [],
      id: '',
      model: '',
      make: '',
      production_year: '',
      engine: '',
      fuel: ''
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleDelete = this.handleDelete.bind(this);
  }

  componentDidMount() {
    axios.get('http://localhost:8080/get')
      .then(response => {
        this.setState({ cars: response.data });
      })
      .catch(error => {
        console.log(error);
      });
  }

  handleChange(event) {
    const target = event.target;
    const name = target.name;
    const value = target.value;
    this.setState({
      [name]: value
    });
  }



handleSubmit(event) {
  event.preventDefault();
  const carModel = {
   
    model: this.state.model,
    make: this.state.make,
    production_year: this.state.production_year,
    engine:this.state.engine,
    fuel:this.state.fuel
  }; 
  axios.post('http://localhost:8080/post', carModel)
    .then(response => {
      const cars= this.state.cars.concat(response.data);
        this.setState({
        cars:cars,
        model: '',
        make: '',
        production_year: '',
        engine: '',
        fuel: ''
      });
    })
    .catch(error => {
      console.log(error);
    });
}

  handleDelete(id) {
    axios.delete('http://localhost:8080/de/'+ id)
      var cars =this.state.cars.filter(n=>n.id!=id);
      this.setState({cars});
  }

  render() {
    return (
      <div className='car'>
        <h2>Add a Car</h2>
        <form onSubmit={this.handleSubmit}>
          
          <label htmlFor="model">Model:</label>
          <input type="text" id="model" name="model" value={this.state.model} onChange={this.handleChange} />
          <label htmlFor="make">Make:</label>
          <input type="text" id="make" name="make" value={this.state.make} onChange={this.handleChange} />
          <label htmlFor="production_year">Production Year:</label>
          <input type="text" id="production_year" name="production_year" value={this.state.production_year} onChange={this.handleChange} />
          <label htmlFor="engine">Engine:</label>
          <input type="text" id="engine" name="engine" value={this.state.engine} onChange={this.handleChange} />
          <label htmlFor="fuel">Fuel:</label>
          <input type="text" id="fuel" name="fuel" value={this.state.fuel} onChange={this.handleChange} />
          <button type="submit">Add Car</button>
        </form>
        <h2>Cars</h2>
        <ul>
          {this.state.cars.map(car => (
            <li key={car.id}>
              Model: {car.model} , Make: {car.make} ,  production_year:{car.production_year} , engine:{car.engine} , fuel:{car.fuel}
              <button onClick={()=>this.handleDelete(car.id)}>Delete</button>
        </li>
      ))}
    </ul>
  </div>
)}}
export default CarForm;
