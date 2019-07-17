#React Comments Form

## Learning Objectives
- Be able to add a form to a React component
- Be able to pass callbacks between components as props
- Know how and when to trigger a components render method

Yesterday we made a static application that renders a list of comments. Now let's look at how we can update our list with a new comment submitted by a user. To do this we need to alter the state of our application when the new comment gets submitted, causing a rerender.

##Adding new Comments

We are displaying the comments nicely. Now we would like to be able to add comments. Let's create a form component:

```bash
touch src/components/CommentForm.jsx
```

Let's create a form with author and text fields:

```js
// src/components/CommentForm
import React from 'react'

class CommentForm extends React.Component {
    render() {
       return (
         <form className="commentForm">
           <input
             type="text"
             placeholder="Your name"
           />
           <input
             type="text"
             placeholder="Say something..."
           />
           <input type="submit" value="Post" />
         </form>
       )
     }
}

export default CommentForm

```

And let's tell our CommentBox to render the form

```js
// src/components/CommentsBox.jsx

render() {
   return (
    <div className="comment-box">
      <h2>Add a Comment</h2> \\NEW
      <CommentForm /> \\NEW
      <h2>Comments</h2>
      <CommentList data={this.state.data} />
    </div>
  )
}

```

## Making the form interactive

The form component should have state that reflects the current values. This is called a Controlled Component.
[link to React Controlled Components](https://facebook.github.io/react/docs/forms.html)
So let's set that up in the constructor.

```js
// src/components/CommentForm.jsx

constructor(props) {
    super(props)
    this.state = {
      author: '',
      text: ''
    }
}

```

We can now set up the form to use those state values for what it is showing.

```js
// src/components/CommentForm

         <form className="commentForm">
           <input
             type="text"
             placeholder="Your name"
             value={this.state.author} // NEW
           />
           <input
             type="text"
             placeholder="Say something..."
             value={this.state.text} // NEW
           />
           <input type="submit" value="Post" />
         </form>


export default CommentForm

```

So if we refresh our browser, when we type in the fields the values don't change. This is because they are always displaying the state, which isn't being updated. Let's now update the state as the user types.

```js
// src/components/CommentForm.jsx

handleAuthorChange(event) {
  this.setState({author: event.target.value})
}

handleTextChange(event) {
  this.setState({text: event.target.value})
}

render() {
   return (
     <form className="commentForm">
       <input
         type="text"
         placeholder="Your name"
         value={this.state.author}
         onChange={this.handleAuthorChange} \\NEW
       />
       <input
         type="text"
         placeholder="Say something..."
         value={this.state.text}
         onChange={this.handleTextChange} \\NEW
       />
       <input type="submit" value="Post" />
     </form>
   )
 }

```

If we now check that in out browser, we should see an error. That's because the handle change functions have the wrong context. So let's bind them to fix this.

```js
// src/components/CommentForm.jsx

constructor(props) {
    super(props)
    this.handleAuthorChange = this.handleAuthorChange.bind(this) //NEW
    this.handleTextChange = this.handleTextChange.bind(this) //NEW
    this.state = {
      author: '',
      text: ''
    }
}

```

Ok, now we want to write a function that is called then the submit button it clicked. It's going to have two responsiblities:

1. To update the list of comments with the new comment
2. To reset the input fields

```js
// src/components/CommentForm.jsx

handleSubmit(event) {
  event.preventDefault()
  var author = this.state.author.trim()
  var text = this.state.text.trim()
  if (!text || !author) {
    return
  }
  // TODO: update the list of comments
  this.setState({author: '', text: ''})
}

render() {
  return (
    <form className="commentForm" onSubmit={this.handleSubmit}>
    // ...
  )
}
```

And let's bind the handle submit in the constructor.

```js
// src/components/CommentForm.jsx

constructor(props) {
    super(props)
    this.handleAuthorChange = this.handleAuthorChange.bind(this)
    this.handleTextChange = this.handleTextChange.bind(this)
    this.handleSubmit = this.handleSubmit.bind(this)
    // ...
}
```

## Updating the Comment List

When a user submits a comment, a new comment should be added to our list of our comments.

The state of our application should change and thus the whole page should re-render. It is here we will start to see the benefits of the one-way flow design.

### Adding comment

The comment box controls the state of our application, the array of comments. When the form adds a comment it will need to notify the CommentBox that new comment is added.

To do this we can make CommentBox pass a function to add a comment to the Form. The CommentForm can then use this function to update the state of the box.

Let's first write the function to add the comment.

Every time a component resets it's state and the state has changed, it will re-render itself and all the child components.

As our CommentBox is at the top of the chain this will cause a cascade re-rendering our whole display. One way flow.

This is efficient due to Virtual DOM.

```js
// src/components/CommmentBox

handleCommentSubmit(comment) {
  comment.id = Date.now()//comments need an id, just going to use a date for now
  var newComments = this.state.data.concat([comment])
  this.setState({data: newComments})
}

render() {
  return (
    <div className="commentBox">
      <h1>Comments</h1>
      <CommentForm onCommentSubmit={this.handleCommentSubmit} /> \\ UPDATED
      <CommentList data={this.state.data} />
    </div>
  )
}

```

And don't forget to bind it.

```js
// src/components/CommmentBox

constructor(props) {
  super(props)
  this.handleCommentSubmit = this.handleCommentSubmit.bind(this)
  // ...
}
```


Now we want the CommentForm to call this function when a comment is submitted.

```js
// src/components/CommentForm

handleSubmit(event) {
  event.preventDefault()
  var author = this.state.author.trim()
  var text = this.state.text.trim()
  if (!text || !author) {
    return
  }
  this.props.onCommentSubmit({author: author, text: text})
  this.setState({author: '', text: ''})
}
```

Fantastic we have our application dynamically updating using the React one way flow.
