# **Android Kotlin MVI Test App**


### **Description**
Application connects to SpaceX API to download its rocket fleet.

Data always comes from the local persistence (offline-first approach) and updates when necessary.

Clicking on each item navigates user to a browser to read more information on the Web.

Use swipe-down gesture to refresh downloaded data.

Supports light/dark mode theming automatically.


### **Libraries and Architecture used**

* Gradle modularised project by features
* The Clean Architecture with MVI pattern in presentation layer
* Jetpack Compose with Material3 design - for UI layer
* Kotlin Coroutines & Kotlin Flow - for concurrency & reactive approach
* Kotlin Serialization converter - for JSON parsing
* Retrofit - for networking
* Hilt - for Dependency Injection pattern implementation
* Room - for local database
* Coil - for image loading
* Version Catalog - for dependency management
* Baseline and Startup Profiles - for performance improvements during app launch
* Timber - for logging
* JUnit5, Turbine and MockK - for unit tests
* Jetpack Compose test dependencies, Maestro and Hilt - for UI tests
* GitHub Actions - for CI/CD
* Renovate - to update dependencies automatically
* KtLint and Detekt - for code linting
