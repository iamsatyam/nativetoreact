import React, { FunctionComponent } from "react";
import { KeyboardTypeOptions, Text, TextInput, TextInputProps, TouchableOpacity, View } from "react-native";
import { ModelUserInfo } from "./ModelUserInfo";

interface UserInputListProps extends TextInputProps {
    userInfo: ModelUserInfo,
}

const UserInputList: FunctionComponent<UserInputListProps> = (props: UserInputListProps) => {
    return (
        <TouchableOpacity style={{margin:10}}>
            <Text style={{
                paddingHorizontal: 10,
                color:'black'
            }}
                {...props}
            >{props.userInfo.name}</Text>

            <Text style={{
                paddingHorizontal: 10,                
            }}
                {...props}
            >{props.userInfo.phone}</Text>

            <Text style={{
                paddingHorizontal: 10,                
            }}
                {...props}
            >{props.userInfo.city}</Text>

            <View style={{marginVertical:10,height:1, backgroundColor:"grey"}} />
        </TouchableOpacity>
    );
}

UserInputList.defaultProps = {
    userInfo:{} as ModelUserInfo ,
}

export default UserInputList;