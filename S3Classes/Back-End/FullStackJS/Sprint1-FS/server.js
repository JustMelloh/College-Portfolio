// server.js
const express = require('express');
const bodyParser = require('body-parser');
const path = require('path');
const { makeToken } = require('./tokens');

const app = express();
const PORT = process.env.PORT || 3000;

app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

// Serve static files from the public directory
app.use(express.static(path.join(__dirname, 'public')));

app.post('/generate-token', (req, res) => {
  const { username } = req.body;
  const token = makeToken(username);
  res.json({ token });
});

app.listen(PORT, () => {
  console.log(`Server is running on port http://localhost:${PORT}`);
});
