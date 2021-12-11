This project is built in native android and react native.

About Project:

•	Project initially created in native android.

•	Here we add user info in sharedpreference and then show it in a list.

•	After that we add react native support in that project.

•	Same functionality of add and list of userinfo are added in react native side also.

•	In react native we use functional component with hooks to manage state.

•	Used native bridge to add or get list of userinfo to share data within android and react native functionality.


Steps to run:

1.In root dir

•	yarn install

•	yarn start


2.To crate release build , in root dir 

     
•	npx react-native bundle --platform android --dev false --entry-file index.js --bundle-output android/app/src/main/assets/index.android.bundle

•	cd android

•	gradlew assembleRelease


