import React, { Component } from 'react';
import axios from 'axios';

var mylink1='http://localhost:4000/';
var errMsg_mylink1='issue with server check >>'+mylink1+'\n';
var c=0;

class HomePage extends Component {
    constructor(props) {
        super(props);
        this.state = { 
            today:'',
            hour:'',
            minutes:'',
            seconds:''
        };
    }

    updateTime(){
        axios.get("/stime")
        .then(response => {
            c+=1;
            console.log(c+":"+response);
            this.setState({
                today: response.data.today,
                hour: response.data.hour,
                minutes: response.data.minutes,
                seconds: response.data.seconds
            });                    
        })
        .catch(err => {
            console.log(errMsg_mylink1+err.message);
        })
    }
        
    get12hr(HH,MM,SS){ 
        var md='';
        HH=parseInt(HH);
        MM=parseInt(MM);
        SS=parseInt(SS);
        if(HH<12){
            md='AM';
        }else{
            md='PM'
        }   

        if (HH===0){
            HH=12;
        }else if(HH>12){
            HH=HH-12;
        }
        return HH+':'+MM+':'+SS+md;    
    }

    componentDidMount() {
        this.updateTime();    
    }

    componentWillMount(){
        this.resettime=setInterval(()=>this.updateTime(),(60000*1));
    }

    render() { 
    return ( <div className="myTime">
    <center>
        <h2>Date: {this.state.today}</h2> 
        <h2>(24Hr Format Time) {this.state.hour+':'+this.state.minutes+':'+this.state.seconds}</h2>
        

        <h2>(12Hr Format Time) {this.get12hr(this.state.hour,this.state.minutes,this.state.seconds)}</h2>
        <sub>note:-time would update after every 1min</sub>
    </center>    
    </div> );
    }
}

export default HomePage;