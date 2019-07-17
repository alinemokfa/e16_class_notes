# Adding Controls

## Learning Objectives

* Know how to add controls to an activity
* Understand how to interact with controls in code
* Be able to use controls to build an interactive activity

## Adding Controls

So far we've just created a basic, empty app for our EightBall, which isn't useful at all just now. It's now time to turn it into something more 'useful'.

## Requirements

So what will need to implement our App?
[i]: ask the class for ideas

Basically we will need:

* some way of entering our question
* something to 'shake' to get the answer
* a way of displaying the answer

[i]: perhaps draw a diagram on the board of how our app will look

## Components

In HTML, we could build up our page using divs, inputs, spans, p tags etc. In Android, we have a set of container can use in a similar fashion to build up our screens.

For example.

* TextView displays a piece of text
* Button is a button...
* Checkbox is a checkbox...

Check out the docs to see all the options.

You can see they all have fairly sensible names and provide similar functionality like we have seen in HTML. We just have to get used to how we implement this in Android.

Let's add a EditTextView to our main view (activity_main.xml) so that we can enter a question in our eight-ball app.

Just like in html, we need to use tags to create components.

## Intro to Constraint Layouts 

This is going to be our first experience using Android's Design View interface and using Constraints to get our app to look the way we want.

> SHOW CLASS: Here's a short 5 minute video that explains how to use the Design View and how to apply and use constraints https://www.youtube.com/watch?v=XamMbnzI5vE

The first thing we need to do is tell our android studio that we want to use Constraint Layouts. We can do this by going to `Gradle Scripts/build.gradle(Module:app)` and checking that this line `    compile 'com.android.support.constraint:constraint-layout:1.0.2'
` is at the bottom of the file. If it's not we need to add it and re-sync the project (Android studio should give us a message to go and do this at the top of the page. It may also ask us to install the package in which case do that as well).


## Adding an EditText control

The first control (or widget) that we are going to add is called an `Plain Text` control. This is a control which allows us to use the keyboard to type text onto the screen - like a textbox in HTML.

To add this control, open the res/layout/activity_main.xml file and it'll open with the Design View which can be used to design the layout of our app by adding controls.

You can see by default we already have a TextView with "Hello World" inside it but we are just going to remove this to start with.

We are now going to go ahead and add our `Plain Text` control. If you look down the left handside of the Design View you can see a section called Palette which has all the possible controls we can add. It's broken in two parts a filter on the left and the actual elements on the right.

We can filter our controls by clicking on `Text` and the view we are going to use is `Plain Text` (this used to be called `EditText`). Now we can simply drag and drop this view to where we want it on our page. 

> Show how to use constraints here or you can do it at the end. Just a case of centring it using the little handles and you might want to set one to the top of the page as well.

Finally we want to add a couple of properties to our control which we can do using the panel on the right, conveniently called properties. The first thing we are going to do is remove the "Name" that comes as default by just going to the `text` property and leaving it blank. 

Then we want to add a `hint` but first we will add a string value by going to our `res/values/strings.xml`.

```xml
<!-- strings.xml -->

    <string name="question">Ask a question</string>
```
Now if we go back to our layout, in the properties we can see a `hint` field and we can set the value of this to `@string/question` (this should start to autocomplete once we type @string). 

Lastly we want to add an `id` property to our element so that we can get hold of it in our activity. To do this we need to scroll to the bottom of the properties table and we click on the 'View all Properties' link. Then we get the list of all the possible properties that can be set on this control. The one we are interested in is `id` at the top which has already been giving a default value but we are going to change this to 'question_text'.

> You might want to show the students the 'Text' tab to show them all the properties Android has set for us. You might want to also point out what the + in the `android:id` is doing.

> Do you notice that there is a '+' sign in the values for ```android:id``` but not in the values for ```android:text```?  This tells Android that you are creating a new ID for that control, whereas we are simply referencing an already existing piece of text.

> The "dp" in the width and margin attributes is short for "density-independent pixel" and basically means that regardless of the screen density of a device, the size should be the same.

Now run the app in the emulator and you should see a text entry control. You should be able to type some text (using your computer keyboard), but that's about it.

### Adding a button

We need some way of submitting the text we have just entered. To help us do that we are going to add a button to our activity.

To add a button, we can just follow the same pattern as last time expect we go into the `Widgets` category in the palette.

The properties we are going to set this time are
	- Text to be `@string/shake` (remember and create the resource first )
	- id to be `shake_button`

```xml
<!-- strings.xml -->

<string name="shake">Shake the ball</string>
```

Now try running your app. Hopefully, you should see a 'SHAKE THE BALL' button underneath the text entry control. Obviously it won't do anything yet because we haven't written any code. But it's a start!

## Answer Text

Let's add a text view to hold the answer from the 8 ball. Again we can go to our palette and `Widgets` to get the `TextView` control. The only thing we need to add now is an id like we have before with the value `answer_text` and to leave the `Text` property blank.

