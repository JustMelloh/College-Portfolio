const fs = require("fs");

function getStatus() {
    // checking initialization status
    const initialized = fs.existsSync("config.txt");
    if (initialized) {
        console.log("Initialization status: Initialized");
    } else {
        console.log("Initialization status: Not initialized");
    }

    // checking configuration status
    const config = fs.existsSync("config.json"); // can change the file name when the config is set up :thumbsup:
    if (config) {
        console.log("Configuration status: Configured");
    } else {
        console.log("Configuration status: Not configured");
    }
}

module.exports = { getStatus };
