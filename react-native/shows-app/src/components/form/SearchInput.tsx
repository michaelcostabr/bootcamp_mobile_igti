import React from "react";
import {StyleSheet, View} from "react-native"
import { AntDesign} from "@expo/vector-icons";
import GenericInput from "./GenericInput";

const SearchInput = (props:any) => {

    const onChange = (text:string) => {
        if (props.onChange) props.onChange(text);
    }

    return (
        <>
        <View style={styles.viewStyle}>
            <AntDesign name="search1" size={24} color="black" style={styles.iconStyle}/>
            <GenericInput initialValue={props.initialValue} style={styles.inputStyle}
            onChangeText={onChange}/>
        </View>
        </>
    )
}

export default SearchInput;

const styles = StyleSheet.create({
    viewStyle:{
        flexDirection:"row",
        backgroundColor:"#d1cdcd",
        borderRadius:50
    },
    inputStyle:{
        marginLeft:5
    },
    iconStyle:{
        alignSelf:"center"
    }
})