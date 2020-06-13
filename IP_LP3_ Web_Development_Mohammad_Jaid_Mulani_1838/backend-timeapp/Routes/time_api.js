const express = require('express');
const router = express.Router();

router.get('/stime', (req, res) => {
    const date = new Date();
    const months=["Jan","Feb","Mar","Apr","May","Jun","July","Aug","Sep","Oct","Nov","Dec"];
    console.log("Today> " + date.getDate()+" "+months[date.getMonth()]+" "+date.getFullYear()+" & Time> "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds());
    res.json(
        {
            today: date.getDate()+" "+months[date.getMonth()]+" "+date.getFullYear(),
            hour: date.getHours(),
            minutes: date.getMinutes(),
            seconds: date.getSeconds()
        }
    )
});

module.exports=router;