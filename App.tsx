import React, { useState } from 'react';
import { NavigationContainer } from '@react-navigation/native';
import UserListView from './src/UserListView';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import AddUpdateView from './src/AddUpdateView';


const Stack = createNativeStackNavigator();

const App = () => {

  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="UserList">
        <Stack.Screen
          name="UserList"
          component={UserListView}
          options={{ title: 'UserInfo' }}
        />
        <Stack.Screen name="AddUpdate" component={AddUpdateView} />
      </Stack.Navigator>
    </NavigationContainer>
  );
};

export default App;


