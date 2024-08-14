const express = require('express');
const path = require('path');
const app = express();

const PORT = 3000;

app.listen(PORT, () => {
    console.log(`Simple app running on port ${PORT}.`)
});

app.set('view engine', 'ejs');

app.get('/', (req, res) => {
    res.render('index.ejs', {name: 'Darth Vader'});
});

app.get('/test', (request, response) => {
//    const filePath = path.join(__dirname, 'views/test.html');
    response.render('test.ejs')
})

app.get('/about', (req, res, next) => {
    res.render('about');
});

app.use((req, res, next) => {
    res.status(404);
    res.render('404');
});
