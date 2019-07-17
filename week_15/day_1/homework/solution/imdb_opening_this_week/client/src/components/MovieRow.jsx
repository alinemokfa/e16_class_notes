import React from 'react'

var MovieRow = function(props){
  return (
    <div className='movie-row'>
      <a href={props.movie.url}>{props.movie.name}</a>
    </div>
  )
}

module.exports = MovieRow;
