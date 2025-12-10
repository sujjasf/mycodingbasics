import 'package:day7/home_page.dart';
import 'package:day7/login_page.dart';
import 'package:flutter/material.dart';
import 'package:supabase_flutter/supabase_flutter.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();

  await Supabase.initialize(
    url: "https://ybyguljuxpqlbbgyebby.supabase.co",
    anonKey:
        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InlieWd1bGp1eHBxbGJiZ3llYmJ5Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NjUxNDQ3MjgsImV4cCI6MjA4MDcyMDcyOH0.xHA2r_49tpfNRXFZFI-_4SCA3V-3EwAAXrF-8-4fRME",
  );
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Ecommerce',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepOrange),
      ),
      home: Supabase.instance.client.auth.currentUser != null
          ? HomePage()
          : const LoginPage(),
    );
  }
}