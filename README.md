# Brick-Breaker
A retro-style Brick Breaker game made using Java

In this game, we have used 2 APIs in Java program:
1. AWT
2. Swing

### AWT:
Java AWT (Abstract Window Toolkit) is an API to develop Graphical User Interface (GUI) or windows-based applications in Java.
Java AWT components are platform-dependent i.e. components are displayed according to the view of operating system. AWT is heavy weight i.e. its components are using the resources of underlying operating system (OS).

The java.awt package
provides classes
for AWT API such as TextField, Label, TextArea, RadioButton, CheckBox, Choice, List etc.

### Swing:
Java Swing is a part of Java Foundation Classes (JFC) that is used to create window-based applications. It is built on the top of AWT (Abstract Windowing Toolkit) API and entirely written in java.
Unlike AWT, Java Swing provides platform-independent and lightweight components.

The javax.swing package provides classes for java swing API such as JButton, JTextField, JTextArea, JRadioButton, JCheckbox, JMenu, JColorChooser etc.


## 4 Main Components Of This Game:
1. The first class is the BrickBreaker.java class, which is the main class wherein we create the window for our game by creating a frame and defining its boundaries. We set the title for our frame as Brick Breaker and make sure the ball is visible and not resizable. We have created the frame in such a way that once we exit the game closes.
2. Next we create a class GamePlay.java. This class is called in the main class. This is the most important part of our project as we create the elements of the game in this class. We first extend this class to the game which can be done using the extends JPanel function. We use KeyListener for moving our arrow keys and ActionListener to move the ball. We can import both these packages. We then add unimplemented methods ,which creates all the methods required by the KeyListener and ActionListener modules. We also make sure that the computer does not play the game but the user does. We also set the starting position for the ball as well as the slider. The graphics slider has been used to create a black background which is rectangular in shape and has a defined boundary. The border is made yellow in colour. The colour of the slider is set to green and colour of the ball is set to yellow. The ball will move every time it touches the slider. We also make sure that the ball moves in the opposite direction every time it hits the slider. Also, the intersection of the ball with the individual bricks and then the removal of that block is done here.
3. Our third class is the MapGenerator.java. This class is called in the subclass Gameplay.java. Here, we define the different parameters for each brick. We set the total number of bricks to 21. We set the colour of the bricks to white and add the position of each brick. 
4. And finally, we have the fourth class, Sound.java, where the sound of a ball hitting the brick is added and hence we hear this sound whenever there is an intersection of ball and brick in the game. This class is called in the GamePlay.java.
