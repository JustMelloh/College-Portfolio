const express = require('express');
const app = express();
const PORT = 3000;

app.set('view engine', 'ejs');

app.get('/', (req, res) => {
    res.render('index.ejs', { name: 'William'});
});

const mealsRouter = require('./routes/meals')
app.use('/meals', mealsRouter);

const shoppingRouter = require('./routes/shopping')
app.use('/shopping', shoppingRouter);

app.use((req, res) => {
    res.status(404).render('fourohfour');
});

app.listen(PORT, () => {
    console.log(`Simple app running on port ${PORT}.`)
});