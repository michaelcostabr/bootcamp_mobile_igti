import React, { useState } from "react";
import {TextInput} from "react-native"

const GenericInput = (props) => {
    
    const [stateValor, setStateValor] = useState(props.initialValue);
    
    const onChange = (text) => {
        setStateValor(text);
        //console.info("entrou");
        if (props.onChangeText) {
            //console.info("salvou "+text);
            props.onChangeText(text);
            
        }
    }

    return (
        <TextInput value={stateValor} style={props.style}
        onChangeText={onChange}/>
    )
}

export default GenericInput;