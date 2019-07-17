import React from 'react';
import GenerationSelect from '../components/GenerationSelect.jsx';
import PokemonSelect from '../components/PokemonSelect.jsx';
import PokemonDetail from '../components/PokemonDetail.jsx';
import Title from '../components/Title.jsx';

class PokedexContainer extends React.Component {
  constructor(props){
    super(props);

    this.state = {
      generation: 1,
      pokemonId: 25,
      pokemonList: [],
      pokemonDetail: {
        name: 'Pikachu',
        id: 25,
        image: 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png',
        types: ['Electric']
      }
    };

    this.handleGenerationSelected = this.handleGenerationSelected.bind(this);
    this.handlePokemonSelected = this.handlePokemonSelected.bind(this)
  }

  render() {
    return (
      <div className='pokedex-container'>
        <Title text='Pokedex'/>
        <div className='pokedex'>
          <GenerationSelect
            selectedGeneration={this.state.generation}
            generations={Object.keys(this.props.generationOffsets)}
            handleGenerationSelected={this.handleGenerationSelected}
          />
          <PokemonSelect
            selectedPokemon={this.state.pokemonId}
            pokemonList={this.state.pokemonList}
            handlePokemonSelected={this.handlePokemonSelected}
          />
          <PokemonDetail
          pokemon={this.state.pokemonDetail}
          />
        </div>
      </div>
    );
  }

  componentDidMount() {
    if (this.state.generation) {
      this.getPokemonList(this.state.generation);
    }
    if (this.state.pokemonId) {
      this.getPokemonDetail(this.state.pokemonId);
    }
  }

  handlePokemonSelected(event) {
    const pokemonId = parseInt(event.target.value, 10);
    this.setState({pokemonId: pokemonId});
    this.getPokemonDetail(pokemonId);
  }

  handleGenerationSelected(event) {
    const generation = parseInt(event.target.value, 10);
    this.setState({generation: generation})
    this.getPokemonList(generation);
  }

  capitalize(string) {
    const firstCharacter = string.slice(0, 1).toUpperCase();
    const restOfString = string.slice(1).toLowerCase();
    return firstCharacter + restOfString;
  }

  getPokemonDetail(pokemonId) {
    const url = 'https://pokeapi.co/api/v2/pokemon/' + pokemonId + "/";
    const request = new XMLHttpRequest();
    request.open('GET', url);

    request.onload = () => {
      if (request.status === 200) {
        const jsonData = request.responseText;
        const pokemon = JSON.parse(jsonData);
        const pokemonDetail = {
          name: this.capitalize(pokemon.name),
          id: pokemon.id,
          image: pokemon.sprites.front_default,
          types: []
        };
        pokemonDetail.types = pokemon.types.map(typeObject => {
          return this.capitalize(typeObject.type.name);
        });
        this.setState({pokemonDetail: pokemonDetail});
      }
    };

    request.send(null);
  }

  getPokemonList(generation) {
    const generationOffset = this.props.generationOffsets[generation];
    const limit = generationOffset.limit;
    const offset = generationOffset.offset;
    const url = 'https://pokeapi.co/api/v2/pokemon/?limit=' + limit + '&offset=' + offset;
    const request = new XMLHttpRequest();
    request.open('GET', url);
    request.onload = () => {
      if (request.status === 200) {
        const jsonData = request.responseText;
        const pokedexData = JSON.parse(jsonData);
        const pokemonList = pokedexData.results;
        pokemonList.forEach((pokemon, index) => {
          pokemon.id = (offset + 1) + index;
          pokemon.name = this.capitalize(pokemon.name);
        });
        this.setState({pokemonList: pokemonList});
      }
    }
    request.send(null);
  }
}

export default PokedexContainer;
