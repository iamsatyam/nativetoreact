import React, { useState } from 'react';
import {
  NativeModules,
  SafeAreaView,
  StyleSheet,
  Text,
  ToastAndroid,
  TouchableOpacity,
  View,
} from 'react-native';
import { ModelUserInfo } from './ModelUserInfo';
import UserInputView from './UserInputView';
const { UserInfoBridge } = NativeModules;

const AddUpdateView = ({ navigation, route }) => {

  navigation.setOptions({ title: route.params.type })

  const [userName, setName] = useState('')
  const [userPhone, setPhone] = useState('')
  const [userCity, setCity] = useState('')

  const handleAddUpdate = () => {

    if (!userName) {
      ToastAndroid.show('Please enter name', ToastAndroid.SHORT)
    } else if (!userPhone) {
      ToastAndroid.show('Please enter phone', ToastAndroid.SHORT)
    } else if (!userCity) {
      ToastAndroid.show('Please enter city', ToastAndroid.SHORT)
    } else {
      UserInfoBridge.setUserInfoData(userName,userPhone,userCity)
      setName('')
      setPhone('')
      setCity('')
      navigation.goBack()
      route.params.onRefresh()
    }
  }

  return (
    <SafeAreaView >
      <View style={{ padding: 10 }}>

        <UserInputView
          placeHolder="Name"
          value={userName}
          onChangeText={(value) => setName(value)}
        />

        <UserInputView
          placeHolder="Phone"
          value={userPhone}
          keyboardType="number-pad"
          onChangeText={(value) => setPhone(value)}
        />

        <UserInputView
          placeHolder="City"
          value={userCity}
          onChangeText={(value) => setCity(value)}
        />

        <TouchableOpacity onPress={() => handleAddUpdate()} style={styles.btnStyle}>
          <Text style={{ color: "white" }}>Proceed</Text>
        </TouchableOpacity>

      </View>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  btnStyle: {
    width: "50%",
    height: 50,
    backgroundColor: "blue",
    marginVertical: 10, 
    justifyContent: 'center', 
    alignItems: 'center', 
    borderRadius: 10, 
    alignSelf: 'center'
  },
});

export default AddUpdateView;


