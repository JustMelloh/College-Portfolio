<h1>CLI for Full Stack Sprint</h1>
<hr>

<h1>Description</h1>
<hr>

<p>This CLI is able to initialize itself, diplay configuration file, set/update the configuration file<br>
add tokens by username.</p>

<h1>Usage</h1>
<hr>

Command Example:

app <command> <option>

Usage -- 
<hr>

<h3>Help</h3> 
<hr>

app --help :: Displays help

<h3>Initializations</h3>
<hr>
<br>
app init :: Initialize the app<br>
app init --files :: Create the DEFAULT app files<br>
app init --folders :: Create the DEFAULT app folders<br>
app init --all :: Create all DEFAULT folders and files<br>
<br>
<h3>Configurations</h3>
<hr>

app config --display :: Displays current configuration file.<br>
app config --set <KEY NAME> <KEY VALUE> :: Sets/Updates the selected key from the configuration file. <br>

<h3>Tokens</h3>
<hr>
<br>
app token --count :: Displays the number of tokens<br>
app token --list :: Lists all tokens by username and token<br>
app token --new [username] :: Creates a new token with the provided username<br>
app token --help :: Displays all token commands
<br>

<h3>User Updates</h3>
<hr>
<br>
Email is prioritized when both registries need to be changed -> <br>
app user (function) (username) (email) (phone)<br>
<hr>
Usage: app user (function) (username) (phone)<br>

app user --updatePhone :: Updates the users phone number<br>
app user --updateEmail :: Updates the users email<br>
app user --removeUser :: Removes user from the DB<br>
<br>

<h3>User Search</h3>
<hr>
<br>
app user --search username [username] :: Searches by username<br>
app user --search email [email] :: Searches by email address<br>
app user --search phone [phone] :: Searches by phone number<br>