import {StyleSheet, View, TextInput} from "react-native";
import React, {useState} from "react";
import DatePicker from "react-native-datepicker";

function App() {
    const [stateValorInput, setStateValorInput] = useState("");
    const [stateData, setStateData] = useState("17-10-2020");

    return (
        <>
        <View style={styles.viewStyle}>
         <TextInput style={StyleSheet.textInputStyle} 
         value={stateValorInput} onChangeText={(text)=>setStateValorInput(text)}/>
        </View>
        <View>
            <DatePicker
            date={stateData}
            mode="date"
            placeholder="Selecione a data"
            format="DD-MM-YYYY"
            minDate="01-01-2000"
            confirmBtnText="Confirmar"
            cancelBtnText="Cancelar"
            onDateChange={(date)=> {setStateData(date)}}/>
        </View>
        </>
    )
}

export default App_datePicker;

const styles = StyleSheet.create({
    viewStyle:{
        marginTop:20
    },
    textInputStyle:{
        backgroundColor:"#d1cdcd",
        height:50
    }
})