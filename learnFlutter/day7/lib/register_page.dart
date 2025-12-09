import 'package:day7/helper.dart';
import 'package:day7/home_page.dart';
import 'package:flutter/material.dart';
import 'package:supabase_flutter/supabase_flutter.dart';

class RegisterPage extends StatefulWidget {
  const RegisterPage({super.key});

  @override
  State<RegisterPage> createState() => _RegisterPageState();
}

class _RegisterPageState extends State<RegisterPage> {
  TextEditingController emailController = TextEditingController();
  TextEditingController passwordController = TextEditingController();
  bool isObscure = true;
  bool isLoading = false;

  @override
  void dispose() {
    emailController.dispose();
    passwordController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(8.0),
          child: Card(
            child: Padding(
              padding: const EdgeInsets.all(16.0),
              child: Column(
                mainAxisSize: MainAxisSize.min,
                children: [
                  Text(
                    "Register Page",
                    style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
                  ),
                  SizedBox(height: 16),
                  TextField(
                    controller: emailController,
                    decoration: InputDecoration(
                      hintText: "Enter your Email",
                      border: OutlineInputBorder(),
                    ),
                  ),
                  SizedBox(height: 16),
                  TextField(
                    controller: passwordController,
                    obscureText: isObscure,
                    decoration: InputDecoration(
                      suffixIcon: IconButton(
                        onPressed: () {
                          setState(() {
                            isObscure = !isObscure;
                          });
                        },
                        icon: Icon(
                          isObscure ? Icons.visibility : Icons.visibility_off,
                        ),
                      ),
                      hintText: "Enter your Password",
                      border: OutlineInputBorder(),
                    ),
                  ),
                  SizedBox(height: 16),
                  FilledButton(
                    onPressed: isLoading
                        ? null
                        : () async {
                            if (emailController.text.isEmpty ||
                                passwordController.text.isEmpty) {
                              showSnackBar(
                                context,
                                "Provide email or password",
                              );
                              return;
                            }

                            setState(() => isLoading = true);
                            try {
                              final res = await Supabase.instance.client.auth
                                  .signUp(
                                    email: emailController.text.trim(),
                                    password: passwordController.text,
                                  );

                              // Newer gotrue response doesn't expose `error` the same way.
                              // Treat presence of a user as success.
                              if (res.user != null) {
                                showSnackBar(
                                  context,
                                  "Registration successful.",
                                );
                                Navigator.of(context).pushReplacement(
                                  MaterialPageRoute(
                                    builder: (context) => HomePage(),
                                  ),
                                );
                                emailController.clear();
                                passwordController.clear();
                                // Optionally navigate to login or pop:
                                // Navigator.of(context).pushReplacementNamed('/login');
                              } else {
                                // No user -> failed signup. Show the response for debugging.
                                showSnackBar(
                                  context,
                                  "Signup failed: ${res.toString()}",
                                );
                              }
                            } catch (e) {
                              showSnackBar(
                                context,
                                "Signup failed: ${e.toString()}",
                              );
                            } finally {
                              if (mounted) setState(() => isLoading = false);
                            }
                          },
                    child: isLoading
                        ? SizedBox(
                            height: 16,
                            width: 16,
                            child: CircularProgressIndicator(strokeWidth: 2),
                          )
                        : Text("Register"),
                  ),
                  SizedBox(height: 16),
                  FilledButton(onPressed: () {}, child: Text("Login")),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}
