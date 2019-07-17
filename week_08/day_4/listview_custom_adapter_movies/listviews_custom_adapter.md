# ListViews with Custom Adapters

## Duration: 2 hours

## Learning Objectives

* Add a ListView control to an app
* Display data from an ArrayList in a list using a custom adapter
* Access individual items in a listview


## MVC in Android Studio and ArrayList Adapters
> Give our starter code and make sure everyone can open it before starting the lesson.

```
Open Android Studio
Open exisiting project
Find the startcode and go inside it and select TopMoviesList folder
(Maybe have to install build tools)

```


> Show a working version of the final result everyone knows exactly what we are aiming for.

We are going to be using a custom adapter, which allows us to have control over how the each list item is formatted. Here we see how movies has three properties (ranking, title and year) and we can control how they are laid out.

So previously we have now seen how an Activity translates data from our Models to our Views. But let's say our model returns our data in the form of an ArrayList (an ArrayList of movies objects), and we want the elements of the ArrayList to be displayed as a list. 

To do this we need an adapter. An adapter is an object that provides views for a list view. In this case we will be using an ArrayList adapter.

> Draw a diagram of the relationship between these elements and refer back to it throughout the lesson. (See `custom_adapters.png`)

So if we look at our starter code we can see we have got out tested Models. Our TopMovies class will give us our ArrayList of the top 20 movies using the getList() method. This is the ArrayList that we want to display as a list.

## Creating the Layouts

### List Layout

We are going to create an activity for our list and that will automatically generate our layout file.

Create TopMoviesActivity

```
Right click App
New > Activity > EmptyActivity

Acitivity Name: TopMoviesActivity
Layout Name: movies_list
CHECK launcher activity

```

We should now have our layout file for our list to populate:

```
res > layout > movies_list.xml
```


So this is going to be the view for the whole list. Previously we have used an EditText and TextView, but today we will use a ListView to contain all the list items built by the adapter. Like we did yesterday we can just drag and drop this view into our design view, this time `ListView` is under `Containers`. 

We want to make sure:

1. both `layout_width` and `layout_height` are set to `wrap_content` 
2. It has an id of `list`

### List Item Layout

Now we need to make a view for each individual list element. This is the view that our Adapter is going to use to build each list item.

```
Right click Res > Layout
New > Layout resource file
file name: movies_item
root element: android.support.constraint.ConstraintLayout

```

We are going to drag and drop three text views and change some of their properties. 

