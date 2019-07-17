import React from 'react'
import MovieRow from './MovieRow'

var MovieTable = function (props){

  var movieNodes = props.movies.map(function(movie, index) {
    return (
      <li key={index}>
        <MovieRow movie={movie} key={index}/>
      </li>
    )
  })

  return(
    <div className='movie-table'>
      <ul>
        {movieNodes}
      </ul>
    </div>
  )
}

module.exports = MovieTable
