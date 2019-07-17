# Multiple Classes

Well done,  we have become object orientated programmers,  by creating a class and instantiating objects using it.

When object orientated programming becomes really powerful is when an object uses an other object to help it in a task.  Enough theory,  let's look at an example.

## Delegating To Other Objects

### Exposing instance variables: getters, setters

Let's look at the situation of a wizard that casts a spell using a wand. The spell's strength depends on the wood's type and the wand's core.

First, we want to create tests for our Wizards. In terminal:

```bash
#terminal

mkdir multiple_classes
cd multiple_classes
mkdir specs
touch specs/wizard_specs.rb
```

Then open it up in atom!

```ruby
#specs/wizard_specs.rb

require('minitest/autorun')
require_relative('../wizard')

class TestWizard < MiniTest::Test

  def setup
    @ron = Wizard.new("Ron Weasley", "oak", "unicorn hair")
  end

  def test_wizard_has_name
    assert_equal("Ron Weasley", @ron.name)
  end

end
```

Great! The first thing we want to test is if we can create a wizard, and then access his/her name. Let's do it!

```bash
#terminal

touch wizard.rb
```

```ruby
# wizard.rb

class Wizard

  attr_reader(:name)

  def initialize(name, wand_wood, wand_core)
    @name = name
    @wand_wood = wand_wood
    @wand_core = wand_core
  end

end
```

Brilliant, test should pass no problem! Let's move on.

Wizards are no wizards without casting spells. Let's add the ability of spellcasting to our wizard class!

First, we write our test:

```ruby
# wizard_spec.rb
# same

def test_can_cast_spell
  assert_equal("stupor", @ron.cast_spell("stupor"))
end

```

Then we write the method to pass the test!

```ruby
# wizard.rb
# as before

  def cast_spell(spell_name)
    return spell_name
  end

```

Boom! Job's done. But then again, this is not really interactive. Let's do something with the wood type/core!

First, the test: 

```ruby
# wizard_spec.rb
# same

def setup
  #same
  @harry = Wizard.new("Harry Potter", "holly", "phoenix feather") #NEW
end

def test_can_cast_stronger_spell
  assert_equal("EXPECTO PATRONUM", @harry.cast_spell("expecto patronum"))
end
```

```ruby
# wizard.rb

  def cast_spell(spell_name)
    if @wand_wood == 'holly' && @wand_core == 'phoenix feather'
       puts spell_name.upcase
    else
       puts spell_name
    end
  end
```

Great!
Wait...something is not quite right. What if I want to give Harry a new wand? Do I have to recreate him from scratch? This is not really clean... And is it really the wizard's responsibility to know about the wand's wood and core?

Let's delegate the job of knowing wand cores to an appropriate class - let's create a wand class!

In terminal: 

```bash
#terminal

touch wand.rb
touch specs/wand_spec.rb
```

```ruby
# wand_spec.rb

require('minitest/autorun')
require_relative('../wand')

class TestWand < MiniTest::Test

  def setup
    @elder_wand = Wand.new("holly", "phoenix feather")
  end

  def test_wand_got_wood
    assert_equal("holly", @elder_wand.wood)
  end

  def test_wand_got_core
    assert_equal("phoenix feather", @elder_wand.core)
  end

end
```

Let's make our tests pass!

```ruby
# wand.rb
class Wand

  attr_reader(:wood, :core)

  def initialize(wood, core)
    @wood = wood
    @core = core
  end

end
```

Excellent!

Now here comes the magical part: From now on, we can instantiate a wand, and instead of the wizard being responsible for having a wand wood/core, the wand object can handle all this for us! Let's go back to our wizard.rb, and refactor our code!

```ruby
# wizard.rb
class Wizard

  def initialize(name, wand) #UPDATE
    @name = name
    @wand = wand #UPDATE
  end

  def cast_spell(spell_name) 
    @wand.cast(spell_name) #UPDATE
  end

end
```

Since it's the wand's job to keep track of the core/wood, we can give the responsibility of checking it to the wand class!

```ruby
# wand.rb

def cast(spell_name)
  if @wood == "holly" && @core == "phoenix feather"
    return spell_name.upcase
  else
    return spell_name
  end
end

```

Dang, but then our tests are failing! Let's rework them to suit them to the changes we made!

```ruby
# wizard_spec.rb

require('minitest/autorun')
require_relative('../wizard')
require_relative('../wand')

class TestWizard < MiniTest::Test

  def setup
    @broken_wand = Wand.new("oak", "unicorn hair") #NEW
    @elder_wand = Wand.new("holly", "phoenix feather") #NEW
    @ron = Wizard.new("Ron Weasley", @broken_wand) #UPDATE
    @harry = Wizard.new("Harry Potter", @elder_wand) #UPDATE
  end

  def test_wizard_got_name
    assert_equal("Ron Weasley", @ron.name)
  end

  def test_can_cast_spell
    assert_equal("stupor", @ron.cast_spell("stupor"))
  end

  def test_can_cast_stronger_spell
    assert_equal("EXPECTO PATRONUM", @harry.cast_spell("expecto patronum"))
  end

end
```

Did we have to change anything with our tests? No, we did not. Everything passes just as fine as before. The wizard here has delegated the behaviour of their spell casting to the wand. 

What object is responsible for what is one of the major challenges of object orientated programming.  There are thousands of books of this, and we enter the realm of Object Orientated Design.  For now I would not worry too much about the design and focus on getting things working.  Make it work, make it right, make it fast.

## Collection objects

We've already seen arrays and hashes. Objects whose role is to hold other objects.  Let's look at how we can use these to create our own collections.  

### Creating a collection of wizards

```ruby

#specs/coven_spec.rb

require "minitest/autorun"

require_relative "../wizard"
require_relative "../wand"
require_relative "../coven"

class TestCoven < MiniTest::Test
  def setup()
    @elder_wand = Wand.new("holly", "phoenix feather")
    @elm_wand = Wand.new("elm", "unicorn")

    @harry = Wizard.new("Harry Potter", @elder_wand)
    @hermione = Wizard.new("Hermione Granger", @elm_wand)

    @coven = Coven.new([@harry, @hermione])
  end

  def test_coven_can_cast_spell()
    expected = ["STUPOR", "stupor"]
    assert_equal(expected, @coven.cast_spell("stupor"))
  end
end

#coven.rb

class Coven
  def initialize(wizards)
    @wizards = wizards
  end

  def cast_spell(spell_name)
    mass_spell = []
  
    for wizard in @wizards
      mass_spell << wizard.cast_spell(spell_name)
    end

    return mass_spell
  end
end
```
