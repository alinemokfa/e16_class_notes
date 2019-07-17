import React from 'react';

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

export default CountryDetail;
