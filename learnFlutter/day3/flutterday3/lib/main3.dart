import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: const HomePage(),
    );
  }
}

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  int counter = 0100;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.cyan,
        title: Center(child: Text("Counter App")),
      ),

      body: Center(
        child: Text(
          "You have pressed $counter times so far",
          style: const TextStyle(fontSize: 20),
        ),
      ),

      floatingActionButton: FloatingActionButton(
        onPressed: () {
          print("pressed buton");
          setState(() {
            if (counter == 0) return;
            counter--;
          });
        },
        child: const Icon(Icons.add),
      ),
    );
  }
}
