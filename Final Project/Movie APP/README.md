# 🎬 **Project145/Movie App**

A beautifully crafted movie app providing users with detailed movie information through dynamic API integration, Firebase authentication, and modern UI/UX principles.

---

## ✨ **Features**

- **🔥 User Authentication**: Secure login and registration using Firebase.
- **🎥 Dynamic Movie Listings**: Displays movies with title, IMDB rating, and poster in a RecyclerView.
- **📋 Detailed Film Info**: Navigate to detailed views with just a tap on the movie.
- **🌐 API Integration**: Fetch real-time movie data dynamically.
- **🎨 Elegant Design**: Clean, modern UI following Material Design guidelines.

---

## 🚀 **Getting Started**

### **Prerequisites**
1. **Android Studio** (2023.3 or later).
2. **Firebase Setup**: A valid Firebase project.
3. **Movie API Key**: Obtain an API key from your preferred movie data provider.

### **Setup Instructions**
1. Clone this repository:
   ```bash
   git clone https://github.com/neostar08/Project145.git
   ```
2. Open the project in **Android Studio**.
3. Add your `google-services.json` file under the `app/` directory for Firebase integration.
4. Include your API key in `gradle.properties` or directly in the code:
   ```java
   String apiKey = "YOUR_API_KEY";
   ```
5. Sync the Gradle and run the app on your emulator or device.

---

## 📂 **Project Structure**

```plaintext
Project145/
├── app/
│   ├── src/main/java/com/example/project145/
│   │   ├── Activity/         # Activities for login, registration, and movie display
│   │   ├── Adapter/          # RecyclerView adapters (e.g., FilmListAdapter)
│   │   ├── Domain/           # Data models (e.g., FilmItem, Datum)
│   │   ├── Utils/            # Utilities and helper functions
│   ├── res/
│   │   ├── layout/           # XML layouts for UI screens
│   │   ├── drawable/         # Images and vector assets
│   │   ├── values/           # Strings, colors, and themes
├── build.gradle              # Project-level Gradle configuration
├── settings.gradle           # Gradle settings
├── README.md                 # Project documentation (this file)
```

---

## 🛠 **Code Structure**

### **Adapters**
- **`FilmListAdapter`**: Manages movie data for the `RecyclerView`, including click listeners for detail navigation.

### **Activities**
1. **`IntroActivity`**: App introduction screen.
2. **`LoginActivity`**: Handles user login via Firebase.
3. **`RegisterActivity`**: Allows new user registration.
4. **`MainActivity`**: Displays movies fetched from the API.
5. **`DetailActivity`**: Shows detailed information about a selected movie.

### **Domain Models**
- **`FilmItem`**: Represents a single movie with fields like title, rating, poster, and ID.
- **`ListFilm`**: A wrapper class containing a list of `FilmItem` objects.
- **`Datum`**: Represents raw API response data.

---

## 🎨 **UI Previews**

| Screen             | Description                        |
|--------------------|------------------------------------|
| **Login Screen**   | Secure user login with Firebase.   |
| **Movie List**     | Dynamic display of movie data.     |
| **Detail Screen**  | Detailed view with poster, title, and rating. |

---

## 🌐 **API Integration**

The app integrates with a third-party API for fetching movie data dynamically. Example setup for Retrofit:

```java
Retrofit retrofit = new Retrofit.Builder()
    .baseUrl("https://api.example.com")
    .addConverterFactory(GsonConverterFactory.create())
    .build();
```

**Ensure you replace `api.example.com` with your movie API's base URL.**

---

## ⚙️ **Troubleshooting**

### ❌ **Error: `No adapter attached; skipping layout`**
- Solution: Verify that the `RecyclerView` adapter is correctly initialized in `MainActivity`.

### ❌ **Error: `NullPointerException` in `FilmListAdapter`**
- Solution: Check that the `ListFilm` object is properly initialized and not null.

### ❌ **Firebase Initialization Error**
- Solution: Add a valid `google-services.json` to the `app/` directory.

---

## 💡 **Contributing**

We welcome contributions from developers! If you’d like to:
- Improve the app.
- Fix bugs.
- Suggest features.

Please submit a **pull request** or open an **issue**.

---

## 📜 **License**

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).
This project template was created by Code Tutor Academy for free use. All API code, keys, design improvements, algorithms, and the login/register system were developed by neostar08. The logic and movie list structure were also created by neostar08.
---

## 👨‍💻 **Author**

**Thank you  for ANDROID CODE TUTOR on YOUTUBE. [NeoStar08](https://github.com/neostar08)**  
Passionate about building intuitive and powerful mobile applications.


