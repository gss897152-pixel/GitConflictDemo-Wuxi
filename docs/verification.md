# Verification notes

Verification date: 21 October 2026. Times in the workflow below use UTC+8.

## Versions and environment

- Initial commit: `d3a3b51baacf3958dc23d4f5f4719824e686fedf`.
- Red feature commit: `aba7c63a3aec3b1caf1ba92e509e1988a46c2774`.
- Original green feature commit: `0357bee12f105814432a91a6f3a1f196b3d624cc`.
- Conflict resolution commit: `934f820ced129a70882ad13297e23ae156454725`.
- Application version checked on main: `4ffcf4f62e0afc2233928c2b85690bdbd6543c64`.
- Build tools: AGP 9.4.1, Gradle 9.6.0, Android SDK 37.
- Runtime: Medium Phone, Android API 35, 1080 x 2400 display, 420 dpi.

## Branches and merge order

The red and original green commits each have `d3a3b51` as their parent. They change the same two attributes in `app/src/main/res/layout/activity_main.xml`.

PR #1 merged red into main at 21:09:50 on 20 October. PR #2 was then opened at 21:10:20. Resolution commit `934f820` has the original green commit and the red main merge as its parents. PR #2 merged at 21:28:03.

The code trees of original green `0357bee`, resolution `934f820`, and merged main `4ffcf4f` are identical:

```text
8ed6b0aa0dbc8f05c828c3a170b0a842d7938007
```

This records resolution Option B: keep Student 2's green buttons. The resolution merge preserves both histories even though its tree matches green.

## Reproducing the conflict

The reproduction was generated on 21 October from the recorded versions. Run this from a clone with the full project history:

```powershell
git merge-tree --write-tree 4a6c03705d69eefa0899f8909678e7793ca8d0f2 0357bee12f105814432a91a6f3a1f196b3d624cc
```

The exit code is `1`, and Git reports a content conflict in `activity_main.xml`. Both button attributes conflict: main has `#F44336`, while the incoming green version has `#4CAF50`. The [saved output and conflicted XML](evidence/conflict-reproduction.txt) document this reproduction.

The working application XML contains two green tint attributes and no `<<<<<<<`, `=======` or `>>>>>>>` markers.

## Build and runtime checks

The recorded red version and merged green version were compiled with:

```powershell
.\gradlew.bat --offline --no-daemon :app:assembleDebug
```

The local verification used cached build tools. A first build on another computer should use the normal online build command from the README.

| Version | Expected button colour | Screenshot |
| --- | --- | --- |
| Red `aba7c63` | Both `#F44336`, RGB (244, 67, 54) | [Red verification](screenshots/red-verified.png) |
| Green/main `4ffcf4f` | Both `#4CAF50`, RGB (76, 175, 80) | [Green verification](screenshots/final-green.png) |

Both APKs installed and launched on the emulator. The two button views were visible, enabled and clickable. The screenshot colour checks matched their expected RGB values.

The green APK used for this verification has SHA256:

```text
69650791CDBC0D6B88E35489C62564497323AC31ADB7A6F10EC46BA8CA08BA43
```

These results and screenshots record the verification performed on 21 October. The original feature and merge dates remain in Git and the two pull requests.
