require( 'minitest/autorun' )
require_relative( '../friends' )

class TestFriends < MiniTest::Test

  def setup

    @person1 = {
      name: "Rick",
      age: 12,
      monies: 1,
      friends: ["Jay","Keith","Dave", "Val"],
      favourites: {
        tv_show: "Friends",
        things_to_eat: ["charcuterie"]
      }
    }

    @person2 = {
      name: "Jay",
      age: 15,
      monies: 2,
      friends: ["Keith"],
      favourites: {
        tv_show: "Baywatch",
        things_to_eat: ["soup","bread"]
      }
    }

    @person3 = {
      name: "Val",
      age: 18,
      monies: 20,
      friends: ["Rick", "Jay"],
      favourites: {
        tv_show: "Pokemon",
        things_to_eat: ["ratatouille", "stew"]
      }
    }

    @person4 = {
      name: "Keith",
      age: 18,
      monies: 20,
      friends: ["Rick", "Jay", "Dave"],
      favourites: {
        tv_show: "Pokemon",
        things_to_eat: ["spaghetti"]
      }
    }

    @person5 = {
      name: "Dave",
      age: 20,
      monies: 100,
      friends: [],
      favourites: {
        tv_show: "Scrubs",
        things_to_eat: ["spinach"]
      }
    }

    @people = [@person1, @person2, @person3, @person4, @person5]

  end
  def test_getting_name
    result = get_name(@person5)
    assert_equal("Dave", result)
  end

  # 1. For a given person, return their favourite tv show
  def test_favourite_tv_show
    assert_equal("Friends", favourite_tv_show(@person1))
  end

  # 2. For a given person, check if they like a particular food
  def test_likes_to_eat
    assert_equal(true, likes_to_eat(@person3,"stew"))
    assert_equal(false, likes_to_eat(@person2,"stew"))
  end

  # 3. Allow a new friend to be added to a given person
  def test_add_friend
    add_friend("Tony", @person1)
    assert_equal("Tony", @person1[:friends].pop)
  end

  # 4. Allow a friend to be removed from a given person
  def test_remove_friend
    remove_friend("Jay", @person1)
    assert_equal(3, @person1[:friends].size)
  end

  # 5. Find the total of everyone's money
  def test_total_funds
    assert_equal(143, total_funds(@people))
  end

  # 6. For two given people, allow the first person to loan a given value of money to the other
  def test_lend_money
    lend_money(@person5, @person1, 10)
    assert_equal(90, @person5[:monies])
    assert_equal(11, @person1[:monies])
  end

  # 7. Find the set of everyone's favourite food joined together
  def test_all_foods
    foods = ["charcuterie","soup","bread","ratatouille","stew","spaghetti","spinach"]
    assert_equal(foods, all_foods(@people))
  end

  # 8. Find people with no friends
  def test_no_friends
    assert_equal([@person5],no_friends(@people))
  end

  # VERY tough
  # Find the people who have the same favourite tv show
  def test_same_tv_show
    result = same_tv_show( @people, "Pokemon" )
    assert_equal([ "Val", "Keith" ], result )
  end
end
