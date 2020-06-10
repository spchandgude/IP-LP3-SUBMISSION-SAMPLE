let express = require('express')
let router = express.Router()


// api call
//localhost:3000/time
router.get('/time', (req, res) => {
    res.send(Date(Date.now()))

})

router.get('/error', (req, res) => {
    throw new Error('This is a forced error.')
})


module.exports = router