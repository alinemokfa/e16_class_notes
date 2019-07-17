# Creating a Menu

## Learning Outcomes

* Add a menu to the toolbar in an Android App
* Display a toast when a menu item is selected

## Menu Definition

So if you've used Android (or iOS apps) you've probably used menus in the apps title bar. So we're now going to have a look at adding a simple menu to the title bar in our app.

### Create a layout file
So, thinking about our menu. What will we need to display it?
We'll need to create a layout file, but where will it go. A layout is a resource (if you remember from the layouts we've created earlier) so it will go somehere in the ```res``` directory. But, in Android Studio, layouts for menus don't go into the ```res/layouts``` directory but into a ```menu``` directory in the ```res``` directory.

At the moment, we don't have a ```res/menu``` directory so we need to create one.

[i]: see if anyone can remember how to add a file/directory to the ```res``` folder.

Got to the `Project` window in Android Studio
Right(two-finger)-click on the ```res``` directory and select ```New -> Directory```
Type 'menu' for the new directory name and click 'OK'. The new directory should now be there.

So we now need to create a layout (xml file) for what we want to display in the menu. We do that in the ```res/menu``` directory.

Got to the `Project` window in Android Studio
Right(two-finger)-click on the ```res/menu``` directory and select ```New -> Menu resource file```

Type 'activity_main' for the new file name and click 'OK'. This should create an ```activity_main.xml``` file in the ```res/menu``` directory. If you open this file it should look something like:

```
<!-- res/menu/activity_main.xml -->

<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">

</menu>
```

### Add a menu item to the menu

At the moment, our menu is empty, so we need to add something to it. So what kind of item do we want to add to it? A TextView? An ImageView. Well Android has a type of view called a ```MenuItem``` which we declare in our xml file as an ```Item``` within our ```menu``` view.

So let's add a new item to the menu with the text we want to display. We'll give it an id of ```action_hello```. For the title we'll use a string resource called `say_hello`

```
<!-- res/menu/activity_main.xml -->

<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:id="@+id/action_hello"
        android:title="@string/say_hello"/>
</menu>
```

So what are we missing? We need to add a new item to our ```res/value/string.xml``` file.

Open the ```res/value/string.xml``` file and add

```
<!-- res/value/string.xml -->

<string name="say_hello">Hello!</string>
```

If we were to run the app now then we still wouldn't see the menu.

### Displaying the menu

So we need to write code to display our menu. So how/where do we do this? Well, we want to display this menu in (at least) one of our screens, i.e. in an Activity. Now, the Activity class has a method to create an options menu when the object is created, similar to ```onCreate```.  This method is called ```onCreateOptionsMenu```.

So, like with ```onCreate``` we need to override this function in the class for the Activity we want to show the menu, in our case, MainActivity. This method takes in a ```Menu``` view parameter.

```
//MainActivity.java

@Override
public boolean onCreateOptionsMenu(Menu menu) {

}
```

So in this method we now need to ```inflate``` the xml view of the menu into a version we can use in our code. First of all we need to call the ```getMenuInflater``` method of the Activity class so that we can get a ```MenuInflater``` object. Now ```MenuInflater``` is what we use to instantiate Menu XML files into ```Menu``` objects. Once we get the ```MenuInflater``` object we can call the ```inflate``` method to add the items in a Menu XML files into a ```Menu``` object. The ```inflate``` method takes two paramaters, the id of the resource (in our case ```R.menu.activity_main```) and the ```Menu``` object to inflate into.

```
    MenuInflater menuInflater = getMenuInflater();
    menuInflater.inflate(R.menu.activity_main, menu);
```

Note: We need to return true to tell Android we have provided the menu.

```
//MainActivity.java

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater menuInflater = getMenuInflater();
    menuInflater.inflate(R.menu.activity_main, menu);
    return true;
}
```


When we deploy this we can see the menu and click on 'Say Hello!' but nothing happens. We now need to add an event to do something when we click on the menu item.

### Listening for Events

When you select an item from the options menu the system calls the activity's ```onOptionsItemSelected()``` method. This method passes the MenuItem selected. So like with other activity method we need to override this one as well:

```
//MainActivity.java

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

    }

```

We can identify the selected item by calling ```getItemId```, which returns the unique ID for the chosen menu item (defined by the android:id attribute in the menu resource).

Once you get the id for the selected menu item you can then match the ID against known menu items to perform the appropriate action.

```
//MainActivity.java

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_hello) {
            // TODO: do something
            return true;
        }
    }

```

When you successfully handle a menu item, return true. If you don't handle the menu item, you need to call the superclass implementation of ```onOptionsItemSelected```.

```
return super.onOptionsItemSelected(item);
```

This default implementation returns false.

```
//MainActivity.java

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_hello) {
            // TODO: do something
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

```

So we need to think of something to do when we click on a menu item?

Well, let's just display a message saying "Hello", but where would we do this? We haven't a TextView on our page so what do we do?

### Toasts

Android has a feature called a *toast*, which is just a pop-up message. In Android a *toast* contains a short message that informs the user of something but does not need any input or action.

So let's make a toast which appears when you click an item in your menu

The message we're going to display is going to come from a string resource, so we need to add an entry in our strings.xml file for what we want to display. We want to display a simple "Hello!!!" so let's create an entry called 'menu_hello_toast' with our message

```
<!-- res/values/strings.xml -->

<string name="menu_toast_hello">Hello</string>

```

To create a toast, we call the ```makeText``` method from the ```Toast``` class:

```
public static Toast makeText(Context context, int resId, int duration)
```

So this method takes three paramaters:

*```Context context``` - our old friend the context. In our case we pass in our Activity, which is MainActivity so we pass in ```MainActivity.this```

*```int resId``` - this is the resource id of the string that the toast should display. In our example this is our ```menu_toast_hello``` resource so the id will be ```R.string.menu_toast_hello```

*```int duration``` -  this is one of two ```Toast``` constants that specify how long the toast should appear for. The two constants are ```LENGTH_SHORT``` and ```LENGTH_LONG```. We will use ```LENGTH_SHORT```

So our call to ```makeText``` will be

```
//MainActivity.java

Toast.makeText(MainActivity.this, R.string.menu_toast_hello,
        Toast.LENGTH_SHORT);
```

So now we've created a toast, we need to get it onto the screen. To do this we call ```Toast.show()```. We can chain this to the call to ```makeText```

```
//MainActivity.java

Toast.makeText(MainActivity.this, R.string.menu_toast_hello,
        Toast.LENGTH_SHORT).show();
```

So we've now completed our ```onOptionsItemSelected``` method

```
//MainActivity.java

@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_hello) {
            Toast.makeText(MainActivity.this, R.string.menu_toast_hello,
                    Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
```

Run the app and click on the menu item. You should get a toast pop-up which says "Hello"

## Task

Add another menu item to pop up a toast with a different message