1. To display the movie's rank on the left. This will:
 - have a width and height of 70dp
 - be constrained to the <b>top and left hand side of the layout</b>
 - have an id of `ranking`
 - have a textSize of 36
 - have a color (click the three dots next to `text color > color`
2. To display the movie's title on the right. This will:
 - be constrained to the <b>right of the ranking text view</b>
 - width: wrap content
 - have an id of `title`
 - have a text size of 20.
3. To display the year on the right. This will:
 - be constrained to the <b>right of the ranking text view</b> and the <b>bottom of the title text view</b>
 - width: wrap content
 - have an id of `year`
 - have a text size of 14.

```xml
// movie_item

<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent" android:layout_height="match_parent">

    <TextView
        android:id="@+id/ranking"
        android:layout_width="76dp"
        android:layout_height="70dp"
        android:text="TextView"
        android:textColor="@color/colorAccent"
        android:textSize="36sp"
        tools:layout_editor_absoluteY="16dp"
        android:layout_marginLeft="8dp"
        app:layout_constraintLeft_toLeftOf="parent" />

    <TextView
        android:id="@+id/title"
        android:layout_width="wrap_content"
        android:layout_height="20dp"
        android:text="TextView"
        android:textSize="18sp"
        tools:layout_editor_absoluteY="16dp"
        app:layout_constraintLeft_toRightOf="@+id/ranking"
        android:layout_marginLeft="8dp" />

    <TextView
        android:id="@+id/year"
        android:layout_width="wrap_content"
        android:layout_height="30dp"
        android:text="TextView"
        app:layout_constraintLeft_toRightOf="@+id/ranking"
        android:layout_marginLeft="8dp"
        android:layout_marginTop="8dp"
        app:layout_constraintTop_toBottomOf="@+id/title" />
</android.support.constraint.ConstraintLayout>

```


## Creating the Activity


Let's write our TopMoviesActivity. It's job is going to be to get our ArrayList of movies and pass it onto our adapter, for the adapter to do its thing and build those list items.

> Refer to the diagram on board

In the ```onCreate```, the content view has been set to movies_list view, because that's what we specififed when we created it. This is the "wrapper" for the list.

```java
//TopMoviesActivity

public class TopMoviesActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.movies_list);
    }
}

```

It's then going to new up an instance of TopMovies and call the getList() method.

```java
//TopMoviesActivity

public class TopMoviesActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.movies_list); 

            TopMovies topMovies = new TopMovies(); //UPDATED
            ArrayList<Movie> list = topMovies.getList(); //UPDATED
    }
}

```

Then we are going to create a new TopMoviesAdapter, which we havn't written yet, but when we have it is going to take two arguments - this activity's context and the ArrayList of movies.

```java
//TopMoviesActivity

public class TopMoviesActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.movies_list); 

            TopMovies topMovies = new TopMovies();
            ArrayList<Movie> list = topMovies.getList();

            TopMoviesAdapter movieAdapter = new TopMoviesAdapter(this, list); //UPDATED
    }
}

```

We need to give the adapter this TopMoviesActivity's content, because so it knows about the list layout it is going to populate with it's list items.

Ok, let's go back create our adapter...

## Adapters

So now that we have created our ListView, we need an adapter that pulls content from a data source such as an array or database query and converts each item into a view (in our case, the `movies_item` view, which is then placed into to the list.

Android provides us with several subclasses of the ```Adapter``` class depending on the type of data being retrieved. As our data source is an ````ArrayList``` of strings then we will use the ```ArrayAdapter``` subclass.

Now we make our adapter:

```
Right click Java > <Our Package>  > New > Java Class
Name: TopMoviesAdapter
```


```java
// TopMoviesAdapter

import java.util.ArrayList;

public class TopMoviesAdapter extends ArrayAdapter<Movie> {

    public TopMoviesAdapter(Context context, ArrayList<Movie> movies) {
        super(context, 0, movies);
    }

}

```

In our constructor we call super to call the ```ArrayAdapter``` constructor takes three arguments:

* the context (TopMoviesActivity)
* a resource int, which we are going to pass as 0, because we are not wanting to use a default resource. 
* the data to be displayed. In our case this is the ```ArrayList``` of Movie objects returned by the call to ```getList()```.


## Creating the list item view

ArrayAdapter class has getView() method that is responsible for creating the views. It is a method that Android Studio calls, and it returns the populated list item views.

We are going to Override the ArrayAdapters ```getView()``` method. This is where we are going to build each list item, setting the text for each of our TextViews that we defined earlier with the movie's rank, title and year.

```getView()``` takes in thee arguments:

* position (this is what is uses to loop through the array and create each list item)
* listItemView is the old view that we can use to recycle
* parent is the parent listview that this view will be attatched to
> https://developer.android.com/reference/android/widget/ArrayAdapter.html#getView(int, android.view.View, android.view.ViewGroup)

```java
// TopMoviesAdapter

@Override
public View getView(int position, View listItemView, ViewGroup parent) {

}
```

Now we are going to add a few lines of code that helps save on memory. The Adapter builds enough list items to fill the height of the screen. Then it will not create any more rows in memory. Instead, as the user scrolls, list items the move off the top of the screen are kept in memory and can be used for the new list items that appear at the bottom. This means we only ever have to create a small numbers of rows, even if we have huge number of movies. 

> Explanation: https://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView


```java
// TopMoviesAdapter

@Override
public View getView(int position, View listItemView, ViewGroup parent) {

    // UPDATED Check if the existing view is being reused, otherwise inflate the view
    if (listItemView == null) {
        listItemView = LayoutInflater.from(getContext()).inflate(R.layout.movies_item, parent, false);
    } 

}

```

Before the initial list items have been created, listItemView is null, so it is inflated.

Lastly we are going to tell the adapter how to translate the data into the views.

```java
// TopMoviesAdapter

@Override
public View getView(int position, View listItemView, ViewGroup parent) {

    //Check if the existing view is being reused, otherwise inflate the view
    if (listItemView == null) {
        listItemView = LayoutInflater.from(getContext()).inflate(R.layout.movie_item, parent, false);
    }
    
    Movie currentMovie = getItem(position);

    TextView ranking = (TextView) listItemView.findViewById(R.id.ranking);
    ranking.setText(currentMovie.getRanking().toString());

    return listItemView;
}



```

## TASK
Do the same as we have just done for movie ranking, for title and year.

```java
// TopMoviesAdapter

@Override
public View getView(int position, View listItemView, ViewGroup parent) {

    //Check if the existing view is being reused, otherwise inflate the view
    if (listItemView == null) {
        listItemView = LayoutInflater.from(getContext()).inflate(R.layout.movies_item, parent, false);
    }
    
    Movie currentMovie = getItem(position);

    TextView ranking = (TextView) listItemView.findViewById(R.id.ranking);
    ranking.setText(currentMovie.getRanking().toString());

    TextView title = (TextView) listItemView.findViewById(R.id.title); //UPDATED
    title.setText(currentMovie.getTitle()); 

    TextView year = (TextView) listItemView.findViewById(R.id.year); //UPDATED
    year.setText(currentMovie.getYear().toString());

    return listItemView;
}



```


## Calling the adapter in our Activity

Last thing, in our activity we need to call the setAdapter() method on our view.

We are going to get hold of our movies_list ListView and call the ```setAdapter()``` method in it, passing in the adapter that we just created. This ```setAdapter()``` method is what tells the Adapter to do it's thing (which includes ```getView()```) to build those list items and populate the list. 

```java
//TopMoviesActivity

public class TopMoviesActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.movies_list);

        TopMovies topMovies = new TopMovies();
        ArrayList<Movie> list = topMovies.getList();

        TopMoviesAdapter movieAdapter = new TopMoviesAdapter(this, list);

        ListView listView = (ListView) findViewById(R.id.list); //UPDATED
        listView.setAdapter(movieAdapter);  //UPDATED
    }
}

