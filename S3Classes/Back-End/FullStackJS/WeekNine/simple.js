const express = require("express");
const path = require("path")
const app = express();

const PORT = 3000;

// app.post   //CREATE html
// app.get    //READ html
// app.put    //UPDATE
// app.patch  //UPDATE 
// app.delete //DELETE

app.get("/", (request, response) => {
    console.log("root route.")
    response.send("the route for the sites root /.")
})

app.get('/html', (request, response) => {
    const filePath = path.join(__dirname, 'views/index.html');
    response.sendFile(filePath);
})

app.get('/web', (request, response) => {
	response.status(200).send('<h1>Hello World</h1>')
})

app.get('/text', (request, response) => {
        response.status(200).send('plain old text.')
})

app.get('/json', (request, response) => {
    response.status(200).json({school: 'Keyin College', program: 'software development'})
})

app.listen(PORT, () => {
    console.log(`Simple app running on port ${PORT}.`)
});