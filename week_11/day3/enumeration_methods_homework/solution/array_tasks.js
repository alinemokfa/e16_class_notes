var arrayTasks = {

	concat: function (arr1, arr2) {
		return arr1.concat(arr2)
	},

	insertAt: function (arr, itemToAdd, index) {
		arr.splice(index, 0, itemToAdd)
		return arr
	},

	square: function (arr) {
		return arr.map(function (number) {
			return number * number
		})
	},

	sum: function (arr) {
		return arr.reduce(function (total, number) {
			return number + total
		})
	},

	findDuplicates: function (arr) {
		return arr.filter(function (item, i) {
			var restOfArrayIncludesItem = arr.slice(i + 1).includes(item)
			var isFirstInstanceOfItem = arr.indexOf(item) === i
			return restOfArrayIncludesItem && isFirstInstanceOfItem
		})
	},

	removeAndClone: function (arr, valueToRemove) {
		return arr.filter(function (item) {
			return item !== valueToRemove
		})
	},

	findIndexesOf: function (arr, itemToFind) {
		var results = []

		arr.forEach(function (item, index) {
			if (item === itemToFind) results.push(index)
		})

		return results
	},

	sumOfAllEvenNumbersSquared: function (arr) {
		return arr.reduce(function (total, number) {
			if (number % 2 === 0) {
				return total + Math.pow(number, 2)
			}
			return total
		}, 0)
	}

}

module.exports = arrayTasks
