import React, { useContext } from 'react';
import {StyleSheet,View,Text,FlatList,TouchableOpacity} from 'react-native';
import { useShows } from '../../hooks/useShows';
import {AppContext} from "../../context/AppContext";

export const ShowList = () => {
    const {shows} = useShows();
    const {dispatch} = useContext(AppContext);

    return (
        <>
        <View style={styles.listStyle}>
            <FlatList 
                keyExtractor={(item)=>item.id}
                data={shows.sort((show1,show2)=>(""+show1.name).localeCompare(show2.name))}
                renderItem={({item}) => {
                    return (
                        <TouchableOpacity onPress={()=>dispatch({type:"setItemSelected", payload:item.id})}>
                            <View style={styles.buttonStyle}>
                            <Text>{item.name}</Text>
                            </View>
                        </TouchableOpacity>
                    )
                }}/>
        </View>
        </>    
    )
}

const styles = StyleSheet.create({
    buttonStyle:{
        flexDirection:"row",
        justifyContent:"center",
        borderColor:"gray",
        borderTopWidth:1,
        borderBottomWidth:1,
        backgroundColor:"#DCDCDC"
    },
    listStyle:{
        marginTop:50
    }
})