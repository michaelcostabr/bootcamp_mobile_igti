import React, {useState,useContext} from 'react';
import {View, StyleSheet, Button} from "react-native";
import Input from '../components/form/Input';
import {AppContext} from "../context/AppContext";

const NewShowScreen = () => {
    const [stateName, setStateName] = useState("");
    const [stateNetwork, setStateNetwork] = useState("");
    const [stateCountry, setStateCountry] = useState("");
    const [stateThumbnail, setStateThumbnail] = useState("");
    const {dispatch,state} = useContext(AppContext);

    const salvar=()=>{
        console.log("statename"+stateName);
        const newId = state.showList.sort((show1,show2)=>show2.id - show1.id)[0].id+1;
        const action = {
            type:"addItem",
            payload:{
            id:newId,
            name:stateName,
            network:stateNetwork,
            country:stateCountry,
            image_thumbnail_path:stateThumbnail,
            }
        };
        dispatch(action);

    }

    return (
        <>
        <View style={styles.viewStyle}>
          <Input label={"Nome:"} initialValue={""} onChange={(text)=>setStateName(text)} />
          <Input label={"Rede:"} initialValue={""} onChange={(text)=>setStateNetwork(text)} />
          <Input label={"País:"} initialValue={""} onChange={(text)=>setStateCountry(text)} />
          <Input label={"Imagem"} initialValue={""} onChange={(text)=>setStateThumbnail(text)} />
          <Button title={"Salvar"} onPress={salvar}/>
        </View>
        </>
    )
}

const styles=StyleSheet.create({
    viewStyle:{
        marginTop:50,
    }
})

export default NewShowScreen;