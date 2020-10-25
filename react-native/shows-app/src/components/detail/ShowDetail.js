import React, { useContext } from 'react';
import {StyleSheet,Text,View,Image} from 'react-native';
import {AppContext} from "../../context/AppContext"

const ShowDetail = () => {
    const {state} = useContext(AppContext);

    if (state.itemSelected == null) {
        return (
            <>
            </>
        );
    }

    const {name, country,network,image_thumbnail_path} = state.showList.find(item=>item.id===state.itemSelected);

    // const {name, country,network,image_thumbnail_path} = state.itemSelected ?
    //      state.showList.find(item=>item.id===state.itemSelected)
    //      : {name:"", country: "", network:"", image_thumbnail_path: ""};

    return (
        <>
        <View style={styles.parentStyle}>
            <View style={styles.viewStyle}>
                <Text>Nome: {name}</Text>
                <Text>País: {country}</Text>
                <Text>Rede: {network}</Text>
                <Image source={{uri:image_thumbnail_path}} 
                    style={styles.pictureStyle}
                    resizeMode={"contain"}/>
            </View>

        </View>
        </>
    )
}

const styles = StyleSheet.create({
    parentStyle:{
        flexDirection:"column",
        justifyContent:"center",
        alignContent:"center"
    },
    viewStyle:{
        alignSelf:"center",
        alignItems:"center"
    },
    pictureStyle:{
        height:200,
        width:300
    }
})

export default ShowDetail;
