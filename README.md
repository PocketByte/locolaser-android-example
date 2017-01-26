# LocoLaser Android Example
LocoLaser - Localozation tool for Android and iOS. See https://github.com/PocketByte/LocoLaser/blob/master/README.md for more details.
This example project shows how to use localization in Android.

##### 1 Step: Apply gradle plugin
This example uses standard way to apply custom gradle plugin.
In **`build.gradle`** of the project did added maven repository and classpath:
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
    classpath "gradle.plugin.ru.pocketbyte.locolaser:plugin:1.0.0"
  }
}
```
In **`build.gradle`** of the module the plugin did applied:
```
// 1.3: Apply LocoLaser plugin
apply plugin: "ru.pocketbyte.locolaser"
```

##### 2 Step: Add 'localize' dependensy
Choose which tipe of artifact you will use and add it as **`localize`** dependency. This example uses artifact to work with Google Sheets:
```gradle
dependencies {
    // 2: Add classpath dependency
    localize 'ru.pocketbyte.locolaser:locolaser-mobile-googlesheet:1.0.+'
}
```
##### 3 Step: Run localization before build
This example run **`:localize`** task before each build.
Modile **`build.gradle`**:
```gradle
afterEvaluate {
    preBuild.dependsOn project.tasks.localize
}
```
You can remove this code if you didn't want to start localization before each build.
##### 4 Step: Create configuration file
By default project should have localization config file with name`"localize_config.json"` in the root folder of the module.
This example has this file in the place. But you can change location of this file and it's name by following string:
```gradle
localize.config = "../another_module/another_name_of_config.json"
```
##### Plugin Tasks
LocoLaser plugin add tasks into **`localization`** group. You can run them manualy to run localization with different parameters.
More about this plugin you can read on https://github.com/PocketByte/locolaser-gradle-plugin/blob/master/README.md
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