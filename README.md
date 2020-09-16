# LocoLaser Android Example
LocoLaser - Localozation tool for Android and iOS. See https://github.com/PocketByte/LocoLaser/ for more details.
<br>This example project shows how to use localization in Android.

##### 1 Step: Apply gradle plugin
Example uses standard way to apply custom gradle plugin.
<br>In **`build.gradle`** of the project did added maven repository and classpath:
```gradle
buildscript {
  repositories {
    maven {
      // 1.1: Add maven repository
      url "https://plugins.gradle.org/m2/"
    }
  }
  dependencies {
    // 1.2: Add classpath dependency
    classpath "gradle.plugin.ru.pocketbyte.locolaser:plugin:1.0.4"
  }
}
```
In **`build.gradle`** of the module the plugin did applied:
```
// 1.3: Apply LocoLaser plugin
apply plugin: "ru.pocketbyte.locolaser"
```

##### 2 Step: Add 'localize' dependensy
Choose which tipe of artifact you will use and add them as **`localize`** dependency. This example uses artifact to work with Google Sheets:
```gradle
dependencies {
    // 2.1: Add dependency for mobile platform (mandatory for Android)
    localize 'ru.pocketbyte.locolaser:resource-mobile:2.0.0'
    // 2.2: Add dependency for Google Sheet
    localize 'ru.pocketbyte.locolaser:resource-googlesheet:2.0.0'
}
```
##### 3 Step: Run localization before build
This example run **`:localize`** task before each build.
<br>Modile **`build.gradle`**:
```gradle
afterEvaluate {
    preBuild.dependsOn project.tasks.localize
}
```
You can remove this code if you don't want to start localization before each build.
##### 4 Step: Create configuration file
By default project should have localization config file with name`"localize_config.json"` in the root folder of the module.
<br>This example has this file in the place. But you can change location of this file and it's name by following string:
```gradle
localize.config = "../another_module/another_name_of_config.json"
```
##### Plugin Tasks
LocoLaser plugin add tasks into **`localization`** group. You can run them manualy to run localization with different parameters.
<br>More about this plugin you can read on https://github.com/PocketByte/locolaser-gradle-plugin/blob/master/README.md
### License
```
Copyright © 2017 Denis Shurygin. All rights reserved.
Contacts: <mail@pocketbyte.ru>

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```