# CraftEssentials
## About
CraftEssentials is a Android library created to fulfill some 
possibly annoying features to implement in Android apps from setting up a 
navigation drawer to showing a help activity.

## Installation
### Gradle projects
If you use a Gradle-based build environment, add this dependency to your app's
`build.gradle`:
```groovy
dependencies {
    // ...
    implementation 'com.craft.libraries:essentials:1.0.0'
}
```

### Other (Git submodule)
Alternatively, you can use Git submodules to install this library:

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

## Contributing
### Deploying to Bintray
Prerequisite: make sure you're registered in the CraftCompany Bintray 
[organization](https://bintray.com/craftco).
1) Create a `bintray.properties` file at the root of the project.
2) Add two lines for your credentials in `bintray.properties`, replacing
   `yourusername` and `yourapikey` with your Bintray username and API key,
   respectively:
    ```properties
    user=yourusername
    key=yourapikey
    ```
3) Run `./gradlew install bintrayUpload` to deploy the library.