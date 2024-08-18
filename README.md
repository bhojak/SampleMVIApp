# **Android Kotlin MVI Test App**

### App Architecture:
 
The app architecture follows modular architecture (Domain, Data, and Presentation) and it uses the following pattern
 
o	MVI + CLEAN
 
###	Presentation:
o	Jetpack Compose-based UI

o	View Model (use coroutines with shared/state flow) 
###	Domain
•	Models

•	Use Cases (separate single-purpose Use Cases for different scenarios)

•	Repository

###	Data
•	DTO

•	Mappers

•	Services

•	Caching Mechanism (uses Room DB)

•	Repository Implementation 


### The application connects to SpaceX API to download its rocket fleet.

  * Data always comes from the local persistence database (offline-first approach) and updates when necessary.

  * Clicking on each item navigates the user to a new View (browser) to read more information about the item clicked.

  * You can use a swipe-down gesture to refresh downloaded data.

  * Supports light/dark mode theming automatically.
    
  * Each of these layers uses the principle of Interfaces.
    
  * The actual implementation of the protocol/interfaces is injected using Dependency Injection (Hilt).

  * The Presentation & View Model communication uses Flows/Sharedflow/Stateflow with Coroutines.

  * The Domain models are created to segregate the domain & data layers.

  * The Data layer uses a Network Client (Retrofit) with asynchronous calls via Coroutines with flows.

  * The Network client uses intercepting network connections with the "OkHttpClient" network interceptor



###  Libraries used


* Gradle - for modularised projects with features
* Jetpack Compose with Material3 design - for the UI layer
* Kotlin Coroutines & Kotlin Flow - for concurrency & reactive approach
* Kotlin Serialization converter - for JSON parsing
* Retrofit - for networking
* okhttp  - for network logging and interceptor 
* Hilt - for Dependency Injection pattern implementation
* Room - for local database
* Coil - for image loading and Image caching
* Version Catalog - for dependency management
* Baseline and Startup Profiles - for performance improvements during app launch
* Timber - for logging
* JUnit5, Turbine, and MockK - for unit tests
* Jetpack Compose test dependencies, Maestro and Hilt - for UI tests
* KtLint and Detekt - for code linting
