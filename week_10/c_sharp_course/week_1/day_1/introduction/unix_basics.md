# UNIX Basics
### objectives

By the end of the lesson, students will be able to:

* use the Terminal program to access the command line
* recall how to determine the current directory location
* demonstrate navigating directories
  - recognise and use the shortcut symbol to the home directory
* use the `mkdir` command to create new directories
* use the `touch`, `mv`, and `rm` commands to create, rename, and delete files

### Duration

30 mins

# Intro

Many computer systems run a flavour of Unix (Linux, Mac OSX, your home broadband router will be most likely running a version too). Unix powers around [70% of the world's web servers][1]. Being familiar with UNIX is helpful to being a more effective programmer.

## The Command Line

Before we had a GUI (graphical user interface -- mouse pointers and windows) all we had was a command line interface to interact with the computer. The command line is still a preffered way for quick access to your computer's functionality. We will be using this frequently in the course as it will greatly speed up our development process.

The command line shell is a program that accepts commands as text input and converts commands to appropriate operating system functions.

## Navigating the command prompt

All of the files on your computer are organised into a directory structure (or tree) that starts from the root (referred to as "/"). Directories within directories give us the branching structure. Basically, an upisde down tree chart.

We will use the command line to find a path through this tree to navigate to the files and directories we need.

## Typing commands

Open Terminal.

When you first open a Terminal window, the command prompt will be located in your user's "home" directory. You can find out what directory you are in by using `pwd` => "print working directory".

The home directory is referred to in shortcuts with the tilde symbol: "~"

`ls` - lists items in current directory

`.` - Is a pointer to the current directory (whatever directory you happen to be in)
`..` - Is a pointer to the parent directory (of whatever directory you happen to be in). For instance use `cd ..` to change directory into the parent.

## Managing files

Let's open the terminal, and go to our home directory - 'cd' in terminal, then 'cd Desktop'. Here, we want to create a directory where all our codes, revisions, notes will go. We can name it anything we want, a general convention here is that the directory's name is cx3_? (your cohort's number).

```
mkdir Labs
cd Labs
```
To keep it consistent with our structure, let's

```
mkdir week_1 week_1/day_1
cd week_1/day_1
touch test1 test2 test3
```

Now, if you type ls, you can see that we have all 3 files in here. Typing subl . opens them in Sublime Text, our preferred text editor.
Look at the bottom right corner - what do you see?
You can change the type of the text file by choosing it from the list - name it appropriately!

Let's say we want to move our test3 to the week_1 directory - how can we do this?

```
mv test3 ..
cd ../../
```

And if we want to remove files, we can use the rm command:

```
rm week_1/day_1/test1
```

and if we have a folder we need to recursively remove sub folders and files. Otherwise we will get an error.

```
rm -r week_1/day_1
```

The terminal gives you autocomplete functionality, and 'history' of the commands you type.
  - Use the TAB and 'up' key in the command line to increase your speed by using this functionality.

`history` - Will list your entire commands history (use `!line_number` to retrieve a specific command)

## Keyboard shortcuts

>  Remind the students that we have bound ± to be hash!!!

As you use the terminal more, you will discover many key combinations that speed your productivity.

```
  |keypress|action|
  |--------|------|
  |Ctrl + A|  Go to the beginning of the line you are currently typing on
  |Ctrl + E|  Go to the end of the line you are currently typing on
  |Ctrl + K|  Clear the line after the cursor
  |Tab     |  Auto-complete files and folder names
```
Continue to discover commands and shortcuts to improve your days -- there are many resources online: [http://ss64.com/osx/]()