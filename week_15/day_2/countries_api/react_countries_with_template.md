# React Country

## Learning Objectives
- Rewrite existing application using React
- Make HTTP requests in React - considering async issues
- More practice of passing around data

## Intro
You all wrote awesome applications using the countries REST API.  Today we are going to re-write this application using React.

> show example of what we are going to make.

## Design
Let's think about which components we might need to make this, and what state and props each would need to have.

> Discuss design and get to a structure that looks something this.
> This whole class we want it to be (or at least feel) like it is them who are creating it.

- CountryContainer: state: countries, currentCountry
- CountrySelect: state: selectedIndex,  props - countries, handleChange
- CountryDetail: props - country

## Implementation

> Hand out countries_template start point and get students to look at code for 5mins to see what components etc have been set up, see what's loading at localhost at this point.

Let's look at our countries Container that will be our main parent component. This should control the state of our application.  Let's set up the initial state of the Container so that it has an empty list of countries and a focus country which will start as null.

```js
  // ./containers/CountryContainer.jsx
  constructor(props){
    super(props);
    this.state = { // CHANGED
      countries: [],
      focusCountry: null
    };
  }
```

We have loaded this in our app.js and asked React to render it.

Go to React Dev tools in the console to show the state of the components.

# Getting Countries from API

We're going to use another of the lifecycle methods to do our AJAX call to the API, componentDidMount. This method will be triggered when the component has successfully been rendered into the DOM. The React documentation recommends that this is the right place to do AJAX requests.

[Task]: Make a request to the Rest Countries API and pass them to the component's state when loaded.

[SOLUTION]:

```js
  // ./containers/CountryContainer.jsx

  componentDidMount() {
    const url = 'https://restcountries.eu/rest/v2/all';
    const request = new XMLHttpRequest();
    request.open('GET', url);

    request.onload = () => {
      if (request.status === 200) {
        const jsonString = request.responseText;
        const data = JSON.parse(jsonString);
        this.setState({ countries: data });
      }
    }

    request.send();
  }
```

Again we can check dev tools and see that the state has changed!

## Creating a select
Now we can start adding to our other components. Let's have a look at our countries select dropdown - currently there is no information in it.

Inspect with our react tools and we can see that we don't have any properties on our selector.  What properties would we like this to have? The list of countries we just stored in our state. Let's set that as a prop on it.

```js
// ./containers/CountryContainer.jsx

render(){
  return(
    <div>
      <h2>Country Container</h2>
      <CountrySelector countries={this.state.countries}></CountrySelector>
      <CountryDetail />
    </div>
  );
}
```

Selector has all it needs, let's now set it up so that it can select a country.

[Task]: How might we add the options into the select?

```js
// ./components/CountrySelector.jsx

render() {
     const options = this.props.countries.map((country, index) => {
     	return <option value={index} key={index}>{country.name}</option>;
    });

    return (
      <select id="countries">
        { options }
      </select>
    );
}
```

We want the select to keep tabs on its own state. And change when it is clicked. Let's first set the initial state.

```js
// ./components/CountrySelector.jsx

constructor(props){
  super(props);

  this.state = {
    selectedIndex: undefined
  };
}
```

```js
// ./components/CountrySelector.jsx

render:
...
return (
  <select id="countries" value={ this.state.selectedIndex }>
    {options}
  </select>
 );
```

 Let's listen to when the select has changed...


```js
// ./components/CountrySelector.jsx

render method:
  ...
 return(
  <select id="countries" value={this.state.selectedIndex} onChange={ this.handleChange.bind(this) }>
    {options}
  </select>
 )
```

And now let's handle it and update the state of this component  

```js
  // ./components/CountrySelector.jsx

  handleChange(e){
    this.setState({ selectedIndex: e.target.value })
  }
```

Now that we have updated the state of the the selector component we now want to update the state of the currentCountry on the CountryContainer.  How can we do this?

Callbacks!

## Updating the selected country
Let's create a method on the Country Container that will set the country that we want to focus on.

We can call this anything we want.  And then let's pass this method to the countries selector.


```js
// ./containers/CountryContainer.jsx
setFocusCountry(country){
  this.setState({ focusCountry: country });
}

render(){
  return (
    <div>
      <h2>Country Container</h2>
      { /* Changed! */ }
      <CountrySelector countries={this.state.countries} selectCountry={this.setFocusCountry.bind(this)} />
      <CountryDetail />
    </div>
  );
}
```

Now we can tell the country selector to call this method when it has selected a country.

```js
// ./components/CountrySelector.jsx
handleChange(event){
  var newIndex = event.target.value;
  this.setState({selectedIndex: newIndex});

  const selectedCountry = this.props.countries[newIndex];
  this.props.selectCountry(selectedCountry);
}
```

We can now use the React tools to check that it is updating.  Great.

Let's go over what happened here.

## Country Detailed Display
Now that we have a selector that is updating the selected country, the final piece in the puzzle is our detailed display.

We now want to give the CountryDetail some properties, as currently it has nothing. What do we want to pass? Yes the country.

```js
// ./containers/CountryContainer.jsx

<CountryDetail country={ this.state.focusCountry } />
```

We can use this in our countryDetail component. We put in a guard so that before the request returns the countries data it will just return and say nothing is selected.

```js
// ./components/CountryDetail.jsx

class CountryDetail extends React.Component {
  render(){
    if(!this.props.country){
      return null;
    }
    return (
      <h3>{this.props.country.name}</h3>
    );
  }
}
```

Notice that it is not updating when the countries first load.

Let's fix this - when we make the request we'll set the first country to be automatically displaying.

> can make this a quick 5 min task or ask the class how to fix it

```js
// ./containers/CountryContainer.jsx

  componentDidMount() {
    const url = 'https://restcountries.eu/rest/v2/all';
    const request = new XMLHttpRequest();
    request.open('GET', url);

    request.onload = () => {
      if (request.status === 200) {
        const jsonString = request.responseText;
        const data = JSON.parse(jsonString);
        this.setState({ countries: data,  focusCountry:data[0] });
      }
    }

    request.send();
  }
```

Task:
- Add more information about each country in the CountryDisplay
