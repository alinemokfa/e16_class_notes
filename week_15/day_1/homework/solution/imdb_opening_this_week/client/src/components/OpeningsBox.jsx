import React from 'react'
import Header from './Header'
import MovieTable from './MovieTable'
import MoreLink from './MoreLink'
import ShowTimesButton from './ShowTimesButton'

class OpeningsBox extends React.Component {

  handleClick(){
    console.log("handling click")
  }

  render(){
    return(
      <div className='openings-box'>
        <Header title="UK Opening This Week"/>
        <MovieTable movies={this.props.movies}/>
        <MoreLink />
        <ShowTimesButton handleClick={this.handleClick}/>
      </div>
    )
  }
}

module.exports = OpeningsBox
