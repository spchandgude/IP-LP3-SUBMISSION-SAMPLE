const express=require('express');
const morgan=require('morgan');
const routes = require('./Routes/time_api');
const app=express();
const PORT=process.env.PORT || 4000;

app.use(morgan('tiny'));
app.use('',routes);

app.listen(PORT,function(){
console.log('server started on port: '+PORT);
});
