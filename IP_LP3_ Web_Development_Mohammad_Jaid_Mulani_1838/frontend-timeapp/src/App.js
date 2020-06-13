import React from 'react';
import {BrowserRouter as Router,
Switch,Route} from "react-router-dom";
import Navi from './Components/NavBar';

import HomePage from './Components/screens/homepage.jsx';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
return (
<div className="App">
<Router>
<div>
<Navi/>
<Switch>
<Route path="/">
<HomePage/>
</Route>

</Switch>
</div>
</Router>
</div>
);
}

export default App;
