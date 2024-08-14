const express = require('express');
const app = express();

const PORT = 3000;

app.set('view engine', 'ejs');

app.listen(PORT, () => {
  console.log(`Simple app running on port ${PORT}.`)
});

app.get('/', (req, res) => {
  res.render('home', { name: 'Easter Bunny', title: 'HOME'});
});

app.get('/info', words, (req, res) => {
  res.write('testing.');
  res.end();
//  res.render('info', { title: 'INFO'});
});

app.get('/user/:id', (req, res) => { // dynamic route
  res.send(`the id is ${req.params.id}`)
});

const mealsRouter = require('./routes/meals.js')
app.use('/meals', mealsRouter);

app.use((req, res) => {
  res.status(404);
  res.render('404', { title: 'MISSING'});
});

function words(req, res, next) {
  if(req.query.words === 'coffee') {
      res.write('Brew a coffee. ');
      next();
  } else {
      res.write('Stay foggy. ');
      next();
  }
}