```


So, that should all work. Let's run it and see...

Don't forget default acitivity in manifest

```
<activity android:name=".TopMoviesActivity">
   <intent-filter>
       <action android:name="android.intent.action.MAIN" />

       <category android:name="android.intent.category.LAUNCHER" />
   </intent-filter>
 </activity>
```




## Add an onclick

Nice! Let's say we want to be able to click on one of the rows to display more info about the movie, we need to add an ```onClick```. 

Because we want to make our whole row clickable we will add out onlick to our top-level LinearLayout:

```xml
//movie_item.xml

<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:onClick="getMovie">   // UPDATED    
    
```

We want to be able to pass the WHOLE Movie object through to another activity. setTag() allows us to attach an object to a view. We are going to set the object as a tag on the list item in the ArrayAdapter.

```java
// TopMoviesAdapter

    TextView year = (TextView) listItemView.findViewById(R.id.year); 
    year.setText(currentMovie.getYear().toString());

    listItemView.setTag(currentMovie); //UPDATED

    return listItemView;
}

```

And then we can use the ```getTag()``` method to retreive it. We will check it by logging out the title:

```java 
//TopMoviesActivity

public void getMovie(View listItem) {
        Movie movie = (Movie) listItem.getTag();
        Log.d("Movie Title: ", movie.getTitle());
    }

```

You could now use this to create an intent that takes you to more details about the individual film
