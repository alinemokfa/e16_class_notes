import React from 'react';
import ChatForm from '../components/ChatForm';
import Message from '../components/Message';
import './ChatContainer.css';

export default class ChatContainer extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      messages: [],
      name: null,
      msg: null
    };

    this.submitForm = this.submitForm.bind(this);
    this.nameKeyUp = this.nameKeyUp.bind(this);
    this.msgKeyUp = this.msgKeyUp.bind(this);
  }

  nameKeyUp(event) {
    this.setState({
      name: event.target.value
    });
  }

  msgKeyUp(event) {
    this.setState({
      msg: event.target.value
    });
  }

  addMessage(message){
    const messages = this.state.messages;
    const newMessages = [message, ...messages];
    this.setState({
      messages: newMessages
    });
  }

  submitForm(event) {
    event.preventDefault();

    // Make sure we have a name & message before proceeding
    if (this.state.name && this.state.msg) {
      // construct a new message
      const newMessage = { author: this.state.name, text: this.state.msg };

      this.addMessage(newMessage);
    }
  }

  render() {
    const messages = this.state.messages.map((message, index) => {
      return <Message key={index} author={message.author} text={message.text} />
    });

    return (
      <div>
        <ChatForm
          nameKeyUp={this.nameKeyUp}
          msgKeyUp={this.msgKeyUp}
          onSubmit={this.submitForm}
        />
        {messages}
      </div>
    );
  }
}
