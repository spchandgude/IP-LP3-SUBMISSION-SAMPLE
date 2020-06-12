const express = require('express');

const router = express.Router();

//Routes
router.get('/time', (req, res) => {
    const date = new Date();
    console.log("Date : " + date);
    res.json(
        {
            date1: date.toDateString(),
            time1:date.toLocaleTimeString()
        }
    )
});

module.exports=router;