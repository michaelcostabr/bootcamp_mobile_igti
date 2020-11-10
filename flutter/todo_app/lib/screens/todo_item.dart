import 'dart:convert';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:todo_app/models/todo.dart';

class TodoItem extends StatefulWidget {
  final ToDo todo;
  final int index;

  TodoItem({Key key, @required this.todo, @required this.index})
      : super(key: key);

  @override
  _TodoItemState createState() => _TodoItemState(todo, index);
}

class _TodoItemState extends State<TodoItem> {
  ToDo _todo;
  int _index;
  final _tituloController = TextEditingController();
  final _descricaoController = TextEditingController();

  final key = GlobalKey<ScaffoldState>();

  _TodoItemState(ToDo todo, int index) {
    this._index = index;
    if (todo != null) {
      this._todo = todo;
      _tituloController.text = todo.titulo;
      _descricaoController.text = todo.descricao;
    }
  }

  _saveItem() async {
    if (_tituloController.text.isEmpty || _descricaoController.text.isEmpty) {
      key.currentState.showSnackBar(
          SnackBar(content: Text("Título e Descrição são obrigatórios!")));
      return;
    }

    var prefs = await SharedPreferences.getInstance();
    List<ToDo> list = [];

    var data = prefs.getString("list");
    if (data != null) {
      var objs = jsonDecode(data) as List;
      list = objs.map((e) => ToDo.fromJson(e)).toList();
    }

    _todo = new ToDo.fromTituloDescricao(
        _tituloController.text, _descricaoController.text);

    if (_index == -1) {
      list.add(_todo);
    } else {
      list[_index].titulo = _todo.titulo;
      list[_index].descricao = _todo.descricao;
    }

    prefs.setString('list', jsonEncode(list));
    Navigator.pop(context);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      key: key,
      appBar: AppBar(
        backgroundColor: Colors.green,
        title: Text('Todo Item'),
      ),
      body: Column(
        children: [
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: TextField(
              controller: _tituloController,
              decoration: InputDecoration(
                  hintText: 'Título', border: OutlineInputBorder()),
            ),
          ),
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: TextField(
              controller: _descricaoController,
              decoration: InputDecoration(
                  hintText: 'Descrição', border: OutlineInputBorder()),
            ),
          ),
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: ButtonTheme(
              minWidth: double.infinity,
              child: RaisedButton(
                child: Text(
                  'Salvar',
                  style: TextStyle(fontSize: 16.0),
                ),
                onPressed: () => _saveItem(),
                color: Colors.green,
                textColor: Colors.white,
              ),
            ),
          )
        ],
      ),
    );
  }
}
