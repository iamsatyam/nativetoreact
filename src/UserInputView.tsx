import React, { FunctionComponent } from "react";
import { KeyboardTypeOptions, TextInput, TextInputProps, View } from "react-native";

interface UserInputViewProps extends TextInputProps {
    placeHolder: string,
    keyboardType?: KeyboardTypeOptions,
    value: string,
}

const UserInputView: FunctionComponent<UserInputViewProps> = (props: UserInputViewProps) => {
    return (
        <View>
            <TextInput style={{
                height: 50,
                borderColor: "#d0d3d4",
                borderWidth: 1,
                backgroundColor: "#ecf0f1",
                paddingHorizontal: 10,
                marginVertical: 10
            }}
                {...props}
                placeholder={props.placeHolder}
                multiline={false}
                value={props.value}
                keyboardType={props.keyboardType}
            />
        </View>
    );
}

UserInputView.defaultProps = {
    placeHolder: "",
    keyboardType: "default",
    value: ""
}

export default UserInputView;