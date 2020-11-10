import 'dart:convert';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:todo_app/models/todo.dart';
import 'package:todo_app/screens/todo_item.dart';

class TodoList extends StatefulWidget {
  @override
  _TodoListState createState() => _TodoListState();
}

class _TodoListState extends State<TodoList> {
  List<ToDo> list = [];
  final _doneStyle =
      TextStyle(color: Colors.green, decoration: TextDecoration.lineThrough);

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _reloadList();
  }

  _reloadList() async {
    var prefs = await SharedPreferences.getInstance();
    var data = prefs.getString("list");
    if (data != null) {
      var objs = jsonDecode(data) as List;
      setState(() {
        list = objs.map((e) => ToDo.fromJson(e)).toList();
      });
    }
  }

  _removeItem(int index) {
    setState(() {
      list.removeAt(index);
    });

    SharedPreferences.getInstance()
        .then((prefs) => prefs.setString('list', jsonEncode(list)));
  }

  _doneItem(int index) {
    setState(() {
      list[index].status = 'F';
    });

    SharedPreferences.getInstance()
        .then((prefs) => prefs.setString('list', jsonEncode(list)));
  }

  _showAlertDialog(BuildContext context, String conteudo,
      Function confirmFunction, int index) {
    showDialog(
        context: context,
        builder: (context) {
          return AlertDialog(
              title: Text('Confirmação'),
              content: Text(conteudo),
              actions: [
                FlatButton(
                    onPressed: () => Navigator.pop(context),
                    child: Text("Não")),
                FlatButton(
                    onPressed: () {
                      confirmFunction(index);
                      Navigator.pop(context);
                    },
                    child: Text("Sim"))
              ]);
        });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.green,
        title: Text('Todo App'),
      ),
      body: ListView.separated(
          itemBuilder: (context, index) {
            return ListTile(
                title: Text('${list[index].titulo}',
                    style: list[index].status == 'F' ? _doneStyle : null),
                subtitle: Text('${list[index].descricao}',
                    style: list[index].status == 'F' ? _doneStyle : null),
                onTap: () => Navigator.push(
                    context,
                    MaterialPageRoute(
                      builder: (context) => TodoItem(
                        todo: list[index],
                        index: index,
                      ),
                    )).then((value) => _reloadList()),
                trailing: Row(
                  mainAxisSize: MainAxisSize.min,
                  children: [
                    IconButton(
                      icon: Icon(Icons.clear),
                      onPressed: () => _showAlertDialog(
                          context,
                          "Confirma a exclusão deste item?",
                          _removeItem,
                          index),
                    ),
                    Visibility(
                        visible: list[index].status == 'A',
                        child: IconButton(
                          icon: Icon(Icons.check),
                          onPressed: () => _showAlertDialog(
                              context,
                              "Confirma a conclusão deste item?",
                              _doneItem,
                              index),
                        ))
                  ],
                ));
          },
          separatorBuilder: (context, index) => Divider(),
          itemCount: list.length),
      floatingActionButton: FloatingActionButton(
        backgroundColor: Colors.green,
        child: Icon(Icons.add),
        onPressed: () => Navigator.push(
            context,
            MaterialPageRoute(
              builder: (context) => TodoItem(
                todo: null,
                index: -1,
              ),
            )).then((value) => _reloadList()),
      ),
    );
  }
}
