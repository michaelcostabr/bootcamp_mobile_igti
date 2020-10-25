import {StyleSheet, View, Text} from 'react-native';
import React from 'react';

function App() {
  return (
    <View style={styles.parent}>
      <View style={styles.v1}>
        <Text style={styles.text1}>Texto 1</Text>
        <Text style={styles.text2}>Texto 2</Text>
        <Text style={styles.text1}>Texto 3</Text>
      </View>
      <View style={styles.v2}>
        <Text style={styles.text1}>Texto 1</Text>
        <Text style={styles.text2}>Texto 2</Text>
        <Text style={styles.text1}>Texto 3</Text>
      </View>
    </View>
  )
}

export default App_flexExample;

const styles = StyleSheet.create({
  parent:{
    margin:5,
    flex:1
  },
  text1:{
    backgroundColor:"yellow",
  },
  text2:{
    backgroundColor:"magenta",
    alignSelf:"center"
  },
  v1:{
    flex:1,
    justifyContent:"space-around",
    backgroundColor:"blue",
    alignItems:"flex-end",
    flexDirection:"row",
    marginTop:20
  },
  v2:{
    flex:1,
    justifyContent:"space-around",
    backgroundColor:"gray",
    alignItems:"flex-end",
    flexDirection:"column"
  }
})