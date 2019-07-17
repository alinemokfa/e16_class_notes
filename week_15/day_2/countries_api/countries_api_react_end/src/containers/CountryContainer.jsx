import React from 'react';
import CountrySelector from '../components/CountrySelector';
import CountryDetail from '../components/CountryDetail';

class CountryContainer extends React.Component {
  constructor(props){
    super(props);
    this.state = {
      countries: [],
      focusCountry: null
    };
  }

  componentDidMount(){
    var url = 'https://restcountries.eu/rest/v2/all';
    var request = new XMLHttpRequest();
    request.open('GET', url);

    request.onload = function() {
      if (request.status === 200) {
        var jsonString = request.responseText;
        var data = JSON.parse(jsonString);
        this.setState({ countries: data, focusCountry:data[0] });
      }
    }.bind(this);

    request.send();
  }

  setFocusCountry(country){
    this.setState({ focusCountry: country });
  }

  render(){
    return (
      <div>
        <h2>Country Container</h2>
        <CountrySelector countries={this.state.countries} selectCountry={this.setFocusCountry.bind(this)} />
        <CountryDetail country={this.state.focusCountry} />
      </div>
    );
  }
}

export default CountryContainer;
