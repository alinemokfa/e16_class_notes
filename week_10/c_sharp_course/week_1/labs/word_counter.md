# Lab - Word Counter

Create a simple class that can count the number of words in a block of text. You should be able to pass in a string of words and return the number of words passed in.

(Hint: look up the Split() method for strings)

### Extension:

List the number occurrences of each word . e.g. for the text: 

"It was the best of times, it was the worst of times, it was the age of wisdom, it was the age of foolishness, it was the epoch of belief, it was the epoch of incredulity, …"

 You should get something like:

"it" : 6, "was" : 6, "the" : 6, "best" : 1, "of" : 6, "times" : 2, "worst" : 1, "age" : 2, "wisdom" : 1, "foolishness" : 1,  "epoch" : 2, "belief" : 1, "incredulity" : 1

(Hint - you might want to use a Dictionary for this)

***IF YOU ARE REALLY BRAVE*** - order the occurrences of each word from highest to lowest e.g.:

"it" : 6, "was" : 6, "the" : 6, "of" : 6, "times" : 2, "age" : 2, "epoch" : 2, "best" : 1, "worst" : 1, "wisdom" : 1, "foolishness" : 1, "belief" : 1, "incredulity" : 1

(Hint - you might want to use Linq and a lambda expression)