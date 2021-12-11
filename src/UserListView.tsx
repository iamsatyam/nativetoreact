import React, { useEffect, useState } from 'react';
import {
  NativeModules,
  SafeAreaView,
  ScrollView,
  StyleSheet,
  ToastAndroid,
  TouchableOpacity,
  View,
} from 'react-native';
import { ModelUserInfo } from './ModelUserInfo';
import UserInputList from './UserInputList';
import Icon from 'react-native-vector-icons/Ionicons';
const { UserInfoBridge } = NativeModules;

const UserListView = ({ navigation }) => {

  const [userInfo, setUserInfo] = useState([] as ModelUserInfo[])

  const onRefreshed = () => {
    fetchUserInfo()
  }

  const openAddUpdate = async () => {
    navigation.navigate('AddUpdate', { type: 'Add User Info', onRefresh: onRefreshed })
  }

  useEffect(() => {
    fetchUserInfo()
  }, []);

  async function fetchUserInfo() {
    let userInfoResult = await UserInfoBridge.getUserInfoData()
    if (userInfoResult) {
      userInfoResult = JSON.parse(userInfoResult)
      var userInfoArr: ModelUserInfo[] = [];

      userInfoResult.forEach((element: ModelUserInfo) => {
        console.log(element)
        userInfoArr.push({ name: element.name, phone: element.phone, city: element.city });
      });

      setUserInfo(userInfoArr)
    } else {
      ToastAndroid.show("Please add some data", ToastAndroid.SHORT);
    }
  }


  return (
    <SafeAreaView style={{ flex: 1 }}>

      <ScrollView>
        {
          userInfo.map((user, i) => (
            <UserInputList
              key={i}
              userInfo={user}
            />
          ))
        }
      </ScrollView>

      <TouchableOpacity style={styles.favIcon} onPress={() => openAddUpdate()}>
        <Icon
          name="add-circle-sharp"
          size={50}
          color="black"

        />
      </TouchableOpacity>
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  favIcon: {
    position: 'absolute',
    justifyContent: 'center',
    alignItems: 'center',
    alignSelf: 'flex-end',
    bottom: 0,
    padding: 30,
  },
});

export default UserListView;


