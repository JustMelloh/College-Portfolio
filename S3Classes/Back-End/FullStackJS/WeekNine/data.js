const express = require("express");
const app = express();

app.get('/', (request, response) => {
    response.send('<h1>Hello World</h1>')
//    response.status(200).send('<h1>Hello World</h1>')
})
app.get('/text', (request, response) => {
    response.status(200).send('plain old text.')
})
app.get('/json', (request, response) => {
    response.status(200).json({school: 'Keyin College', program: 'software development'})
})

app.listen(3000)