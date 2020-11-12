import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:social_app/screens/feed.dart';
import 'package:social_app/screens/perfil.dart';
import 'package:social_app/services/placeholder_service.dart';

class CustomDrawer extends StatelessWidget {
  final _placeholderSvc = new PlaceholderService();

  @override
  Widget build(BuildContext context) {
    return Drawer(
      child: ListView(
        children: [
          DrawerHeader(
              decoration: BoxDecoration(color: Colors.teal),
              child: Image.asset("assets/logo.png")),
          ListTile(
            title: Text("Perfil"),
            onTap: () {
              //Navigator.pop(context);
              _placeholderSvc.getPerfil().then((user) {
                Navigator.pushReplacement(context,
                    MaterialPageRoute(builder: (context) => Perfil(user)));
              });
            },
          ),
          ListTile(
            title: Text("Feed"),
            onTap: () {
              Navigator.pop(context);
              Navigator.pushReplacement(
                  context, MaterialPageRoute(builder: (context) => Feed()));
            },
          )
        ],
      ),
    );
  }
}
