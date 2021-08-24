# Text file processing app


#### JavaFX installation with Eclipse

1. Download the `E(fx)clipse` plug-in from eclipse.org marketplace.
2. `File` > `New` > `Other` > `JavaFX Project`, de-select the "Create module-info.java" option.
3. Download the `JavaFX SDK` (currently available from [gluonhq](https://www.gluonhq.com)) and extract the folder.
4. In Eclipse, go to `Window` > `Preferences` > `Java` > `Build Path` > `User Libraries`, create a new library for JavaFX and add all files from the extracted folder's lib directory via "Add External JARs".
5. Right-click the JavaFX project and go to `Build Path` > `Configure Build Path` > `Libraries`, then select `Classpath` and `Add Library` > `User Library` > `JavaFX`. The `JRE System Library` should be under `Modulepath`, and the `JavaFX SDK` should be under `Classpath`.
6. Select `Run` > `Run Configurations` > `Arguments` > `VM Arguments` and add the following:

    `--module-path "<path to lib folder of the javafx sdk>" --add-modules javafx.controls,javafx.fxml`
 
#### Additional dependency: SceneBuilder

1. Download from [gluonhq](https://www.gluonhq.com).
2. Set up in Eclipse via `Window` > `Preferences` > `JavaFX`, add the installation path of the `.exe` file to the field labelled "SceneBuilder executable".

