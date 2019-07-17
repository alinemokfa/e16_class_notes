# Deploying a Ruby, Sinatra + SQL database app with Heroku

This is a walkthrough of how to set up your Project 1 to be available at a shareable URL using Heroku, a free cloud platform. Doing this will give you a nice URL to share your project with friends, family or employers.

### 1.	Initialise git in your project folder, stage all files and commit.

You should already have git running in your project folder, but if not (or if you want to make a copy to do this setup) you'll need to set it up with the usual commands and make sure all files are committed. 

```
git init
git add --all
git commit
```

Also make sure your database is set up locally and seeded with some data. 

### 2.	A few checks to be done to make sure the app will run on Heroku: 

- Remove any references to or use of pry - pry is a debugging tool to be used in development, but isn't compatible for live sites. Make sure any instances of requiring pry or using `binding.pry` are removed from all files.
- Make sure that if you are requiring `sinatra/contrib/all` that you follow it with `if development?` - again this is a tool that's used in development but should be disabled for the live site, which this line will do for you. So the full line should be:
`require('sinatra/contrib/all') if development?`
- Make sure that the ‘pg’ gem is required in your SQL runner file.

### 3.	Tell Heroku about which gems you are using in your Ruby project

Heroku needs to be given some more information about your app in order to be able to run it.

The first thing is a list of all of the Ruby gems used in your app, so that it can make sure to install them.

Make a file called 'Gemfile' (no file extension) and another called 'Gemfile.lock', both at the top level of your project folder.

Into 'Gemfile', put the following:

```
# Gemfile

source 'https://rubygems.org'
gem 'sinatra'
gem 'pg'
ruby '2.1.4'
```

This tells Heroku where the gems are coming from, and which ones you need for your app. If you have used any extra gems you will need to list them here too, with just `gem 'name'`.

Once this is done you need to run this command:

`bundle install`

This will populate 'Gemfile.lock' with some information - basically it checks out the gems you've listed to make sure they exist, and to see if they have any dependencies that Heroku needs to know about. You should never have to touch the contents of 'Gemfile.lock', just update 'Gemfile' and run `bundle install` again if you add any more gems.

### 4. Add some configuration information that Heroku needs

The other files that Heroku needs are ones to tell it how to run your app.

Firstly you should make a file called 'Procfile', again with no file extension. In here you need to tell Heroku what command should be run to run your app - so just the command you have been using so far to run it locally. We preface this with `web: `.

```
# Procfile

web: ruby controller.rb
```

If your top level controller file is called something other than controller.rb (it might be app.rb) change this to reflect that.

Finally you need to add a file that helps Sinatra to run. Make a new file called 'config.ru'.

In here you should put:

```
# config.ru

require './controller.rb'
run Sinatra::Application
```
Again if your top level controller has another name you need to reflect that here.

Ok, now you have all the extra files needed, so it's time to put your files on Heroku!
 
### 5. Install the Heroku command line tools

Heroku has some command line tools that you can use instead of having to navigate its site to do configuration. To install these, run:

`brew install heroku`

Next you need to connect your laptop with your Heroku account (if you don't have one, sign up for one at heroku.com), so you should run:

`heroku login`

Then fill out the information it asks for.

If there are any issues, check this page for help:
https://devcenter.heroku.com/articles/heroku-cli

### 6.	Create a new Heroku app and set up a database with it. 

OK, time to make a new Heroku app! First you should check that the app name you would like is free - the URL you'll get will be your app name + '.herokuapp.com', so go to ’desired name’.herokuapp.com to see if it's in use. If you see 'There's nothing here, yet' then it's available.

To make a new Heroku app using the command line tools, run this command within your project folder. Instead of 'my-app-name' put your chosen name. The --buildpack flag lets us tell Heroku where to find a build pack that it can use to build a Ruby based app. 

`heroku create my-app-name --buildpack https://github.com/heroku/heroku-buildpack-ruby.git`

If you look on your Heroku.com dashboard you should now see a link for your app.

Next you need to make a database for the app to use. Heroku has an addon for PostGres databases, so run this command to tell it to add one of those to your app: 
`heroku addons:create heroku-postgresql:hobby-dev`

This should print out some feedback to you, including a line that looks something like: 'Created postgresql-shallow-17291 as DATABASE_URL'. This capitalised variable at the end of the line will be needed in your next command.

As the feedback says, the database it's made is empty. You now need to copy the contents of your app's local database into the one you're using for your site - the database name should be put instead of 'database-name' and your app name instead of 'my-app-name'. If your capitalised variable returned from the setup was something different this should also be replaced. 

`heroku pg:push database-name DATABASE_URL --app my-app-name`

To check everything has been set up properly, you can open Heroku's command line interface for PostGres - this is similar to when you use 'psql', so you can enter SQL commands. Open the interface with:

`heroku pg:psql`

Try a command like `SELECT * FROM table;` with one of your table names to check the data has been copied over. 

### 7. Tell your app to use your Heroku database.

Your SQL runner is currently using your local database, so you need to change its settings to use your new Heroku database. You may want to leave the old settings in the file, commented out, in case you want to switch back to running it locally. 

To find the settings information, log into Heroku.com and click on your app's name to go to its dashboard. Then go to:

Resources tab > Heroku Postgres :: Database link > Database Credentials section.

In your SQLRunner.rb file, or wherever your PostGres connection is being done, change the settings to use the information in the Database Credentials section. 'Database' is used for 'dbname', and you will need to change the host from 'localhost' to the AWS address. You also need to add the port, user, and password. The settings should end up looking similar to this:

```
PG.connect( {dbname: 'dasdkdsaldkj', 
host: 'ec2-1-1-1-1-1.compute-1.amazonaws.com', 
port: 5432, user: 'nsdlkdjalskjd', password: 'sadlskjadlkjASDAD'})
```

### 8. Push all changes to Heroku, then view your app!

Now you've made all the necessary changes and have your database set up, do a final `git add` and `git commit`.

When you ran the 'heroku create' command, this also set up a new git remote called 'heroku', so basically a separate git repo associated with this Heroku app. You can see it by running `git remote -v`.

To push your app up to this remote, and therefore to your app's URL, run: 

`git push heroku master`

You will see a lot happening when this command is run - Heroku is installing all the dependencies and building your app for you.

Once this is finished (hopefully with no errors!), you need to tell Heroku to set up what's called a 'dyno', basically a container that can run processes for you. We want a 'web dyno' - remember when you set up the Procfile, and told it what the 'web' command should be? The web dyno will look in that file to see what process it should run. Exactly what dynos are and what they do isn't something you really need to understand yet.

To set a dyno running, you need to run this command:

`heroku ps:scale web=1`

If you wait a couple of minutes for this to get set up, you should then be able to visit 'your-app-name.herokuapp.com' and see your app! (The first time you make a request, it can take a few seconds to load up as the dyno will 'sleep' until it's asked to do something)

 Note: if you don’t have a ‘/‘ home route set up in your app it will come up ‘not found’, so you will need to add a route after your app url to see anything (e.g. your-app-name.herokuapp.com/films), just the same as we have been doing after 'localhost:4567'.
 
 