> Remember to add Constraints if you haven't already.


### Wiring up the controls

To make the controls useful, we need to 'wire them up' to our Java code so that we can write the code that determines what happens we click the button.

Since all our controls have IDs we can access them in our MainActivity class. First of all, we need to add member variables for each of the controls.

```java
//EightBallActivity.java

public class MainActivity extends AppCompatActivity {

    EditText questionEditText;
    TextView answerText;
    Button shakeButton;

   //etc.
 }

```

If you get errors then it's probably because the required classes have not been imported. If anything appears in red then you can, as before, highlight the word and press 'alt' + 'enter' and select 'Import class'. Your imports should now include the following three lines:

```java
//EightBallActivity.java
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
```

We now need to match the local variables we created to the controls in our activity_main.xml. We can get the reference to a control by calling the following method from the ```Activity``` class:

```java
//EightBallActivity.java
public View findViewById(int id)
```

This method takes a resource ID and returns a view object. In our MainActivity class, we can use the resource IDs of the controls to get the objects and assign them to the member variables we created. So lets do this in our MainActivity class.

In the ```onCreate``` method in MainActivity.java (***AFTER*** the call to ```setContentView()```) , add the following code:

```java
//EightBallActivity.java

questionEditText = (EditText)findViewById(R.id.question_text);
answerText = (TextView)findViewById(R.id.answer_text);
shakeButton = (Button)findViewById(R.id.shake_button);
```

Note that in each case you need to cast the view returned by ```findViewById``` to the type of the control e.g. for shakeButton you need to cast the view returned to ```Button```.

### Responding to button clicks

So how do we get our button click to actually  do something useful?

Android apps are generally event driven which means that they start and then wait for an event to happen, for example, the user pressing a button. When your app is waiting for a particular event to happen we say that it is 'listening for' that event.

[i]: This isn't too different to Sinatra, where our Controller responded to various events (e.g. a form submission).

In our app, the even we want to listen out for is for a button being pressed (or 'clicked'), so we need something which looks for that event.

Let's start by writing a method which will be called when the button is clicked.

```java
// EightBallActivity.java
public void onShakeButtonClicked(View button) {
  Log.d(getClass().toString(), "onShakeButtonClicked was called");
}
```

Here we just print some information to the console when the method is called. We've passed in a `View` here, for *reasons*, which will become clearer later.

Now the only thing remaining is to make sure this gets called. For this, we head back to our `activity_main.xml` file. Inside the `View all Properties` section if we scroll down we will find a property call `OnClick`. We are going to set this equal to the method ('onShakeButtonClicked') we just wrote inside our `main_activity`.

This means Android will go looking for a method with the signature `void onShakeButtonClicked(View button)`. This is why we had to pass in the `View` in our Activity - it's what Android expects the method to look like.

### Getting the text in the text edit field

Although in our 8-ball app we're not really bothered at the moment as to what the user enters, there may/will be cases where we do want to get the text entered. So let's get the log to output what the user has entered when they click the 'Shake' button.

To get the text entered in the editText control we call the (unsurprisingly named) ```getText()``` method. i.e. to get the text for our control we could write:

```java
//EightBallActivity.java in onShakeButtonClicked
String question = questionEditText.getText().toString();
```

NOTE - we need to call the ```toString()``` method because ```getText()``` does not return a string, but an object of type ```Editable```.

So we can log the text entered with something like:

```java
//EightBallActivity.java
Log.d(getClass().toString(), "The question asked was '" + question + "'");
```

So the listener should now look something like:
```java
//EightBallActivity.java
public void onShakeButtonClicked(View button) {
  String question = questionEditText.getText().toString();
  Log.d(getClass().toString(), "onShakeButtonClicked was called");
  Log.d(getClass().toString(), "The question asked was '" + question + "'");
}
```

### Changing the text field text

Now that we have button click working we can now add code to change the text of of our text field to something.

To set the text for the textview control we do the opposite from what we did for the EditText control, i.e.

```java
//EightBallActivity.java
answerText.setText("string");
```

We want to get the answer. At the moment, we'll just answer with "Naw ye dinnae!"

```java
answerText.setText("Naw ye dinnae!");
```

Add this code to the ```onShakeButtonClicked``` implementation and run the app. Try adding some text and clicking submit. What happens?

## Task (5-10 mins)

At the moment, we only have one possible answer. Your task is to get the app to display a random answer using the model we set up yesterday..

A possible approach may be as follows:

* create an instance of ```Answers``` within the button click event listener
* call the ```getAnswer()``` method

Possible solution:

```java
//EightBallActivity.java
public void onShakeButtonClicked(View button) {
  String question = questionEditText.getText().toString();
  Log.d(getClass().toString(), "onShakeButtonClicked was called");
  Log.d(getClass().toString(), "The question asked was '" + question + "'");
  Answers answers = new Answers();
  String answer = answers.getAnswer();
  answerText.setText(answer);
}
```
