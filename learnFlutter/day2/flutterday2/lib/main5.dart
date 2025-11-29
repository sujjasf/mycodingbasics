import 'package:flutter/material.dart';
import 'dart:io';

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
    return MaterialApp(
      home: Scaffold(
        body: SingleChildScrollView( // allows scrolling if content overflows
          child: Container(
            padding: const EdgeInsets.all(16), 
            width: double.infinity,
            color: Colors.cyanAccent,
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                // Full-width image, no cropping
                Image.file(
                  File("/home/sujjalbtw/Downloads/download.jpeg"),
                  width: double.infinity,
                  fit: BoxFit.contain, // keeps full image visible
                ),

                const SizedBox(height: 20),

                const Text(
                  "This is the title text",
                  style: TextStyle(
                    fontSize: 26,
                    fontWeight: FontWeight.bold,
                    color: Colors.redAccent,
                  ),
                ),

                const SizedBox(height: 10),

                const Text(
                  "HI, The price range for the Jacob & Co. Bugatti Chiron "
                  "Tourbillon spans from around \$310,000 to \$980,000. "
                  "Some designs may reach up to \$1 million or more.",
                  style: TextStyle(fontSize: 16),
                ),
              ],
            ),
            
          ),
        ),
      ),
    );
  }
}
