// User Issue #7: As a helpdesk employee I would like the CLI to provide the ability to add/update the user records email and/or phone number

/* Import Module */

const fs = require('fs');
const path = require('path');


// Variable

const myArgs = process.argv.slice(2);



/* Functions */

function updateUserPhone(){
    // Get username 
    const username = process.argv[4];
    // Get phone number
    fs.readFile(path.join(__dirname, 'json/Tokens.json'), 'utf8', (err, data) => {
        if (err) {
            console.error(err);
            return;
        }

        let users = JSON.parse(data);
        let user = users.find(user => user.username === username);
        if (user) {
            user.phone = process.argv[5];
            fs.writeFile(path.join(__dirname, 'json/Tokens.json'), JSON.stringify(users, null, 2), (err) => {
                if (err) {
                    console.error(err);
                    return;
                }
                console.log(`${username}'s phone number updated to ${process.argv[5]}`);
            });
        } else {
            console.log(`${username} not found`);
        }
    });
}

// Create a function for updating user email

function updateUserEmail(){
    // Get username
    const username = process.argv[4];
    // Get email
    fs.readFile(path.join(__dirname, 'json/Tokens.json'), 'utf8', (err, data) => {
        if (err) {
            console.error(err);
            return;
        }

        let users = JSON.parse(data);
        let user = users.find(user => user.username === username);
        if (user) {
            user.email = process.argv[5];
            fs.writeFile(path.join(__dirname, 'json/Tokens.json'), JSON.stringify(users, null, 2), (err) => {
                if (err) {
                    console.error(err);
                    return;
                }
                console.log(`${username}'s email updated to ${process.argv[5]}`);
            });
        } else {
            console.log(`${username} not found`);
        }
    });
}

// Creating a function to update both email and phone number

function updateUserBoth(){
    // Get username
    const username = process.argv[4];
    // Get email
    fs.readFile(path.join(__dirname, 'json/Tokens.json'), 'utf8', (err, data) => {
        if (err) {
            console.error(err);
            return;
        }
        // Parse the data from Token.json
        let users = JSON.parse(data);
        let user = users.find(user => user.username === username);
        if (user) {
            user.email = process.argv[5];
            user.phone = process.argv[6];
            // Write the data to Token.json
            fs.writeFile(path.join(__dirname, 'json/Tokens.json'), JSON.stringify(users, null, 2), (err) => {
                if (err) {
                    console.error(err);
                    return;
                }
                console.log(`${username}'s email updated to ${process.argv[5]} and phone number updated to ${process.argv[6]}`);
            });
        } else {
            console.log(`${username} not found`);
        }
    });
}


/* Create a function to remove a user record from Token.json */

function removeUser(){
    // Get username
    const username = process.argv[4];
    // Read the data from Token.json
    fs.readFile(path.join(__dirname, 'json/Tokens.json'), 'utf8', (err, data) => {
        if (err) {
            console.error(err);
            return;
        }
        // Parse the data from Token.json
        let users = JSON.parse(data);
        let user = users.find(user => user.username === username);
        if (user) {
            // Remove the user from the Token.json
            users = users.filter(user => user.username !== username);
            // Write the data to Token.json
            fs.writeFile(path.join(__dirname, 'json/Tokens.json'), JSON.stringify(users, null, 2), (err) => {
                if (err) {
                    console.error(err);
                    return;
                }
                console.log(`${username} removed from DB`);
            });
        } else {
            console.log(`${username} not found`);
        }
    });
}

// created the command to search for a user by name, phone or email.
function searchUser() {
    fs.readFile(__dirname + "/json/Tokens.json", (error, data) => {
        if (error) throw error;
        let users = JSON.parse(data);
        let searchValue = myArgs[3];
        switch(myArgs[2]){
        case "username":
            let userName = users.find(userName => userName.username === searchValue)
            console.log(userName);
            break;
        case "email":
            let userEmail = users.find(userEmail => userEmail.email === searchValue)
            console.log(userEmail);
            break;
        case "phone":
            let userPhone = users.find(userPhone => userPhone.phone === searchValue)
            console.log(userPhone);
            break;
        }
})
}
// Create the CL Commands for the User Records

function userApp(){
    switch(myArgs[1]) {
    case "--updatePhone":
        updateUserPhone();
        break;
    case "--updateEmail":
        updateUserEmail();
        break;
    case "--updateBoth":
        updateUserBoth();
        break;
    default:
    case "--removeUser":
        removeUser();
        break;
    case "--search":
        searchUser();
        break;
    case "--help":
        fs.readFile(path.join(__dirname, 'Usage.txt'), 'utf8', (err, data) => {
            if (err) {
                console.error(err);
                return;
            }
            console.log(data.toString());
        });
    }
}

module.exports = {updateUserPhone,updateUserEmail,updateUserBoth, removeUser, userApp};