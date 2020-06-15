import React, { useState } from 'react';

const App =()=>{
  let newTime = new Date().toLocaleTimeString();
  const[ctime,setCtime]=useState();

  let newDate = new Date().toLocaleDateString();
  const[cdate,setCdate]=useState();
  
  
  const UpdateTime = () => {
     newTime = new Date().toLocaleTimeString();
    setCtime(newTime);

    newDate = new Date().toLocaleDateString();
    setCdate(newDate);


  };
  return (
    <>
    <h1>Welcome To local Time System</h1>
    <h2>Current Time : {ctime}</h2>
    <h2>Current Date : {cdate}</h2>
    <button onClick={UpdateTime}>get time & date</button>
</>
  );
}


export default App;