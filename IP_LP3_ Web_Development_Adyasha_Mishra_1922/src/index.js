let express = require('express')
let app = express()
let timeRoute = require('./routes/time')
let path = require('path')
let bodyParser = require('body-parser')
app.use(bodyParser.json())

app.use((req, res, next) => {
    console.log(`${new Date().toString()}=> ${req.originalUrl}`, req.body)
        // res.send('')
    next()
})
app.use(timeRoute)

app.use(express.static('public'))

//Handler for 404 - Not Found
app.use((req, res, next) => {
        res.status(404).send('We think you are lost!')
    })
    //Handler for 500 - Not Found 
app.use((err, req, res, next) => {
    console.error(err.stack)
    res.sendFile(path.join(__dirname, '../public/500.html'))
})
const PORT = process.env.PORT || 3000
app.listen(PORT, () => console.info('server has started on ${PORT}'))