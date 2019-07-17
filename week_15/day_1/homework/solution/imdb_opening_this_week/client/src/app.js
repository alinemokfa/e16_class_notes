// var React = require('react')
// var ReactDOM = require('react-dom')
// var OpeningsBox = require('./components/OpeningsBox')

import React from 'react'
import ReactDOM from 'react-dom'
import OpeningsBox from './components/OpeningsBox'

var movies = [
  {name: "Sausage Party", url:"http://www.imdb.com/title/tt1700841?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=1970868962&pf_rd_r=10B79GWTXE5MERRSR82F&pf_rd_s=right-2&pf_rd_t=15061&pf_rd_i=homepage&ref_=hm_otw_t0", showTimesURL: "http://www.imdb.com/showtimes/title/tt1700841?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=1970868962&pf_rd_r=10B79GWTXE5MERRSR82F&pf_rd_s=right-2&pf_rd_t=15061&pf_rd_i=homepage&ref_=hm_otw_gs"},
  {name: "Café Society", url:"http://www.imdb.com/title/tt4513674?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=1970868962&pf_rd_r=10B79GWTXE5MERRSR82F&pf_rd_s=right-2&pf_rd_t=15061&pf_rd_i=homepage&ref_=hm_otw_t1", showTimesURL: "http://www.imdb.com/showtimes/title/tt4513674?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=1970868962&pf_rd_r=10B79GWTXE5MERRSR82F&pf_rd_s=right-2&pf_rd_t=15061&pf_rd_i=homepage&ref_=hm_otw_gs"},
  {name: "Sausage Party", url:"http://www.imdb.com/title/tt1700841?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=1970868962&pf_rd_r=10B79GWTXE5MERRSR82F&pf_rd_s=right-2&pf_rd_t=15061&pf_rd_i=homepage&ref_=hm_otw_t0", showTimesURL: "http://www.imdb.com/showtimes/title/tt1700841?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=1970868962&pf_rd_r=10B79GWTXE5MERRSR82F&pf_rd_s=right-2&pf_rd_t=15061&pf_rd_i=homepage&ref_=hm_otw_gs"},
  {name: "Café Society", url:"http://www.imdb.com/title/tt4513674?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=1970868962&pf_rd_r=10B79GWTXE5MERRSR82F&pf_rd_s=right-2&pf_rd_t=15061&pf_rd_i=homepage&ref_=hm_otw_t1", showTimesURL: "http://www.imdb.com/showtimes/title/tt4513674?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=1970868962&pf_rd_r=10B79GWTXE5MERRSR82F&pf_rd_s=right-2&pf_rd_t=15061&pf_rd_i=homepage&ref_=hm_otw_gs"}
]

window.onload = function(){
  ReactDOM.render(
    <OpeningsBox  movies={movies}/>,
    document.getElementById('app')
  )
}
