import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> with SingleTickerProviderStateMixin {
  late AnimationController _controller;

  @override
  void initState() {
    super.initState();
    _controller = AnimationController(
      vsync: this,
      duration: const Duration(seconds: 1),
    );
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    // return MaterialApp(
    //   home: Scaffold(
    //     body: Center(
    //       child: Text(
    //         "Hello world",
    //         style: TextStyle(
    //           fontSize: 24,
    //           color: Colors.redAccent,
    //           fontWeight: FontWeight.bold,
    //           ),
    //       ),
    //     ),
    //   ),
    return MaterialApp(
      home: Scaffold(
        body: Row(
          spacing: 100,
          children: [
            Container(height: 100, width: 100, color: Colors.blue),
            SizedBox(width: 10,),
            Container(height: 100, width: 100, color: Colors.red),
            Spacer(),
            Container(height: 100, width: 100, color: Colors.green),
          ],
        ),
      ),
    );
  }
}
