config = {
  entry: __dirname + "/client/src/app.js",
  output: {
    filename: "bundle.js",
    path: __dirname + "/client/build/js"
  },
  devtool: 'source-map',
  module:{
    rules: [{
      test: /\.js?$/,
      exclude: /(node_modules)/,
      loader: 'babel-loader',
      query: {
        presets: ['env']
      }
    }]
  }
};

module.exports = config;
