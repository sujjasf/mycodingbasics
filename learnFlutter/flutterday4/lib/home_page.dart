import 'package:flutter/material.dart';

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  TextEditingController controller = TextEditingController();
  List<Todo> todos = [];
  // List<String> todos = [];
  // List<bool> checkBoxes = [];
  @override
  Widget build(BuildContext context) {
    Color bgColor = ColorScheme.of(context).primary;
    return Scaffold(
      appBar: AppBar(
        // backgroundColor: Colors.redAccent,
        backgroundColor: bgColor,
        title: Center(
          child: Text("Todo app", style: TextStyle(color: Colors.white)),
        ),
      ),

      body: Padding(
        padding: EdgeInsets.all(8.0),
        child: Column(
          children: [
            Row(
              spacing: 12,
              children: [
                Expanded(
                  child: TextField(
                    controller: controller,
                    decoration: InputDecoration(
                      hintText: "Enter your task",
                      border: OutlineInputBorder(),
                    ),
                  ),
                ),
                IconButton(
                  onPressed: () {
                    setState(() {
                      todos.add(Todo(title: controller.text));
                    });
                    controller.clear();
                  },
                  icon: Icon(Icons.add),
                ),
              ],
            ),

            SizedBox(height: 16),

            Text(
              "Todos",
              style: TextStyle(fontSize: 36, fontWeight: FontWeight.bold),
            ),

            SizedBox(height: 16),

            Expanded(
              child: ListView.builder(
                itemCount: todos.length,
                // itemCount: 10,
                itemBuilder: (context, index) {
                  return Row(
                    children: [
                      Checkbox(
                        value: todos[index].isChecked,
                        onChanged: (value) {
                          setState(() {
                            todos[index].isChecked = value!;
                          });
                        },
                      ),
                      // Expanded(child: Text("Your todo goes here")),
                      // Expanded(child: Text(todos[index])),
                      Expanded(
                        child: Text(
                          todos[index].title,
                          style: TextStyle(
                            decoration: todos[index].isChecked
                                ? TextDecoration.lineThrough
                                : null,
                          ),
                        ),
                      ),
                      IconButton(
                        onPressed: () {
                          // TextEditingController updateController = TextEditingController(text: Todo[index].title);
                          TextEditingController updateController =
                              TextEditingController(text: todos[index].title);

                          showDialog(
                            context: context,
                            builder: (context) {
                              return AlertDialog(
                                title: Text("Update todo"),
                                content: Column(
                                  mainAxisSize: MainAxisSize.min,
                                  spacing: 12,
                                  children: [
                                    TextField(controller: updateController),
                                    FilledButton(
                                      onPressed: () {
                                        setState(() {
                                          todos[index].title =
                                              updateController.text;
                                        });
                                        // Navigator.pop(context);
                                        Navigator.of(context).pop();
                                      },

                                      child: Text("Update"),
                                    ),
                                  ],
                                ),
                              );
                            },
                          );
                        },
                        icon: Icon(Icons.edit),
                      ),
                      IconButton(
                        onPressed: () {
                          setState(() {
                            todos.remove(todos[index]);
                          });
                        },
                        icon: Icon(Icons.delete),
                      ),
                    ],
                  );
                },
              ),
            ),
          ],
        ),
      ),
    );
  }
}

class Todo {
  String title;
  bool isChecked;

  Todo({required this.title, this.isChecked = false});
}
