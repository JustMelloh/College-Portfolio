// Main CLI
global.DEBUG = true;

// Import Modules
const fs = require("fs");

const { initApp } = require("./init.js");
const { tokenApp } = require("./tokens.js");
const { configApp } = require("./config.js");
const { getStatus } = require("./status.js");
const { userApp } = require("./userRecords.js");


const myArgs = process.argv.slice(2);

if (DEBUG) if (myArgs.length >= 1) console.log("The CLI args: ", myArgs);

switch (myArgs[0]) {
  case "init":
  case "i":
    if (DEBUG) console.log(myArgs[0], " :: Initialize the application.");
    initApp();
    break;
  case "config":
  case "c":
    if (DEBUG) console.log(myArgs[0], " :: Display the configuration file.");
    configApp();
    break;
  case "token":
  case "t":
    if (DEBUG) console.log(myArgs[0], " :: Generate a user token.");
    tokenApp();
    break;
  case "user":
  case "u":
    if (DEBUG) console.log(myArgs[0], " :: Update user information.\n");
    userApp();
    break;
  case "--help":
  case "--h":
  default:
    fs.readFile(__dirname + "/Usage.txt", (error, data) => {
      if (error) throw error;
      console.log(data.toString());
    });

}

