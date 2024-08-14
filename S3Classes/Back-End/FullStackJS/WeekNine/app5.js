const express = require('express');
const app = express();

const PORT = 3000;

app.set('view engine', 'ejs');

app.listen(PORT, () => {
    console.log(`Simple app running on port ${PORT}.`)
});

app.get('/', (req, res) => {
    res.render('index', {name: 'Wilber'});
});

app.get('/new', (req, res) => { // static route
    res.send(`the route is /new.`)
});

app.get('/customer/:id', (req, res) => { // dynamic route
    res.send(`the id is ${req.params.id}`)
});

app.get('/about', (req, res) => {
    res.render('about');
});



app.use((req, res) => {
    res.status(404).render('404');
});
