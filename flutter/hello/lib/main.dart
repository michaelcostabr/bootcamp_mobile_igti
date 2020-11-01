import 'package:flutter/material.dart';

void main() {
  runApp(Hello());
}

class Hello extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Material(
          color: Colors.white,
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              Image.asset(
                "assets/super-mario-logo.png",
                height: 320.0,
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Text("Hello", style: TextStyle(fontSize: 40.0)),
                  Padding(
                      padding: const EdgeInsets.only(left: 20, right: 20),
                      child: Text("Mario!", style: TextStyle(fontSize: 40.0))),
                ],
              ),
              FlatButton(
                color: Colors.lightGreen,
                onPressed: testeButton,
                child: Text(
                  'Teste',
                  style: TextStyle(fontSize: 20.0),
                ),
              )
            ],
          )),
    );
  }

  void testeButton() {
    debugPrint("Clicou");

  }
}
