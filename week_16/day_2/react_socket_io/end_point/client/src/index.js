import React from 'react';
import ReactDOM from 'react-dom';
import ChatContainer from './containers/ChatContainer';
import registerServiceWorker from './registerServiceWorker';

ReactDOM.render(<ChatContainer />, document.getElementById('root'));
registerServiceWorker();
