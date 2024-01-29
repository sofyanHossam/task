# Fake Posts Android App

## Overview
This Android application fetches fake posts data from [JSONPlaceholder](https://jsonplaceholder.typicode.com/posts) and displays it in a RecyclerView. The app is designed to be responsive, supporting multiple screen sizes for phones.

## Key Features
- Fetches fake posts data from JSONPlaceholder API.
- Displays the posts in a responsive RecyclerView using DiffUtil for efficient updates.
- Implements a one-page design with the ability to navigate to a second screen displaying post details.

## Technologies Used
- **Kotlin**: The primary programming language for the Android app.
- **Dagger Hilt**: Used for dependency injection, providing a clean and modular architecture.
- **Retrofit**: Used for making network calls to JSONPlaceholder API.
- **RecyclerView with DiffUtil**: Efficiently updates the UI when new data is received.
- **MVVM (Model-View-ViewModel)**: Follows clean architecture principles, separating concerns into different modules.

## Project Structure
The project follows a clean architecture design, separating concerns into different modules:
- **app**: Contains the Android application module.
- **data**: Handles data sources, repositories, and API calls.
- **presentation**: Manages UI-related code, including ViewModels and UI components.

## Dependency Injection with Dagger Hilt
[Dagger Hilt](https://dagger.dev/hilt/) is used for dependency injection. It simplifies the process of dependency injection in Android apps, making it easier to manage and organize dependencies.

Key components:
- **@HiltAndroidApp**: Annotates the application class to initialize Dagger Hilt.
- **@HiltViewModel**: Annotates ViewModel classes to allow Dagger Hilt to provide dependencies.

## Network Calls with Retrofit
[Retrofit](https://square.github.io/retrofit/) is used to make network calls to the JSONPlaceholder API. It simplifies the process of interacting with RESTful APIs.

Key components:
- **ApiService**: Interface defining API endpoints using Retrofit annotations.
- **PostRepository**: Handles data operations, including API calls.

## RecyclerView with DiffUtil
[DiffUtil](https://developer.android.com/reference/androidx/recyclerview/widget/DiffUtil) is employed to efficiently update the RecyclerView when new data is received.

Key components:
- **PostAdapter**: RecyclerView adapter updated with DiffUtil for smooth animations.
- **PostDiffCallback**: DiffUtil.Callback implementation to calculate differences between old and new lists.

## Fetching All Posts and Post by ID
- **Fetching All Posts**: The `PostViewModel` makes a network call to get all posts from the JSONPlaceholder API and updates the UI using LiveData.
- **Fetching Post by ID**: The app uses the post ID as a query to fetch post details from the JSONPlaceholder API when a post is clicked. The details are displayed on a separate screen.

## Getting Started
1. Clone the repository: `git clone https://github.com/your-username/fake-posts-android-app.git`
2. Open the project in Android Studio.
3. Build and run the app on an emulator or a physical device.
