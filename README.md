# GitConflictDemo-Wuxi

Practical 4 group project. Student 1: 20243007027 (`gss897152-pixel`).

## Initial application

The initial layout contains two buttons with the same blue background (`#3F51B5`). Each button displays a short message when tapped.

Both students should run this initial version before starting their feature branches.

[Initial application](docs/screenshots/initial.png)

## Run

Open this folder in Android Studio with support for Android Gradle Plugin 9.4. Install Android SDK 37, wait for Gradle sync, and run `app` on an emulator.

To build from a terminal:

```powershell
.\gradlew.bat :app:assembleDebug
```

The initial debug build was installed and run on a Medium Phone emulator with Android API 35. Both button backgrounds were checked as RGB (63, 81, 181), and each tap displayed its expected message:

- [Button 1 feedback](docs/screenshots/button-1-clicked.png)
- [Button 2 feedback](docs/screenshots/button-2-clicked.png)

## Collaboration

- Student 1 will change both button backgrounds on `feature-red-button`.
- Student 2 will change the same XML attributes on `feature-green-button`.
- Both branches must start from the same initial commit.
- Merge the red pull request first, then open the green pull request and inspect its conflict.
- Keep both feature branches so their commits remain available for review.
