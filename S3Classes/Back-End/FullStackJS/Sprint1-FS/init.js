// Use CLI to initialize the application to build the required directory and add a default config/help files.

// Import module requirements

const fs = require('fs');
const path = require('path');
const fsPromises =  require('fs').promises;
const { folders, configJSON, tokenjson } = require('./Template');

function createFolders(){
    // Debug 
    if(DEBUG) console.log('init.createFolders()');
    let mkCount = 0;

    // Create directories
    folders.forEach((folder) => {
        if(DEBUG) console.log(`Creating ${folder} directory...`);
        try {
            if (!fs.existsSync(path.join(__dirname, folder))) {
                fsPromises.mkdir(path.join(__dirname, folder));
                mkCount++;
        }
    } catch (err) {
        console.error(err);
    }
    });
    if (mkCount === 0) {
        console.log('Directories already exist.');
    } else if (mkCount <= folders.length) {
        console.log(mkCount + ' of ' + folders.length + ' directories created.');
    } else {
        console.log('All directories created.');
    }
};


function createFiles(){
    if(DEBUG) console.log('init.createFiles()');
    try {
        let configData = JSON.stringify(configJSON, null, 2);
        if(!fs.existsSync(path.join(__dirname, 'Config.json'))){
            fs.writeFile('./json/Config.json', configData, (err) => {
                if(err) {
                    console.log('Error creating Config.json file.');
                }
                else {
                    console.log('Config file written.');
                }
            })
        } else {
            console.log('Config file already exists.');
        }
        let tokenData = JSON.stringify(tokenjson, null, 2);
        if(!fs.existsSync(path.join(__dirname, 'Tokens.json'))){
            fs.writeFile('./json/Tokens.json', tokenData, (err) => {
                if(err) {
                    console.log('Error creating Tokens.json file.');
                }
                else {
                    console.log('Tokens file written.');
                }
            })
        } else {
            console.log('Tokens file already exists.');
        }
    } catch(err) {
        console.error(err);
    }
};


const myArgs = process.argv.slice(2);

function initApp(){

    switch(myArgs[1]){
        case '--all':
            if(DEBUG) console.log('--all createFolders() and createFiles()')
            createFolders();
            createFiles();
            break;
        case '--files':
            if(DEBUG) console.log('--files createFiles()');
            createFiles();
            break;
        case '--folders':
            if(DEBUG) console.log('--folders createFolders()');
            break;
        default:
            fs.readFile(__dirname + '/Usage.txt', 'utf8', (err, data) => {
                if (err) {
                    console.error(err);
                console.log(data.toString());
                }
            });
    }
}


module.exports = {
    initApp,
}