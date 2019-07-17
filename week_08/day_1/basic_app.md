# EightBallActivity App - Base App

## Learning Objectives

* Know how to create a simple activity in Android Studio
* Understand how to debug an app using breakpoints
* Be able to build and run you app successfully


## Project Structure

Yesterday we created the model to store the answers for our Magic Eight-Ball App. Today we are now going create the actual Android App for our Eight-Ball, using the model we created yesterday. So let's open up the project we created yesterday...

Before we start let's have a little look at the layout of our project in Android Studio.

### AndroidManifest.xml

This file contains all the information that the OS needs to run the application. We will revisit it later and see why it is so important.

### Java

This is where the "package" goes that we created.  All of our code that we write in Java lives here.

There is also the Tests package where we put our lovely unit tests.

### Gradle Scripts

Gradle is a task runner for Java and Android, we don't need to worry too much about this for now. We'll come back to it later in the week.

>: Gradle is a build tool which takes your Java code and XML layouts, and then uses the latest Android build tools to create the app package file, known as an APK file. You can customize your configurations to have development or production versions of the app that behave differently, or add dependencies for third-party libraries. Taken from [here](https://www.raywenderlich.com/78574/android-tutorial-for-beginners-part-1)

### Res

This is where any "resources" that are not Java code will live. This includes: image files, audio files and most importantly XML files. We will use these XML files to scaffold our application and define things such as how things will be displayed on our device.

Drawable is where we will put images. "Launcher" icons (the icon on our phone) reside in the mipmap/ folder rather than the drawable/ folders. Values is where we can store text which can be accessed across our application but we will return to this in more depth later.

## A world without HTML

So far we have been building apps where we use HTML to structure how elements are displayed on the page. We can then use CSS to style these elements and make them look nice.

However...

We are now in a world where we have no HTML. It lives in the browser. We are building a "native" app - this is an application which is tied to the OS and uses specific capabilities of the device. It's not like a browser which can run on many OS types.

We need a way to interact with our device and display things to users. The good news is, Android uses XML to achieve this in a very similar manner to how we use HTML in the browser.

## Activities and Intents

Android has the concept of "activities" and "intents". We will look more in depth at these concepts as we build our apps as you can see it in context.

Activities are basically an individual screen in your app which is responsible for drawing it's components, like buttons and text boxes.

Intents sit between both the OS and activites, giving the OS actions to do and giving back information to activities but also sit in between activities passing around information.

That's enough on this for now.

## Our First Activity

Let's take a look at how we can add activities to our existing Java app.

```
Make sure the "Project" pane is open (cmd+1)
Right click on app
New > Activity > Gallery
```

> Take a moment to point out some of the different types of Activity that are available.

For now, we're going to use the most basic type of activity - Empty Activity.

```
Select Empty Activity and click Next
```

Android Studio then gives us the opportunity to customise various settings for the activity we're about to create.

Firstly, we want to edit the activity name. You'll see that by default, we are offered the not-very-descriptive "MainActivity". Let's change this.

```
Change the Activity Name to "EightBallActivity"
```

Next, take a look at the checkbox marked "Generate Layout File." We're going to leave this checked just now. The next line asks us for the name of our layout - this should have updated to "activity_eight_ball". 

This should mean that we will end up with a layout file called "/res/layout/activity_eight_ball.xml".

Remember that we mentioned that while web apps used HTML, Android apps used XML? Well, this is the XML file that will hold our layout.

```
Click the checkbox marked "Launcher Activity".
```

We're going to make this activity our "Launcher Activity." This means that when we touch the app's icon on our phones, this activity will be the one that starts up.

Basically, this is the entry point to our app - the first thing the user will see when the app opens.

Finally:

```
Make sure that "Backwards Compatability (AppCompat)" is checked
```

Making sure that "Backwards Compatibility" is checked ensures that some of Android's newer features will work properly on older versions of Android. (For example, some of the newer animation transitions.)

You can leave "Package Name" and "Target Source Set" for now.

```
Click finish to set up the activity.
```

When we click "finish', Android Studio creates two files, and edits one more. Let's take a look at what it's done.

## AndroidManifest.xml

In the ```app/manifests``` directory there is a file called AndroidManifest.xml. This is a VERY important file. It gives the app all the information it needs about resources that it needs to use when it is running.

Every activity we want to include needs to be listed here otherwise the app can't find it when it's running. Remember we mentioned at the start that this file was important?

The first thing to note is that some of the application settings are stored here. Take a look at the following:

```
<application
    android:allowBackup="true"
    android:icon="@mipmap/ic_launcher"
    android:label="@string/app_name"
    android:supportsRtl="true"
    android:theme="@style/AppTheme">
``` 

You can see that we can control settings such as the name of the application, the application's icon, and the "theme" of the app. (This is the app's default styling.)

