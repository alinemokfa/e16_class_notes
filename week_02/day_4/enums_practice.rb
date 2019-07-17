pets = [
  {
    name: "Sir Percy",
    pet_type: :cat,
    breed: "British Shorthair",
    price: 500
  },
  {
    name: "King Bagdemagus",
    pet_type: :cat,
    breed: "British Shorthair",
    price: 500
  },
  {
    name: "Sir Lancelot",
    pet_type: :dog,
    breed: "Pomsky",
    price: 1000,
  },
  {
    name: "Arthur",
    pet_type: :dog,
    breed: "Husky",
    price: 900,
  },
  {
    name: "Tristan",
    pet_type: :dog,
    breed: "Basset Hound",
    price: 800,
  },
  {
    name: "Merlin",
    pet_type: :cat,
    breed: "Egyptian Mau",
    price: 1500,
  }
]

## Print out all of the names using a loop

for pet in pets
  puts pet[:name]
end

## Print out all of the names using an enumerable

# pets.each { |pet| puts pet[:name] }

## Find a pet using a loop and if statement

# result = nil

# for pet in pets
#   if pet[:name] == "Tristan"
#     result = pet
#   end
# end

# puts result

##Find a pet using an enumerable

# enums_result = pets.find { |pet| pet[:name] == "Tristan" }

# puts enums_result

## Using enumerable methods:
## Find the pet which is a Husky
## Make an array of all of the pets' names
## Find out if there are any pets of breed 'Dalmation' (true or false)
## Find the most expensive pet i.e. pet with the highest/maximum price
## Find the total value (price) of all of the pets added together.
## Change each pet so their price is 50% cheaper