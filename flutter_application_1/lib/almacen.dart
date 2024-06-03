// flutter_application_1/lib/almacen.dart
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

class Categoria {
  final int id;
  final String categoria;
  final String nombre;

  Categoria({required this.id, required this.categoria, required this.nombre});

  factory Categoria.fromJson(Map<String, dynamic> json) {
    return Categoria(
      id: json['id'],
      categoria: json['categoria'],
      nombre: json['nombre'],
    );
  }
}

class AlmacenScreen extends StatefulWidget {
  const AlmacenScreen({Key? key}) : super(key: key);

  @override
  _AlmacenScreenState createState() => _AlmacenScreenState();
}

class _AlmacenScreenState extends State<AlmacenScreen> {
  Categoria _categoriaSeleccionada =
      Categoria(id: 0, categoria: 'Sin categoría', nombre: '');
  late List<Categoria> _categorias = [];

  @override
  void initState() {
    super.initState();
    _getCategorias();
  }

  Future<void> _getCategorias() async {
    final response = await http
        .get(Uri.parse('http://localhost:8080/ferreteria/categorias'));
    if (response.statusCode == 200) {
      final parsedResponse = json.decode(response.body);
      setState(() {
        _categorias = (parsedResponse as List)
            .map((categoria) => Categoria.fromJson(categoria))
            .toList();
        _categoriaSeleccionada = _categorias.isNotEmpty
            ? _categorias.first
            : Categoria(id: 1, categoria: 'Sin categoría', nombre: '');
      });
    } else {
      throw Exception('Error al cargar las categorías');
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Almacen'),
      ),
      body: Center(
        child: DropdownButton<Categoria>(
          value: _categoriaSeleccionada,
          onChanged: (newValue) {
            setState(() {
              _categoriaSeleccionada = newValue!;
            });
          },
          items: _categorias
              .map<DropdownMenuItem<Categoria>>((Categoria categoria) {
            return DropdownMenuItem<Categoria>(
              value: categoria,
              child: Text(categoria.nombre),
            );
          }).toList(),
        ),
      ),
    );
  }
}