Within the <application> tag, a new <activity> tag has been created - for the activity we created a moment ago. Let's take a look at some of the settings.

```
<activity android:name=".EightBallActivity">
  <intent-filter>
    <action android:name="android.intent.action.MAIN" />
    <category android:name="android.intent.category.LAUNCHER" />
  </intent-filter>
</activity>
```

Firstly, our ```<activity>``` tag takes the name of the Java file that should be called for this activity. In this case, .EightBallActivity.

Secondly, notice within the ```<intent-filter>``` tag that we are setting this activity to be the entry point for our app. We are doing this by setting ```<action android:name="android.intent.action.MAIN" />```.

Thirdly, we are going to specify that the app should be placed in our phone's launcher, by specifying ```<category android:name="android.intent.category.LAUNCHER" />```.

As we add new activities, Android Studio should add more ```<activity>``` tags accordingly.

## activity_eight_ball.xml

You can see that Android Studio has generated an XML file for us called `activity_eight_ball.xml`. 

When we open this file, by default, we are taken to the design view. This is where we will design most of our layouts but for some things we will need to go back to the old way of doing it in text.

You'll see that our layout file comes with a parent element - a ```<ConstraintLayout>```. This lets us position our controls relative to each other as well as the parent container and allows our app to scale up easier when moving to different screen sizes. The other most commonly used layouts are ```<LinearLayout>``` and ```<RelativeLayout>```.

> n.b. By default, we're now given a ```<ConstraintLayout>``` rather than a ```<LinearLayout>``` or ```<RelativeLayout>```. If you prefer, change this over. (It's probably easier to change the root element in the Design view, rather than the text view!)

We're going to put our app's controls inside our layout element, but we'll come back to this later.

## EightBallActivity.java

The last file that we've created is a java file - EightBallActivity.java. 

The most important thing to note here is that this file is just plain Java. There might be a few new things to take note of, but by this point, you should have seen all of the main concepts already.

Let's take a look at some of the default code for an empty activity.

```
public class EightBallActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight_ball);
    }
}
```

Our new activity class would usually extend AppCompatActivity. This class is itself a subclass of android.app.Activity, so our new activity is also a subclass of Activity.

The next thing to note is that our app is overriding a method called `onCreate()`. In this method, we can do any initialization that we need to do for the activity. 

We're also passing in a single argument to onCreate - a Bundle called savedInstanceState. What's that all about?

Simply, the `Bundle savedInstanceState` is used to restore the state of the app if it had been running before then shut down. 

We're then passing the savedInstanceState up to the parent class with a call of:

```
super.onCreate(savedInstanceState);
```

Finally, we have to tell Android which layout file it should display to the user:

```
setContentView(R.layout.activity_eight_ball);
```

## Design patterns

> At this point, it might be worth drawing a comparison on the board to the MVC design pattern that the students should have seen by now. The model is our Answer class, the view is our XML layout file, and the controller is our activity java file.

## Emulation

It would be good to see what our app looks like. This is an app for a mobile device and we are using a Mac... we know that Android specifically targets the mobile OS so how can we run it?

Luckily Android Studio provides us with an "emulator". These are actually really cool and fast now and make it easy for us to run our programs as if it was on a native mobile device.

```
Click on the green play button.
```

