// Create the Config for the CLI


// Import Modules and Variables

const fs = require('fs');
const myArgs = process.argv.slice(2);

// TO DO: (Daniel) Create the displayConfig function to view the config files
function displayConfig() {
    fs.readFile(__dirname + "/json/Config.json", (error, data) => {
        if (error) throw error;
        let config = JSON.parse(data);
        console.log(`Name: ${config.name}\nVersion: ${config.version}\nDescription: ${config.description}\nMain: ${config.main}\nSuper User: ${config.superUser}\nDatabase: ${config.database}`);
    })
}

// DONE: (Beck) Create the resetConfig function to reset to default 
function resetConfig() {
    fs.readFile(__dirname + "/json/DefaultConfig.json", (error, defaultData) => {
        if (error) throw error;
        fs.writeFile(__dirname + "/json/Config.json", defaultData, (error) => {
            if (error) throw error;
            console.log("Config file successfully reset to default.");
        });
    });
}

function setConfig() {
    if (DEBUG) console.log("config.setConfig()");
    if (DEBUG) console.log(myArgs);

    let match = false;
    fs.readFile(__dirname + "/json/Config.json", (error, data) => {
        if (error) throw error;
        if (DEBUG) console.log(JSON.parse(data));
        let cfg = JSON.parse(data);
        for (let key of Object.keys(cfg)) {
            if (DEBUG) console.log(`KEY: ${key}`);
            if (key === myArgs[2]) {
                cfg[key] = myArgs[3];
                match = true;
            }
        }
        if (!match) {
            console.log(`invalid key: ${myArgs[2]}, try another.`);
        }
        if (DEBUG) console.log(cfg);
        data = JSON.stringify(cfg, null, 2);
        fs.writeFile(__dirname + "/json/Config.json", data, (error) => {
            if (error) throw error;
            if (DEBUG) console.log("Config file successfully updated.");
        });
    });
}

// Commands for the Configuration data.
function configApp() {
    if (DEBUG) console.log("configApp()");

    switch (myArgs[1]) {
        case "--display":
            if (DEBUG) console.log("--display")
            displayConfig();
            break;
        case "--reset":
            if (DEBUG) console.log("--reset")
            resetConfig();
            break;
        case "--set":
            if (DEBUG) console.log("--set")
            setConfig();
            break;
        case "--help":
        case "h":
        default:
            fs.readFile(__dirname + "/Usage.txt", (error, data) => {
                if (error) throw error;
                console.log(data.toString());
            });
    }
}

module.exports = {
    configApp,
}
