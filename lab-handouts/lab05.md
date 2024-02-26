# Improve code with GitHub Copilot

## Bug Fixes - MotionTracking.java

This Java code is an Android activity for a motion tracking application using Google's Project Tango. Here's a breakdown of the key parts:

- Imports: The code imports necessary classes from the Tango API, Android SDK, and Rajawali3D (a 3D engine for Android).
- Class Declaration: The MotionTrackingActivity class extends Activity, meaning it represents a single screen in the app.
- Variables: The class has several private variables, including a RajawaliSurfaceView for rendering 3D graphics, a MotionTrackingRajawaliRenderer for handling the OpenGL rendering, a TangoConfig for configuring the Tango service, an AtomicBoolean to track if the Tango pose is ready, and an integer for the display rotation.
- Lifecycle Methods: The onCreate, onResume, and onPause methods are overridden to set up the views and renderer, initialize the Tango service, and disconnect from the Tango service, respectively.
- setupViews: This method sets up the RajawaliSurfaceView and its renderer.
- initializeTango: This method initializes the Tango service, sets up the Tango configuration, connects to the Tango service, and sets the display rotation.
- disconnectTango: This method disconnects from the Tango service.
- setupTangoConfig: This method sets up the Tango configuration to enable motion tracking and auto recovery.
- startupTango: This method starts up the Tango service by connecting a listener that listens for updates from the Tango service.
- setDisplayRotation: This method gets the current display rotation and stores it in mDisplayRotation.
- showsToastAndFinishOnUiThread: This method shows a toast message on the UI thread and finishes the activity. It's used to handle exceptions when initializing the Tango service.

The code uses the Tango service to track the device's motion and render it using the Rajawali3D engine. The Tango service provides pose data (the device's position and orientation), which can be used to create motion tracking applications.

### Task 1

1. Read through the program in `MotionTracking.java` and see if you can determine the bugs that are currently evident: 

  - the `mConfig` variable is used but not declared
  - the `initializeTango() method is missing a semi-colon at the end`
  - the `onPause()` method is overridden but it doesn't do anything
  - the `disconnectTango` meothod is defined but never called

### Task 2

2. Copy and paste the code in `MotionTracking.java` into GitHub Copilot Chat and prompt it to determine the bugs in the code

```
Are there any bugs in the above code?
```

3. Determine if Copilot found the same bugs that you did

### Task 3

4. Prompt Copilot to fix the bugs in the code using inline GitHub Copilot Chat

  4a. Open `MotionTracking.java`, select all of the code in the file 
  4b. Open inline Copilot Chat by pressing **Ctrl + I**
  4c. Prompt Copilot to fix the bugs in the code --> `Fix the bugs in the selected code`

5. Accept each of the suggestions given, ensuring that they address all of the bugs mentioned above

### Task 4

6. Save your changes and commit your code 

    #### Using the VS Code Interface

    1. Click the VS Code **Source Control** tab on the left hand of your VS Code screen or press `Ctrl + Shift + G` 
    2. Stage your changes by clicking the small plus icon in the righthand corner of the panel
    3. Enter a commit message and select the **Commit** button
    4. Once changes are staged, click the elipses in the far right corner, choose **Push** and enter your password
    5. Wait approx. 1 minute and refresh your GitHub repository to ensure that the changes are reflected in your repository

## Refactoring Complex Code

### Task 1

1. Highlight all of the code in `MotionTracking.java` by pressing **Ctrl + I**
2. Open inline GitHub Copilot Chat in `MotionTracking.java` by pressing **Ctrl + I**
3. Prompt Copilot to refactor the code: 

```
Refactor the selected code
```

### Task 2

4. Accept the changes suggested by GitHub Copilot

### Task 3

5. Save your changes and commit your code

    #### Using the VS Code Interface

    1. Click the VS Code **Source Control** tab on the left hand of your VS Code screen or press `Ctrl + Shift + G` 
    2. Stage your changes by clicking the small plus icon in the righthand corner of the panel
    3. Enter a commit message and select the **Commit** button
    4. Once changes are staged, click the elipses in the far right corner, choose **Push** and enter your password
    5. Wait approx. 1 minute and refresh your GitHub repository to ensure that the changes are reflected in your repository