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
    return MaterialApp(
      home: Scaffold(
        body: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            // 🔵 TOP SECTION (Image Placeholder)
            Container(
              height: 200,
              width: double.infinity,
              color: Colors.blueAccent, // Change color as you want
              child: const Center(
                child: Text(
                  "IMAGE PLACEHOLDER",
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 20,
                    fontWeight: FontWeight.bold,
                  ),
                ),
              ),
            ),

            const SizedBox(height: 20),

            // 🔴 TITLE TEXT
            const Padding(
              padding: EdgeInsets.symmetric(horizontal: 16),
              child: Text(
                "This is the title text",
                style: TextStyle(
                  fontSize: 28,
                  color: Colors.redAccent,
                  fontWeight: FontWeight.bold,
                ),
              ),
            ),

            const SizedBox(height: 10),

            // 🟢 DESCRIPTION TEXT
            const Padding(
              padding: EdgeInsets.symmetric(horizontal: 16),
              child: Text(
                "HI, The price range for the Jacob & Co. "
                "Bugatti Chiron Tourbillon spans from around "
                "\$310,000 to \$980,000. However, some ultra-high "
                "avant-garde creations may reach up to \$1 million or more.",
                textAlign: TextAlign.justify,
                style: TextStyle(fontSize: 16, color: Colors.black87),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
