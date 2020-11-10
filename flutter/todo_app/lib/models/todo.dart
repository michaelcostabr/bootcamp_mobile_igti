class ToDo {
  String titulo;
  String descricao;
  String status;

  ToDo();

  ToDo.fromTituloDescricao(String titulo, String descricao) {
    this.titulo = titulo;
    this.descricao = descricao;
    this.status = 'A';
  }

  ToDo.fromJson(Map<String, dynamic> json)
      : titulo = json['titulo'],
        descricao = json['descricao'],
        status = json['status'];

  Map toJson() => {'titulo': titulo, 'descricao': descricao, 'status': status};
}
