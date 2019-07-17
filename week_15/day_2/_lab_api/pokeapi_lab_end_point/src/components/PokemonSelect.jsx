import React from 'react';

const PokemonSelect = (props) => {
  const options = props.pokemonList.map(pokemon => {
    return (
      <option value={pokemon.id} key={pokemon.id}>
        {pokemon.name}
      </option>
    )
  });

  return (
    <div className='pokemon-select'>
      <label>Pokemon: </label>
      <select
      value={props.selectedPokemon}
      onChange={props.handlePokemonSelected}
      >
        { options }
      </select>
    </div>
  );
};

export default PokemonSelect;
