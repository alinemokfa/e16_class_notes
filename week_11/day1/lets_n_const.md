### Const and let

`var` declarations are something we are very familiar with:

```
var myMoney = 10
myMoney = 9
console.log( myMoney )
```

We can see we can reassign the variable and JS has no problem with it. Useful, but potentially dangerous. Consider:

```
var myMoney = 20

if ( myMoney > 10 ) {
	var taxHaven = myMoney * myMoney
}

console.log( taxHaven )
```

What will the log display? This means that a `var` is function scoped. In the above example we can imagine in a big set of scripts the potential to shadow `taxHaven` variable is possible. Let's change the var to const:

```
const myMoney = 20

if ( myMoney > 10 ) {
  const taxHaven = myMoney * myMoney
}

console.log( myMoney )
console.log( taxHaven )
```

Now it throws an error. A `const` is block scoped meaning `taxHaven` is only available inside the `if` statement squigglies.

Our tax haven is yielding even more funds. Let's reassign it and add on 100 bucks:

```
const myMoney = 20

if ( myMoney > 10 ) {
  const taxHaven = myMoney * myMoney
  taxHaven = taxHaven + 100
}
```

This will throw an error `Assignment to constant variable.` - a `const` declaration can't be reassigned. Enter `let`:

```
const myMoney = 20

if ( myMoney > 10 ) {
  let taxHaven = myMoney * myMoney
  taxHaven = taxHaven + 100
  console.log( taxHaven )
}
```

`let` is a declaration that allows reassignment. And like const, it is block scoped, if we move the `taxHaven` variable out the if block, we get a not defined error.

As a rule of thumb, use `const` unless you need to use `let`
