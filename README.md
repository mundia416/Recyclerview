# Base
contains base structure and classes to form the base framework to develop apps

# Usage
1. Create new android project

2. Download base repository and unzip it

3. Copy all the files in the base repository to the directory of the newly created android project replacing all the files and directories

4. Open the following directories and rename them to the directories of your newly created android project following its package name

```
Base/app/src/main/java/com/nosetrap/base
Base/app/src/test/java/com/nosetrap/base
Base/app/src/androidTest/java/com/nosetrap/base
```

5. in the projects directory, rename the ``` Base.iml ``` to match the name of your newly created android project.

6. Open the app module's build.gradle file and update the applicationId to the package name of your newly created android project

```
android {
    ...
    defaultConfig {
    //update the application id to match the package name of your newly created android project
    
        applicationId "com.nosetrap.base"
       ...
      }
      ...
 }
```

7. Open the app module's AndroidManifest file and update the package name to the package name of your newly created android project

```
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.nosetrap.base">
    ...
 ```
 
 8. Open the strings resource file and update the appname to the name of the newly created android project
 
 ```
  <string name="app_name">Base</string>
  ```
 
 ## All Done, Code away!
 
 
 For creating new modules from the base android project, simply create the new module and copy all the files in the app module into the newly created module and follow the steps mentioned above.
 
 ## Author

Mundia Mundia 



## License

Copyright 2019 Mundia Mundia

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.



