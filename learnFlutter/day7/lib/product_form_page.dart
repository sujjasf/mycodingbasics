import 'package:flutter/material.dart';

class ProductFormPage extends StatefulWidget {
  const ProductFormPage({super.key});

  @override
  State<ProductFormPage> createState() => _ProductFormPageState();
}

class _ProductFormPageState extends State<ProductFormPage> {
  TextEditingController namecontroller = TextEditingController();
  TextEditingController priceController = TextEditingController();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Add product")),

      body: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Column(
          children: [
            TextField(
              controller: namecontroller,
              decoration: InputDecoration(
                hintText: "Enter product name",
                border: OutlineInputBorder(),
              ),
            ),

            SizedBox(height: 16),

            TextField(
              controller: priceController,
              decoration: InputDecoration(
                hintText: "Enter product price",
                border: OutlineInputBorder(),
              ),
            ),
            SizedBox(height: 16),

            Container(
              height: 200,
              width: double.maxFinite,
              decoration: BoxDecoration(
                color: Colors.grey,
                borderRadius: BorderRadius.circular(12),
              ),
              child: Icon(Icons.image, size: 100, color: Colors.grey.shade100),
            ),

            SizedBox(height: 24),

            SizedBox(
              height: 48,
              width: double.infinity,
              child: FilledButton(onPressed: () {}, child: Text("Post")),
            ),
          ],
        ),
      ),
    );
  }
}