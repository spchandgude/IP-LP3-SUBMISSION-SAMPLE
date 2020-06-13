import React, { Component } from 'react';
import axios from 'axios';
import './App.css';

class HomePage extends Component {
    constructor(props) {
        super(props);
        this.state = { 
            date1:'',
            time1:''
        };
    }

    updateTime(){
        axios.get("/time")
        .then(response => {
            console.log("State: "+response);
            this.setState({
                date1: response.data.date1,
                time1: response.data.time1,
            });                    
        })
        .catch(err => {
            console.log(" Error : "+err.message);
        })
    }

    componentDidMount() {
        this.updateTime();    
    }

    componentWillMount(){
        this.resettime=setInterval(()=>this.updateTime(),(1000));
    }

    render() { 
    return ( 
    <div className="App">
        <p className="date">{this.state.date1}</p> 
        <p className="time">{this.state.time1}</p>  
        <p className="text">Date and Time</p> 
    </div> 
        );
    }
}

export default HomePage;