We have no running device so we have to launch an emulator.

> If you don't see the Android menu then try building the project first.

```
Tools > Android > AVD Manager
Create a virtual device
Select hardware -> Tablet -> Nexus 7

```
There are various api levels we can choose from. Let's go for the Api level 16 - we are running an x86 machine so we will go with that.

> x86 is the processor for the Mac rather than for the device.  This is just the name of the Intel family of processors, other options might be AMD64 or Armabi etc.

Select "Release Name: Marshmallow | API Level: 23 | ABI: x86_64 | Target: Android 6.0"
Click Download and install HAXM - you will need to enter the password for your laptop.
Hit next, then finish to return the the AVD setup now that you've installed HAXM.

```
Configuration

Leave this all as it is with portrait orientation
```
We should now see this in our list of devices.

```
Click the green play button on the top.
```

We can now choose the device we just created from the "launch emulator" dropdown.

```
Hit OK, this will launch AVD...
```

If it doesn't launch, you may need to restart Android studio before you can run the AVD.

This takes just as long as a device takes to boot up!

When this has finished loading, it will look like a tablet on our screen. It next has to load our program onto the device.

If we look in the log we should see this happen.

>: Demo the log

## Let's run it!!!

```
Click green play button
Click applications icon (3 dotted lines)
Click the wee android that says Eight Ball!
```

## Strings and Stuff

What if we want to change the name of the app? It's currently hard coded in our manifest file. It's feasible we might want to use the name of the app in other places - like on the menu, footer.

Luckily, we have a place to put any "resources" that we might want to use.

```
res > values > strings.xml
```

We can add a new entry to here which we can access all across our application, using the handy R class we encountered before.

There's already a sample entry in here called "app_name". This name is how we are going to access it (just like we did with ids in HTML and JS) and the text between the tags is what will be returned.

[Task:] Update this text to be something fun (and short!)

Return to the manifest.xml and where we had ```android:label="Eight Ball!"``` let's make it dynamic. We need to use a special syntax to access entries in our strings.xml.

```xml
"@string/app_name"
```

`@string` shows that it's part of the "strings" resource. Even though the filename is plural, we access it using the singular just like with DB tables. Then we put a slash and the "name" we gave to the xml tag.

## Debugging

Obviously if things go wrong then we want to debug our code. In Android Studio two main ways of tracking how things are going when our program is running are by using breakpoints, and using logging.

### Breakpoints

Adding breakpoints in Android Studio is pretty easy ([i]: Aye right!). All you need to do is to click on the grey bar to the left of the code, next to the line of code you wish to place the breakpoint on.

To get the code to stop at the breakpoint when running, rather than click on the 'Run' button, you click on the 'Debug' button (it looks like a wee bug on the top toolbar) . The code will run as before, but will stop at the breakpoint.

### Logging

Another way to track things is to use logging. Logging is useful especially if you want to run your App without stopping at breakpoints. Logging allows us to display useful messages in the IDE console while running our App in the emulator. Let's add a logging message which tells us whenever the ```onCreate()``` method is called in ```EightBallActivity.java```.

In EightBallActivity.java, add the following line to the onCreate() method:

```java
Log.d(getClass().toString(), "onCreate called");
```
> the 'd' stands for 'debug'. There are many others e.g. 'e' for error.

> We use `getClass().toString()` so that we can see in the logs what class the line was printed from. We could also just type `"EightBallActivity"` but this way if we change the class name we'll still get the right thing printed out.

Now rerun the app and look in the 'Logcat' window in the bottom of the IDE. Among all the logging messages you should see something along the lines of the following message:

```
example.codeclan.com.EightBallActivity: onCreateCalled
```

You can see that there are lots of other logging messages displayed. Wouldn't it be great if we could only show the messages which we have created?

We can do this by applying filters to the logging. Above the window showing the logging messages you should see a textbox window with a magnifying glass inside it. Enter `EightBallActivity` in this window. What do you see?

There should now only one be one message displayed - the logging message you created.

There are other options which can be used to filter the logging. Go and read the documentation to find out more.
