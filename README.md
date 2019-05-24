# base
contains base structure and classes to form the base framework to develop apps

# Usage
1. Create new android project
2. Download base repository and unzip it
3. Copy all the files in the base repository to the directory of the newly created android project replacing all the files and directories
4. open the following directories and rename them to the directories of your newly created android project following its package name
""
Base/app/src/main/java/com/nosetrap/base
Base/app/src/test/java/com/nosetrap/base
Base/app/src/androidTest/java/com/nosetrap/base
""
4. Open the app module's build.gradle file and update the applicationId to the package name of your newly created android project
"" 
android {
    ...
    defaultConfig {
    //update the application id to match the package name of your newly created android project
        applicationId "com.nosetrap.base"
       ...
      }
      ...
 }
""

5. Open the app module's AndroidManifest file and update the package name to the package name of your newly created android project
""
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.nosetrap.base">
    ...
 ""
 6. Open the strings resource file and update the appname to the name of the newly created android project
 
 ## All Done, Code away!
 
 
 For creating new modules from the base android project, simply create the new module and copy all the files in the app module into the newly created module and follow the steps mentioned above.
