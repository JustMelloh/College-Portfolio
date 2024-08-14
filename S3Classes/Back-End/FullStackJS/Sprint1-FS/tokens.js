const fs = require("fs");
const path = require("path");
const crc32 = require("crc32");
const { format } = require("date-fns");

const myArgs = process.argv.slice(2);

function tokenCount() {
  fs.readFile(__dirname + "/json/tokens.json", (error, data) => {
    if (error) throw error;
    let tokens = JSON.parse(data);
    let count = 0;
    tokens.forEach((token) => {
      count += 1;
    });
    console.log(`There are ${count} tokens`);
  });
}

function tokenList() {
  fs.readFile(__dirname + "/json/tokens.json", (error, data) => {
    if (error) throw error;
    let tokens = JSON.parse(data);
    console.log("--- List of Users ---");
    tokens.forEach((token) => {
      console.log("-- " + token.username + ": " + token.token);
    });
  });
}

function addDays(currentDate, days) {
  let endDate = new Date(currentDate);
  endDate.setDate(endDate.getDate() + days);
  return endDate;
}


function makeToken(username) {
  let newToken = {
    "created at": "1987-11-13 01:38:12",
    "username": username,
    "email": "useremail@sample.com",
    "phone": "8463720091",
    "token": crc32(username).toString(16),
    "expires": format(addDays(new Date(), 14), "yyyy-MM-dd"),
    "confirmed": "tbd"
  };

  fs.readFile(__dirname + "/json/tokens.json", (error, data) => {
    if (error) throw error;
    let allTokens = JSON.parse(data);
    allTokens.push(newToken);
    let userTokens = JSON.stringify(allTokens, null, 2);

    fs.writeFile(__dirname + "/json/tokens.json", userTokens, (error) => {
      if (error) console.log(error);
      else {
        console.log(`New token created for ${username}: ${newToken.token}`);
      }
    });
  });

  return newToken.token;
}

function tokenApp() {
  switch (myArgs[1]) {
    case "--count":
      tokenCount();
      break;
    case "--list":
      tokenList();
      break;
    case "--new":
      if (myArgs.length < 3) {
        console.log("invalid syntax. node app token --new [username]");
      } else {
        makeToken(myArgs[2]);
      }
      break;
    case "--help":
      console.log("--Count: Displays the number of tokens.");
      console.log("--list: lists all tokens via token and username.");
      console.log(
        "--new [username]: creates a new token with the given username."
      );
      console.log("--help: Displays all tokens commands.");

    default:
      fs.readFile(__dirname + "/Usage.txt", (error, data) => {
        if (error) throw error;
        console.log(data.toString());
      });
  }
}

module.exports = {
  tokenApp,
  makeToken
};
