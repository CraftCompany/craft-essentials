# CraftEssentials
## About
CraftEssentials is a Android library created to fulfill some 
possibly annoying features to implement in Android apps from setting up a 
navigation drawer to showing a help activity.

## Installation
Currently, there is no Maven repository for this project, so Git submodules
are the preferred way into install this library:

```shell
git submodule add https://github.com/CraftCompany/craft-essentials.git CraftEssentials
```

This will clone the CraftEssentials repository into a folder named 
CraftEssentials. Add the library to your app's settings.gradle:
```groovy
include ':app', 'craft-essentials'
project(':craft-essentials').projectDir = new File(settingsDir, 'CraftEssentials/library')
```

Now to your app's build.gradle:
```groovy
depdendencies {
    implementation project(':craft-essentials')
    // ...
}
```