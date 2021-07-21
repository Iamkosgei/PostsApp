
# Posts App  
A simple posts app using android architecture components using kotlin and Android Jetpack Components. It fetches posts from https://jsonplaceholder.typicode.com/  
  
## Architecture 
MVVM architecture is a Model-View-ViewModel architecture that removes the tight coupling between each component.  
  
![MVVM](https://user-images.githubusercontent.com/14147462/118546931-545ca300-b761-11eb-9400-275023a5cdd2.png)  
  
  
## SCREENSHOTS <p float="left">    
<p>
  <img src="https://user-images.githubusercontent.com/14147462/126531086-1dd288b3-202d-47fa-8ea1-111cf76267fe.jpg" width="150" />    
    <img src="https://user-images.githubusercontent.com/14147462/126531074-3b818726-dd8c-4662-915e-951f6a80f718.jpg" width="150" />    
      <img src="https://user-images.githubusercontent.com/14147462/126531050-3d4f2d4a-95c4-4916-96f9-898022ce9976.jpg" width="150" />    
        <img src="https://user-images.githubusercontent.com/14147462/126531095-1c87fa0a-b92b-42d8-9df0-99d96afc1a8b.jpg" width="150" />    
  <img src="https://user-images.githubusercontent.com/14147462/126531092-9afa3928-a8ce-42d8-8d9b-869f23f8e074.jpg" width="150" />    
</p>    
<p>    
   <img src="https://user-images.githubusercontent.com/14147462/126531089-c85a28e4-703a-4120-9c50-9658114b114b.jpg" width="150" />   
   <img src="https://user-images.githubusercontent.com/14147462/126531073-542508c3-5f0a-48c0-ba4b-7dd77c503773.jpg" width="150" />    
 <img src="https://user-images.githubusercontent.com/14147462/126531079-77937de4-94ee-4c0e-b8dd-e69b59b6a397.jpg" width="150" />    
         <img src="https://user-images.githubusercontent.com/14147462/126531096-64e1fe37-f360-402a-a85d-2a153e092232.jpg" width="150" />    
    <img src="https://user-images.githubusercontent.com/14147462/126531093-4962baae-dc0e-474a-95e2-8038b81c0dcc.jpg" width="150" />    
</p>  
  
  
  
## Tech-stack  
  
* Tech-stack  
  * [Kotlin](https://kotlinlang.org/) - a cross-platform, statically typed, general-purpose programming language with type inference.  
  * [Live data](https://kotlinlang.org/) - LiveData is a data holder class that can be observed within a given lifecycle.  
  * [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - A coroutine is a concurrency design pattern that you can use on Android to simplify code that executes asynchronously.  
  * [HILT](https://developer.android.com/training/dependency-injection/hilt-android) -Hilt is a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project.   
  * [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android.  
  * [Room](https://developer.android.com/topic/libraries/architecture/room) - a persistence library provides an abstraction layer over SQLite.  
  * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - ViewModel is designed to store and manage UI-related data in a lifecycle conscious way. Write perfect code that works consistently across all Android versions and devices.  
  * [Timber](https://github.com/JakeWharton/timber) - a highly extensible android logger.  
  * [Leak Canary](https://github.com/square/leakcanary) - a memory leak detection library for Android.  
  * [Shimmer for Android](https://facebook.github.io/shimmer-android/) - Shimmer is an Android library that provides an easy way to add a shimmer effect to any view in your Android app.  
  * [Kotlin flows](https://developer.android.com/kotlin/flow) - a flow is a type that can emit multiple values sequentially, as opposed to suspend functions that return only a single value.   
  * [DiffUtil](https://developer.android.com/reference/androidx/recyclerview/widget/DiffUtil) - DiffUtil is a utility class that calculates the difference between two lists and outputs a list of update operations that converts the first list into the second one.
  * [OkHttp interceptor](https://square.github.io/okhttp/interceptors/) - logs HTTP request and response data.. 