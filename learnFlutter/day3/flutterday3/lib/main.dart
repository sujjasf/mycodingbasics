import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: HomePage(),
    );
  }
}

class HomePage extends StatefulWidget {
  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  int counter = 10;

  TextEditingController nameController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.cyanAccent,
        title: Center(child: Text("Counter App")),
      ),

      body: Column(
        children: [
          TextField(
            controller: nameController,
            decoration: InputDecoration(
              hintText: "Enter your name",
            ),
          ),

          FilledButton(
            onPressed: () {
              String name = nameController.text;
              nameController.clear();

              ScaffoldMessenger.of(context).showSnackBar(
                SnackBar(content: Text("Your name is $name")),
              );
            },
            child: Text("Submit"),
          ),
        ],
      ),
    );
  }
}
