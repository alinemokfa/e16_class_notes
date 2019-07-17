import React from 'react'

var ShowTimesButton = function(props){

    return(
      <div className='show-times'>
        <button className='btn-show-times' onClick={props.handleClick}>Get Show Times >></button>
      </div>
    )
}

module.exports = ShowTimesButton
