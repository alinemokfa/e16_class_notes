# Junit Installation

Junit should have been installed as part of CodeClan's laptop installation script. This can be verified by running it from Terminal:

```bash
$ junit

JUnit version 4.12

Time: 0.003

OK (0 tests)
```

If it hasn't installed for whatever reason, check that the student has the following lines in `~/.zshrc`:

```bash
export JUNIT_HOME="$HOME/junit"
export PATH="$PATH:$JUNIT_HOME"
export CLASSPATH="$CLASSPATH:$JUNIT_HOME/junit-4.12.jar:$JUNIT_HOME/hamcrest-core-1.3.jar"
alias junit="java org.junit.runner.JUnitCore $1"
```

Once these are added, restart Terminal or type:

```bash
$ source ~/.zshrc
```

If it still doesn't work, check that the student has a `junit` folder at their home, and that it contains two `.jar` files:

```bash
$ cd ~/junit
$ ls

hamcrest-core-1.3.jar
junit-4.12.jar
```

If not, make the directory:

```bash
$ mkdir ~/junit
```

...and download the `.jar`s to it with `wget`:

```bash
wget -O "$HOME/junit/junit-4.12.jar" "http://search.maven.org/remotecontent?filepath=junit/junit/4.12/junit-4.12.jar"
wget -O "$HOME/junit/hamcrest-core-1.3.jar" "http://search.maven.org/remotecontent?filepath=org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar"
```

If the student doesn't have `wget`, it can be installed with Homebrew:

```bash
$ brew install wget
```
