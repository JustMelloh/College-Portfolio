// Create templates for functions to build off of


const folders = ['Views', 'Logs', 'json'];

const configJSON = {
    name: 'CLI Config Interface',
    version: '0.0.1',
    description: 'A simple CLI for creating folders and adjusting/adding config files and creating tokens.',
    main: 'init.js',
    superuser: 'admin',
    database: 'postgreSQL'
};

const tokenjson = [{
    created: '1980-06-02 12:31:52',
    username: 'admin',
    email: 'user@example.com',
    phone: '555-555-5555',
    token: 'token',
    expires: '1983-01-24 12:30:00',
    confirmed: 'tbd'
}];

module.exports = { folders, configJSON, tokenjson };